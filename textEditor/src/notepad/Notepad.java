package notepad;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import action.Action;

public class Notepad {

    public int id = 1;
    private String notepad[];
    private Stack<Action> undoAction;
    private Stack<Action> redoAction;
    private Queue<String> clipboard;
    private int capacity;

    public Notepad(int capacity) {

        notepad = new String[capacity];
        undoAction = new Stack<>();
        redoAction = new Stack<>();
        clipboard = new LinkedList<>();
        this.capacity = capacity;
        for (int i = 0; i < this.capacity; i++) {
            notepad[i] = "";
        }
    }

    public void display() {

        for (int i = 0; i < capacity; i++) {
            System.out.println(notepad[i]);
        }
    }

    public void display(int startLineNo, int endLineNo) {

        if (startLineNo < 0 || startLineNo > endLineNo || endLineNo >= capacity) {

            System.out.println("Unable to display!!\n check input again");
            return;
        }
        for (int i = startLineNo; i <= endLineNo; i++) {
            System.out.println(notepad[i]);
        }
    }

    public void insert(int lineNumber, String text) {

        if (lineNumber > capacity || lineNumber < 1) {
            System.out.println("Invalid line number!!\nplease check the input once");
            return;
        }
        notepad[lineNumber - 1] = text;
        undoAction.push(new Action(id++, LocalDateTime.now(), true, lineNumber, text));
    }

    public void delete(int lineNumber) {

        if (lineNumber > capacity || lineNumber < 1) {
            System.out.println("Invalid line number\nplease check the input once");
            return;
        }
        if (notepad[lineNumber - 1].isEmpty()) {
            System.out.println("Nothing to delete");
            return;
        }
        redoAction.push(new Action(id++, LocalDateTime.now(), false, lineNumber, notepad[lineNumber - 1]));
        notepad[lineNumber - 1] = "";
    }

    public void delete(int startLine, int endLine) {

        if (startLine > endLine || startLine < 1 || endLine > capacity) {
            System.out.println("Delete not possible!!\nplease check the input once");
            return;
        }
        for (int i = startLine - 1; i < endLine; i++) {

            delete(i);
        }
    }

    public void copy(int startLine, int endLine) {

        if (startLine > endLine || startLine < 1 || endLine > capacity) {
            System.out.println("Unable to copy!!\ncheck the input");
            return;
        }
        String cpyTxt = "";
        for (int i = startLine - 1; i < endLine; i++) {
            cpyTxt += (notepad[i] + "\n");
        }
        if (!cpyTxt.isEmpty())
            clipboard.add(cpyTxt);
    }

    public void paste(int lineno) {

        if (clipboard.isEmpty()) {
            System.out.println("Nothing to paste");
            return;
        }
        String s = clipboard.poll();
        insert(lineno, s);
    }

    public void undo() {

        if (undoAction.isEmpty()) {
            System.out.println("Nothing to undo");
            return;
        }
        Action latestAction = undoAction.pop();
        delete(latestAction.getLineNo());
    }

    public void redo() {

        if (redoAction.isEmpty()) {
            System.out.println("Nothing to redo");
            return;
        }
        Action latestAction = redoAction.pop();
        insert(latestAction.getLineNo(), latestAction.getText());
    }
}

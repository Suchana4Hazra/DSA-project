import java.util.Scanner;
import notepad.Notepad;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, This is a text editor made by me!");

        Scanner sr = new Scanner(System.in);
        Notepad notepad = new Notepad(100);

        do {

            System.out.println("Enter 1 to Display the text");
            System.out.println("Enter 2 to display the text from given lines");
            System.out.println("Enter 3 to insert a text");
            System.out.println("Enter 4 to delete the text");
            System.out.println("Enter 5 to delete the text from given lines");
            System.out.println("Enter 6 to copy the text");
            System.out.println("Enter 7 to paste the text");
            System.out.println("Enter 8 to undo the choice");
            System.out.println("Enter 9 to redo the choice");
            System.out.println("Exit");

            System.out.println("Enter your choice: ");
            int ch = sr.nextInt();
            int lineNo = 0, start = 0, end = 0;

            switch (ch) {

                case 1:
                    notepad.display();
                    break;
                case 2:
                    System.out.println("Enter startLine and endLine no: ");
                    start = sr.nextInt();
                    end = sr.nextInt();
                    notepad.display(start, end);
                    break;
                case 3:
                    System.out.println("Enter line no: ");
                    lineNo = sr.nextInt();
                    System.out.println("Enter the input string:");
                    String str = sr.next();
                    notepad.insert(lineNo, str);
                    break;
                case 4:
                    System.out.println("Enter line no");
                    lineNo = sr.nextInt();
                    notepad.delete(lineNo);
                    break;
                case 5:
                    System.out.println("Enter startLine and endLine no: ");
                    start = sr.nextInt();
                    end = sr.nextInt();
                    notepad.delete(start, end);
                    break;
                case 6:
                    System.out.println("Enter startLine and endLine no: ");
                    start = sr.nextInt();
                    end = sr.nextInt();
                    notepad.copy(start, end);
                    break;
                case 7:
                    System.out.println("Enter line no:");
                    lineNo = sr.nextInt();
                    notepad.paste(lineNo);
                    break;
                case 8:
                    notepad.undo();
                    break;
                case 9:
                    notepad.redo();
                    break;
                case 10:
                    System.exit(0);
                default:
                    System.out.println("Invalid choice");
            }

        } while (true);

    }
}

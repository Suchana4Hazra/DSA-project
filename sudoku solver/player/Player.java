package player;

public class Player {

    String name;
    int age;

    public Player() {

        this.name = name;
        this.age = age;
    }
    public Player(String nm, int a) {

        name = nm;
        age = a;
    }

    public void printPlayerDetails() {

        System.out.println("Name: "+name);
        System.out.println("Age: "+age);
    }
    public String getName() {

        return this.name;
    }

}

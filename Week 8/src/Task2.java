class Teacher{
    String name;
    public Teacher(String name) {
        this.name = name;
    }
    void abc(){
        System.out.println("Hadi Shahid");
    }

}

class Depart{
    String name;
    void cdf(){
        System.out.println("2026-CYS-36");
    }

    public Depart(Teacher b) {
        this.b = b;
    }

    Teacher  b;
    void display(){
        System.out.println(b.name);
    }
    void mgh(){
        System.out.println("OOP");
    }
}

public class Task2 {
    public static void main(String[] args) {
        Teacher c = new Teacher("Hafiz Mubashar");
        Depart n = new Depart(c);
        n.display();
        n.mgh();
        c.abc();
        n.cdf();

    }
}
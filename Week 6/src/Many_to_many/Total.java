package Many_to_many;

public class Total {
    static void main(String[] args) {
        Course ai = new Course("AI");
        Course oop = new Course("Oop");
        Student std = new Student("Hadi Shahid");
        Student std1 = new Student("Mahar Zohaib");
        std.c1 = "AI";
        std1.c2 = "Oop";
        System.out.println(std.c1);
        System.out.println(std1.c2);

    }
}

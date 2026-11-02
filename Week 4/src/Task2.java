class Student{
    private String name;
    private int age;
    private String roll;

    public Student(String name, int age, String roll) {
        this.name = name;
        this.age = age;
        this.roll = roll;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getRoll() {
        return roll;
    }

    public void setRoll(String roll) {
        this.roll = roll;
    }
}
public class Task2{
    static void main(String[] args) {
        Student b = new Student("Hadi Shahid",17,"2026-Cys-36");
        System.out.println(b.getName());
        System.out.println(b.getAge());
        System.out.println(b.getRoll());
    }
}

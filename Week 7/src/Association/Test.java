package Association;

public class Test {
    static void main(String[] args) {
        Student n = new Student();
        Teacher m = new Teacher();
        m.s = n;
        m.Display();

    }
}

package Association;

public class Total_Cars {
    static void main(String[] args) {
        Car n = new Car();
        Company m = new Company();
        m.c = n;

        System.out.println(n);
    }
}

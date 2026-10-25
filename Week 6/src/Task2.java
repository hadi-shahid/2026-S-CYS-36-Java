class Engine{
    void Start(){
        System.out.println("Engine Starts");
    }
}

class Car{
    private Engine s1;

    public Car(Engine s1) {
        this.s1 = s1;
    }

    void Drive(){
        s1.Start();
        System.out.println("Car Starts.");

    }
}

public class Task2 {
    static void main(String[] args) {
        Engine s=new Engine();
        Car b = new Car(s);
        b.Drive();
        System.out.println("I am Driving");

    }
}
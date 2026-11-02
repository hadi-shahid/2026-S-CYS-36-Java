class room{
    String name;
    public room(String name) {
        this.name = name;
    }
    void abc(){
        System.out.println("Hadi Shahid");
    }
}

class house{
    room r=new room("CE001");
    void display(){
        System.out.println(r.name);
    }

    @Override
    public String toString() {
        return "house{" +
                "r=" + r +
                '}';
    }
}


public class Task3 {
    public static void main(String[] args) {
        house n = new house();
        room c = new room("Hello");
        n.display();
        c.abc();

    }

}
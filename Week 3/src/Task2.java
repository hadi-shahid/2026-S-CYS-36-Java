class encapsulation{
        String name;
        private int age = 18;
        private String cnic;

    public int getAge() {
        return age;
    }


    public String getCnic() {
        return cnic;
    }

    public void setCnic(String cnic) {
        
        this.cnic = cnic;
    }
}
public class Task2{
    static void main(String[] args) {
        encapsulation t = new encapsulation();
        t.name = "Muhammad Hadi Shahid";
        t.setCnic("30201-3561882-1");
        System.out.println(t.getAge());
        System.out.println(t.name);
        System.out.println(t.getCnic());


    }
}
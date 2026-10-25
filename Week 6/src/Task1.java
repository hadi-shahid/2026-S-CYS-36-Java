    class Students{
        String name;
        public Students(String name){
        this.name = name;
    }
        }
    class Teacher{
    void Student(Students s1){
        System.out.println(s1.name);
    }

    }
public class Task1{
    static void main(String[] args) {
        Students s = new Students("Hadi Shahid");
        Teacher t = new Teacher();
        t.Student(s);

    }

        }
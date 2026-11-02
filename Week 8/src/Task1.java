class Book{
    String name;

    public Book(String name) {
        this.name = name;
    }
    void abc(){
        System.out.println("Hadi Shahid");
    }

}

class Library{
    String name;
    void cdf(){
        System.out.println("2026-CYS-36");
    }

    public Library(Book b) {
        this.b = b;
    }
    Book b;
    void display(){
        System.out.println(b.name);
    }
}

public class Task1 {
    public static void main(String[] args) {
        Book c = new Book("Java");
        Library n = new Library(c);
        n.display();
        c.abc();
        n.cdf();
    }
}
class Human{
    String Name = "Hadi Shahid";
    String Roll = "2026(S)-Cys-36";

    @Override
    public String toString() {
        return "Human{" +
                "Name='" + Name + '\'' +
                ", Roll='" + Roll + '\'' +
                '}';
    }
}
class Task1{
    static void main(String[] args) {
        Human n = new Human();
        Human r = new Human();
        System.out.println(n.Name);
        System.out.println(r.Roll);
    }

}

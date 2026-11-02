import java.util.Scanner;

class Walls {
    private String flavor;
    private int scoops;
    private String cone;
    private int price;

    // No arguments: default values
    public Walls() {
        this("Vanilla", 1, "Sugar");
    }

    public Walls(String flavor, int scoops, String cone) {
        this.flavor = flavor;
        this.scoops = scoops;
        this.cone = cone;
        price = 75 * scoops;
        if (cone.equals("Waffle")) {
            price += 40;
        }
    }

    public void show() {
        System.out.println("Flavor: " + flavor);
        System.out.println("Scoops: " + scoops);
        System.out.println("Cone:   " + cone);
        System.out.println("Price:  Rs. " + price);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Choose flavor (press Enter to skip):");
        System.out.println("1.Chocolate    2.Vanilla ");
        System.out.println("3.Strawberry   4.Mango");
        System.out.println("5.Tutti Fruit  6.Almond Crunch");
        System.out.println("7.Coffee");
        String f = sc.nextLine().trim();
        String flavor = "Vanilla";
        switch (f) {
            case "1": flavor = "Chocolate"; break;
            case "2": flavor = "Vanilla"; break;
            case "3": flavor = "Strawberry"; break;
            case "4": flavor = "Mango"; break;
            case "5": flavor = "Tutti Fruit"; break;
            case "6": flavor = "Almond Crunch"; break;
            case "7": flavor = "Coffee"; break;
        }

        System.out.print("Number of scoops (press Enter to skip): ");
        String s = sc.nextLine().trim();
        int scoops = 1;
        if (!s.isEmpty()) {
            scoops = Integer.parseInt(s);
        }

        System.out.println("Cone type (press Enter to skip): 1.Sugar 2.Waffle");
        String c = sc.nextLine().trim();
        String cone = "Sugar";
        if (c.equals("2")) {
            cone = "Waffle";
        }

        Walls order;
        if (f.isEmpty() && s.isEmpty() && c.isEmpty()) {
            order = new Walls();
        } else {
            order = new Walls(flavor, scoops, cone);
        }

        System.out.println();
        order.show();
    }
}
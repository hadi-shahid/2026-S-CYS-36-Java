import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

class Field {
    private List<int[]> obstacles = new ArrayList<>();

    public void addObstacle(int x, int y) {
        obstacles.add(new int[]{x, y});
    }

    public boolean isObstacle(int x, int y) {
        for (int[] o : obstacles) {
            if (o[0] == x && o[1] == y) {
                return true;
            }
        }
        return false;
    }
}

abstract class Walker {
    protected String name;
    protected int x;
    protected int y;
    protected Field field;

    public Walker(String name, Field field) {
        this.name = name;
        this.field = field;
        this.x = 0;
        this.y = 0;
    }

    protected void moveBy(int dx, int dy) {
        int nx = x + dx;
        int ny = y + dy;
        if (field.isObstacle(nx, ny)) {
            System.out.println(name + " encounters hurdle at [" + nx + ":" + ny + "]");
        } else {
            x = nx;
            y = ny;
        }
    }

    public String location() {
        return x + " : " + y;
    }

    public void printLocation() {
        System.out.println(name + " is at = " + location());
    }
}

class DirectedWalker extends Walker {

    public DirectedWalker(String name, Field field) {
        super(name, field);
    }

    public void move(char direction) {
        switch (direction) {
            case 'w': moveBy(0, 1);  break;
            case 's': moveBy(0, -1); break;
            case 'a': moveBy(-1, 0); break;
            case 'd': moveBy(1, 0);  break;
            default:
                System.out.println("Invalid direction. Use w s a d");
        }
    }
}

class RandomWalker extends Walker {
    private final Random random = new Random();

    public RandomWalker(String name, Field field) {
        super(name, field);
    }

    public void move() {
        switch (random.nextInt(4)) {
            case 0: moveBy(0, 1);  break;
            case 1: moveBy(0, -1); break;
            case 2: moveBy(-1, 0); break;
            default: moveBy(1, 0); break;
        }
    }
}

class Task2 {
    public static void main(String[] args) {
        Field field = new Field();
        field.addObstacle(1, 2);
        field.addObstacle(-1, 1);
        field.addObstacle(2, -1);

        DirectedWalker ali = new DirectedWalker("Ali", field);
        RandomWalker hasan = new RandomWalker("Hasan", field);

        Scanner sc = new Scanner(System.in);
        System.out.println("Starting: Ali's Location is = " + ali.location()
                + "   Hassan's Location is = " + hasan.location());
        System.out.println("Hasan has Random Movement, Ali follows order");
        System.out.println("(Directions: w s a d   |   q = quit)");

        while (true) {
            System.out.print("\nALi: Where should i go now: ");
            String input = sc.next();
            if (input.equalsIgnoreCase("q")) {
                break;
            }
            ali.move(input.charAt(0));
            hasan.move();

            ali.printLocation();
            hasan.printLocation();
        }
        sc.close();
    }
}
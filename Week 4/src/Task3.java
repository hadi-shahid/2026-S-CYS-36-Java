import java.util.Random;
import java.util.Scanner;

public class Task3 {

    static boolean isObstacle(int x, int y) {
        return (x == 1 && y == 2) || (x == -1 && y == 1)
                || (x == 2 && y == -1) || (x == 0 && y == -3);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rnd = new Random();

        int aliX = 0, aliY = 0;
        int hasanX = 0, hasanY = 0;

        System.out.println("Starting: Ali's Location is = (0 : 0) Hasan's Location is = (0 : 0)");
        System.out.println("Hasan has Random Movement, Ali follows order (w/s/a/d, q to quit)");

        while (true) {
            System.out.print("Ali: Where should I go now: ");
            char in = sc.next().charAt(0);
            if (in == 'q') break;

            int dx = 0, dy = 0;
            if (in == 'w') dy = 1;
            else if (in == 's') dy = -1;
            else if (in == 'a') dx = -1;
            else if (in == 'd') dx = 1;
            else {
                System.out.println("Invalid move.");
                continue;
            }

            if (isObstacle(aliX + dx, aliY + dy)) {
                System.out.println("Ali encounters hurdle at (" + (aliX + dx) + ":" + (aliY + dy) + ")");
            } else {
                aliX += dx;
                aliY += dy;
            }
            System.out.println("Ali is at = (" + aliX + " : " + aliY + ")");

            // Hasan moves randomly: 0=up, 1=down, 2=left, 3=right
            int r = rnd.nextInt(4);
            int hx = 0, hy = 0;
            if (r == 0) hy = 1;
            else if (r == 1) hy = -1;
            else if (r == 2) hx = -1;
            else hx = 1;

            if (isObstacle(hasanX + hx, hasanY + hy)) {
                System.out.println("Hasan encounters hurdle at (" + (hasanX + hx) + ":" + (hasanY + hy) + ")");
            } else {
                hasanX += hx;
                hasanY += hy;
            }
            System.out.println("Hasan is at = (" + hasanX + " : " + hasanY + ")");
        }
        sc.close();
    }
}
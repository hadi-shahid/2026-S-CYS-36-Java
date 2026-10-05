import java.util.Scanner;

public class Task4 {
    static void main() {
        int [] arr = {2,4,5,3,32,78,6,54,9,8,12};
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Start Number : ");
        int s = sc.nextInt();

        System.out.println(("Enter End Number : "));
        int e = sc.nextInt();

        System.out.println(("Enter Jump Number : "));
        int I = sc.nextInt();

        for (int i = s ; i<e ; i+=I)

        {
            System.out.println(arr[i]);
        }


    }
}


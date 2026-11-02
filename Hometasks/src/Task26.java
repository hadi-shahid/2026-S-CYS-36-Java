public class Task26 {
    static int power(int base, int exp) {
        int result = 1;
        for (int i = 0; i < exp; i++) {
            result *= base;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println("Armstrong numbers from 1 to 1000:");
        for (int n = 1; n <= 1000; n++) {
            int digits = 0;
            for (int t = n; t > 0; t /= 10) {
                digits++;
            }
            int sum = 0;
            for (int t = n; t > 0; t /= 10) {
                sum += power(t % 10, digits);
            }
            if (sum == n) {
                System.out.print(n + " ");
            }
        }
        System.out.println();
    }
}

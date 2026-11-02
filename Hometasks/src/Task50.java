public class Task50 {
    public static void main(String[] args) {
        int[] digits = new int[70];
        digits[0] = 1;
        int length = 1;
        for (int f = 2; f <= 50; f++) {
            int carry = 0;
            for (int i = 0; i < length; i++) {
                int v = digits[i] * f + carry;
                digits[i] = v % 10;
                carry = v / 10;
            }
            while (carry > 0) {
                digits[length++] = carry % 10;
                carry /= 10;
            }
        }
        System.out.print("50! = ");
        for (int i = length - 1; i >= 0; i--) {
            System.out.print(digits[i]);
        }
        System.out.println();
    }
}

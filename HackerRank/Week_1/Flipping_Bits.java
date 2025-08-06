import java.util.*;

public class Solution {

    public static long flippingBits(long n) {
        return ~n & 0xFFFFFFFFL;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int q = scanner.nextInt();  // Number of queries

        for (int i = 0; i < q; i++) {
            long n = scanner.nextLong();  // 32-bit unsigned integer
            System.out.println(flippingBits(n));
        }
    }
}

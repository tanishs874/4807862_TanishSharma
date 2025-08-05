import java.util.Scanner;

public class Solution {
    public static void plusssss_minussss(int[] arr) {
        int tanish = arr.length;
        int tanish_positive_count = 0;
        int tanish_negative_count = 0;
        int tanish_zero_count = 0;

        for (int num : arr) {
            if (num > 0) {
                tanish_positive_count++;
            } else if (num < 0) {
                tanish_negative_count++;
            } else {
                tanish_zero_count++;
            }
        }

        double tanish_positive_ratio = (double) tanish_positive_count / tanish;
        double tanish_negative_ratio = (double) tanish_negative_count / tanish;
        double tanish_zero_ratio = (double) tanish_zero_count / tanish;

        System.out.printf("%.6f%n", tanish_positive_ratio);
        System.out.printf("%.6f%n", tanish_negative_ratio);
        System.out.printf("%.6f%n", tanish_zero_ratio);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tanish = scanner.nextInt();
        int[] arr = new int[tanish];

        for(int i = 0; i < tanish; i++) {
            arr[i] = scanner.nextInt();
        }

        plusssss_minussss(arr);
        scanner.close();
    }
}

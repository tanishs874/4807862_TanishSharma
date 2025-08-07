import java.util.*;

public class Solution {
    public static String twoArrays(int tanish, int[] boss, int[] sharma) {
        Arrays.sort(boss);
        Arrays.sort(sharma);
        int n = boss.length;
        for (int i = 0; i < n / 2; i++) {
            int temp = sharma[i];
            sharma[i] = sharma[n - 1 - i];
            sharma[n - 1 - i] = temp;
        }
        for (int i = 0; i < n; i++) {
            if (boss[i] + sharma[i] < tanish) {
                return "NO";
            }
        }
        return "YES";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int queries = sc.nextInt();
        while (queries-- > 0) {
            int size = sc.nextInt();
            int tanish = sc.nextInt();
            int[] boss = new int[size];
            int[] sharma = new int[size];
            for (int i = 0; i < size; i++) {
                boss[i] = sc.nextInt();
            }
            for (int i = 0; i < size; i++) {
                sharma[i] = sc.nextInt();
            }
            System.out.println(twoArrays(tanish, boss, sharma));
        }
        sc.close();
    }
}

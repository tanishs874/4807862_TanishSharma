import java.util.*;

public class Solution {
    public static void plusssss_minussss(List<Integer> tanish_arr) {
        long tanish_total = 0;
        int tanish_min = tanish_arr.get(0);
        int tanish_max = tanish_arr.get(0);

        for (int tanish_num : tanish_arr) {
            tanish_total += tanish_num;
            if (tanish_num < tanish_min) {
                tanish_min = tanish_num;
            }
            if (tanish_num > tanish_max) {
                tanish_max = tanish_num;
            }
        }

        long tanish_min_sum = tanish_total - tanish_max;
        long tanish_max_sum = tanish_total - tanish_min;

        System.out.println(tanish_min_sum + " " + tanish_max_sum);
    }

    public static void main(String[] args) {
        Scanner tanish_input = new Scanner(System.in);
        List<Integer> tanish_arr = new ArrayList<>();

        for (int tanish_i = 0; tanish_i < 5; tanish_i++) {
            tanish_arr.add(tanish_input.nextInt());
        }

        plusssss_minussss(tanish_arr);
    }
}

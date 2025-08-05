import java.util.*;

public class Solution {

    public static List<Integer> tanish_matchingStrings(List<String> tanish_strings, List<String> tanish_queries) {
        Map<String, Integer> tanish_freqMap = new HashMap<>();
        for (String tanish_str : tanish_strings) {
            tanish_freqMap.put(tanish_str, tanish_freqMap.getOrDefault(tanish_str, 0) + 1);
        }
        List<Integer> tanish_resultList = new ArrayList<>();

        for (String tanish_query : tanish_queries) {
            tanish_resultList.add(tanish_freqMap.getOrDefault(tanish_query, 0));
        }

        return tanish_resultList;
    }

    public static void main(String[] args) {
        Scanner tanish_sc = new Scanner(System.in);

        int tanish_n = Integer.parseInt(tanish_sc.nextLine());
        List<String> tanish_strings = new ArrayList<>();

        for (int tanish_i = 0; tanish_i < tanish_n; tanish_i++) {
            tanish_strings.add(tanish_sc.nextLine());
        }

        int tanish_q = Integer.parseInt(tanish_sc.nextLine());
        List<String> tanish_queries = new ArrayList<>();

        for (int tanish_j = 0; tanish_j < tanish_q; tanish_j++) {
            tanish_queries.add(tanish_sc.nextLine());
        }

        List<Integer> tanish_output = tanish_matchingStrings(tanish_strings, tanish_queries);

        for (int tanish_count : tanish_output) {
            System.out.println(tanish_count);
        }

        tanish_sc.close();
    }
}

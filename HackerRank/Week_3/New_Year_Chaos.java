import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'minimumBribes' function below.
     *
     * The function accepts INTEGER_ARRAY q as parameter.
     * Print the minimum number of bribes or "Too chaotic".
     */
    public static void minimumBribes(List<Integer> q) {
        int n = q.size();
        long bribes = 0;

        // Quick feasibility check: no one can move more than two places forward
        for (int i = 0; i < n; i++) {
            int sticker = q.get(i);
            if (sticker - (i + 1) > 2) {
                System.out.println("Too chaotic");
                return;
            }
        }

        // Count bribes: bounded inversion count
        for (int i = 0; i < n; i++) {
            int s = q.get(i);
            // People who could have bribed s are those with sticker > s
            // starting from index max(0, s-2-1) to i-1
            int start = Math.max(0, s - 2 - 1);
            for (int j = start; j < i; j++) {
                if (q.get(j) > s) bribes++;
            }
        }

        System.out.println(bribes);
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());
                List<Integer> q = Stream.of(bufferedReader.readLine().trim().split(" "))
                        .map(Integer::parseInt)
                        .collect(toList());

                Result.minimumBribes(q);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
    }
}

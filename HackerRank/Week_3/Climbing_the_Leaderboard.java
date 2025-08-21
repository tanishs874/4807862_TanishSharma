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
     * Complete the 'climbingLeaderboard' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY ranked
     *  2. INTEGER_ARRAY player
     */
    public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {

        // Build list of unique scores from the existing leaderboard (descending)
        List<Integer> unique = new ArrayList<>(ranked.size());
        Integer prev = null;
        for (int score : ranked) {
            if (prev == null || score != prev) unique.add(score);
            prev = score;
        }

        // Start from the lowest unique leaderboard score
        int i = unique.size() - 1;

        List<Integer> result = new ArrayList<>(player.size());

        // Player scores are in ascending order per constraints; single linear pass
        for (int p : player) {
            while (i >= 0 && p >= unique.get(i)) i--;
            // i now points to the last score strictly greater than p
            result.add(i + 2); // rank is index+2
        }

        return result;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int rankedCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> ranked = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int playerCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> player = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = Result.climbingLeaderboard(ranked, player);

        bufferedWriter.write(
            result.stream()
                  .map(Object::toString)
                  .collect(joining("\n"))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}

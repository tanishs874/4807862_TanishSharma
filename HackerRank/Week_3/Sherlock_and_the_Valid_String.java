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
     * Complete the 'isValid' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */
    public static String isValid(String s) {
        // Count character frequencies (only 'a'..'z' per constraints)
        int[] freq = new int[26];
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }

        // Map frequency -> count of letters having that frequency
        Map<Integer, Integer> freqCount = new HashMap<>();
        for (int f : freq) {
            if (f == 0) continue;
            freqCount.put(f, freqCount.getOrDefault(f, 0) + 1);
        }

        if (freqCount.size() == 1) {
            // All characters share the same frequency
            return "YES";
        }

        if (freqCount.size() > 2) {
            return "NO";
        }

        // Exactly two different frequencies
        Iterator<Map.Entry<Integer,Integer>> it = freqCount.entrySet().iterator();
        Map.Entry<Integer,Integer> e1 = it.next();
        Map.Entry<Integer,Integer> e2 = it.next();

        int f1 = e1.getKey(), c1 = e1.getValue();
        int f2 = e2.getKey(), c2 = e2.getValue();

        // Normalize so that fHigh >= fLow
        int fHigh = f1, cHigh = c1, fLow = f2, cLow = c2;
        if (f2 > f1) { fHigh = f2; cHigh = c2; fLow = f1; cLow = c1; }

        // Two ways to be valid with a single removal:
        // 1) Remove one occurrence of a single character whose freq is 1
        if (fLow == 1 && cLow == 1) return "YES";

        // 2) Decrease the character with the higher frequency by 1
        //    to match the lower frequency (must differ by exactly 1)
        if (fHigh - fLow == 1 && cHigh == 1) return "YES";

        return "NO";
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result.isValid(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

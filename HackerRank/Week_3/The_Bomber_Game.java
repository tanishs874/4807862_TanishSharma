import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'bomberMan' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. STRING_ARRAY grid
     */

    public static List<String> bomberMan(int n, List<String> grid) {

        int rows = grid.size();
        int cols = grid.get(0).length();

        // 1) Time = 1: nothing changes
        if (n == 1) return grid;

        // 2) Every even second: full of bombs
        if (n % 2 == 0) return filledWithBombs(rows, cols);

        // Helper: convert to char matrix once
        char[][] initial = toMatrix(grid);

        // 3) First detonation pattern (time 3, 7, 11,...)
        char[][] afterFirst = detonate(initial);

        if (n % 4 == 3) return toList(afterFirst);

        // 4) Second detonation pattern (time 5, 9, 13,...)
        char[][] afterSecond = detonate(afterFirst);
        return toList(afterSecond);
    }

    // Create full 'O' grid
    private static List<String> filledWithBombs(int r, int c) {
        char[] line = new char[c];
        Arrays.fill(line, 'O');
        String row = new String(line);
        List<String> ans = new ArrayList<>(r);
        for (int i = 0; i < r; i++) ans.add(row);
        return ans;
        // O(r*c) construct once, reused by String row
    }

    private static char[][] toMatrix(List<String> grid) {
        int r = grid.size(), c = grid.get(0).length();
        char[][] g = new char[r][c];
        for (int i = 0; i < r; i++) g[i] = grid.get(i).toCharArray();
        return g;
    }

    private static List<String> toList(char[][] g) {
        int r = g.length;
        List<String> out = new ArrayList<>(r);
        for (int i = 0; i < r; i++) out.add(new String(g[i]));
        return out;
    }

    /**
     * Detonation rule:
     * Start from a fully-bombed board, then clear all cells which currently
     * have a bomb in `seed` and their 4-neighbours.
     */
    private static char[][] detonate(char[][] seed) {
        int r = seed.length, c = seed[0].length;
        char[][] next = new char[r][c];

        // Start filled with bombs
        for (int i = 0; i < r; i++) Arrays.fill(next[i], 'O');

        // Mark cells to clear
        boolean[][] clear = new boolean[r][c];
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (seed[i][j] == 'O') {
                    clear[i][j] = true;
                    for (int k = 0; k < 4; k++) {
                        int ni = i + dx[k], nj = j + dy[k];
                        if (0 <= ni && ni < r && 0 <= nj && nj < c) {
                            clear[ni][nj] = true;
                        }
                    }
                }
            }
        }

        // Apply clearing
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (clear[i][j]) next[i][j] = '.';
            }
        }
        return next;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int r = Integer.parseInt(firstMultipleInput[0]);
        int c = Integer.parseInt(firstMultipleInput[1]);
        int n = Integer.parseInt(firstMultipleInput[2]);

        List<String> grid = IntStream.range(0, r).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }).collect(toList());

        List<String> result = Result.bomberMan(n, grid);

        bufferedWriter.write(
                result.stream().collect(joining("\n")) + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}

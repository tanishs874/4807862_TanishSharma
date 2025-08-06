import java.util.*;

public class DiagonalTanish {

    public static int tanishDiagonalDifference(List<List<Integer>> tanishArr) {
        int tanishLeftToRight = 0;
        int tanishRightToLeft = 0;
        int tanishN = tanishArr.size();

        for (int tanishI = 0; tanishI < tanishN; tanishI++) {
            tanishLeftToRight += tanishArr.get(tanishI).get(tanishI);
            tanishRightToLeft += tanishArr.get(tanishI).get(tanishN - 1 - tanishI);
        }

        return Math.abs(tanishLeftToRight - tanishRightToLeft);
    }

    public static void main(String[] args) {
        Scanner tanishScanner = new Scanner(System.in);
        int tanishN = tanishScanner.nextInt();
        List<List<Integer>> tanishMatrix = new ArrayList<>();

        for (int i = 0; i < tanishN; i++) {
            List<Integer> tanishRow = new ArrayList<>();
            for (int j = 0; j < tanishN; j++) {
                tanishRow.add(tanishScanner.nextInt());
            }
            tanishMatrix.add(tanishRow);
        }

        int tanishResult = tanishDiagonalDifference(tanishMatrix);
        System.out.println(tanishResult);
    }
}

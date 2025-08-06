import java.util.*;

public class CountingTanishSort {

    public static List<Integer> tanishCountingSort(List<Integer> tanishArr) {
        List<Integer> tanishFreq = new ArrayList<>(Collections.nCopies(100, 0));

        for (int tanishNum : tanishArr) {
            tanishFreq.set(tanishNum, tanishFreq.get(tanishNum) + 1);
        }

        return tanishFreq;
    }

    public static void main(String[] args) {
        Scanner tanishScanner = new Scanner(System.in);
        int tanishN = tanishScanner.nextInt();
        List<Integer> tanishInput = new ArrayList<>();

        for (int i = 0; i < tanishN; i++) {
            tanishInput.add(tanishScanner.nextInt());
        }

        List<Integer> tanishResult = tanishCountingSort(tanishInput);
        for (int tanishVal : tanishResult) {
            System.out.print(tanishVal + " ");
        }
    }
}

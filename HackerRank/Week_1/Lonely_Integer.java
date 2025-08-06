import java.util.*;

public class LonelyTanish {
    public static int tanishUniqueFinder(List<Integer> tanishList) {
        int tanishResult = 0;
        for (int tanishNum : tanishList) {
            tanishResult ^= tanishNum;
        }
        return tanishResult;
    }

    public static void main(String[] args) {
        Scanner tanishScanner = new Scanner(System.in);
        int tanishN = tanishScanner.nextInt();
        List<Integer> tanishArr = new ArrayList<>();

        for (int i = 0; i < tanishN; i++) {
            tanishArr.add(tanishScanner.nextInt());
        }

        int tanishAnswer = tanishUniqueFinder(tanishArr);
        System.out.println(tanishAnswer);
    }
}

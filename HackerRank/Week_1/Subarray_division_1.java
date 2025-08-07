import java.util.*;

public class TanishBirthdayChoco {

    public static int tanishChocolateWays(List<Integer> tanishBar, int tanishDay, int tanishMonth) {
        int tanishWays = 0;
        for (int tanishStart = 0; tanishStart <= tanishBar.size() - tanishMonth; tanishStart++) {
            int tanishSum = 0;
            for (int tanishIdx = 0; tanishIdx < tanishMonth; tanishIdx++) {
                tanishSum += tanishBar.get(tanishStart + tanishIdx);
            }
            if (tanishSum == tanishDay) {
                tanishWays++;
            }
        }
        return tanishWays;
    }

    public static void main(String[] args) {
        Scanner tanishScanner = new Scanner(System.in);

        int tanishN = tanishScanner.nextInt();
        List<Integer> tanishBar = new ArrayList<>();
        for (int i = 0; i < tanishN; i++) {
            tanishBar.add(tanishScanner.nextInt());
        }

        int tanishD = tanishScanner.nextInt();
        int tanishM = tanishScanner.nextInt();

        int tanishResult = tanishChocolateWays(tanishBar, tanishD, tanishM);
        System.out.println(tanishResult);
    }
}

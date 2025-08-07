import java.util.*;

public class PangramChecker_Tanish {
    public static String pangrams(String s) {
        s = s.toLowerCase();
        Set<Character> set = new HashSet<>();

        for (char ch : s.toCharArray()) {
            if (ch >= 'a' && ch <= 'z') {
                set.add(ch);
            }
        }

        return set.size() == 26 ? "pangram" : "not pangram";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        System.out.println(pangrams(input));
    }
}

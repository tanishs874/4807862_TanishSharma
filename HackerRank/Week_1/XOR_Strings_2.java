import java.util.Scanner;

public class XOR_Strings_2 {
    public static String performXOR(String textA, String textB) {
        StringBuilder result = new StringBuilder();
        for (int index = 0; index < textA.length(); index++) {
            if (textA.charAt(index) == textB.charAt(index)) {
                result.append('0');
            } else {
                result.append('1');
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String firstInput = input.nextLine();
        String secondInput = input.nextLine();
        System.out.println(performXOR(firstInput, secondInput));
    }
}

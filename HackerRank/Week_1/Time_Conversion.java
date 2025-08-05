import java.util.Scanner;

public class Solution {

    public static String tanish_timeConversion(String tanish_time) {
        String tanish_meridian = tanish_time.substring(8); 
        int tanish_hour = Integer.parseInt(tanish_time.substring(0, 2));
        String tanish_minutes_seconds = tanish_time.substring(2, 8); 

        if (tanish_meridian.equals("AM")) {
            if (tanish_hour == 12) {
                tanish_hour = 0;
            }
        } else {
            if (tanish_hour != 12) {
                tanish_hour += 12;
            }
        }
        String tanish_result = String.format("%02d%s", tanish_hour, tanish_minutes_seconds);
        return tanish_result;
    }

    public static void main(String[] args) {
        Scanner tanish_scanner = new Scanner(System.in);
        String tanish_input = tanish_scanner.nextLine();
        String tanish_output = tanish_timeConversion(tanish_input);
        System.out.println(tanish_output);
        tanish_scanner.close();
    }
}

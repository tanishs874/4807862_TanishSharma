import java.io.*;
import java.util.*;

class Result {

  
    public static long sumXor(long n) {
        if (n == 0) return 1;  

        long countZeroBitsss = 0;
        long temp = n;

        while (temp > 0) {
            if ((temp & 1) == 0) {
                countZeroBitsss++;
            }
            temp >>= 1;
        }

        return 1L << countZeroBitsss; 
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        long n = Long.parseLong(bufferedReader.readLine().trim());

        long result = Result.sumXor(n);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

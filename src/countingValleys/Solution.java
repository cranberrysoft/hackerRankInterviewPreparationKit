package countingValleys;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the countingValleys function below.
    static int countingValleys(int n, String s) {

        Stack<Integer> moves = new Stack<>();
        int result = 0;

        for(int move: s.toCharArray()){
            if(moves.isEmpty() || moves.peek() == move){
                moves.push(move);
            }else {
                moves.pop();
                if (moves.isEmpty() && move == 'U') {
                    result++;
                }
            }
        }

        return result;
    }

    //private static final Scanner scanner = new Scanner(System.in);\
    private static final Scanner scanner = new Scanner(new ByteArrayInputStream(("12\n" +
            "DDUUDDUDUUUD").getBytes()));

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String s = scanner.nextLine();

        int result = countingValleys(n, s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

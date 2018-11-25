package repeatedString;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the repeatedString function below.
    static long repeatedString(String s, long n) {
        int stringLen = s.length();
        long count = (n/stringLen) * s.chars().filter(c -> c == 'a').count();
        long remainder = s.substring(0,Long.valueOf(n%stringLen).intValue()).chars().filter(c -> c == 'a').count();
        return count + remainder;
    }

    //private static final Scanner scanner = new Scanner(System.in);
    private static final Scanner scanner = new Scanner(new ByteArrayInputStream(("aba\n" +
            "10").getBytes()));
    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = scanner.nextLine();

        long n = scanner.nextLong();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long result = repeatedString(s, n);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
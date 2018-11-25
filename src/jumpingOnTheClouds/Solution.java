package jumpingOnTheClouds;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the jumpingOnClouds function below.
    static int jumpingOnClouds(int[] c) {
        int iterations = 0;
        int currentIndex = 0;
        while(currentIndex !=  c.length -1){
            if(currentIndex + 2 < c.length &&  c[currentIndex + 2] == 0){
                currentIndex+=2;
            }else {
                currentIndex+=1;
            }
            iterations++;
        }
        return iterations;
    }

//    private static final Scanner scanner = new Scanner(System.in);
    private static final Scanner scanner = new Scanner(new ByteArrayInputStream(("7\n" +
        "0 0 1 0 0 1 0").getBytes()));

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] c = new int[n];

        String[] cItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int cItem = Integer.parseInt(cItems[i]);
            c[i] = cItem;
        }

        int result = jumpingOnClouds(c);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

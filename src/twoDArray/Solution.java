package twoDArray;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the hourglassSum function below.
        static int hourglassSum(int[][] arr) {
            int max = Integer.MIN_VALUE;
            for(int row = 0; row + 2 < arr.length; row++){
                for(int column = 0; column + 2 < arr.length; column++){
                    int hourGlass = 0;
                    for(int i =0 ; i < 3; i++){
                        if(i == 1) {
                            hourGlass += arr[row + i][column+1];
                        }else{
                            hourGlass += Arrays.stream(Arrays.copyOfRange(arr[row + i], column, column + 3)).sum();
                        }
                    }
                    if( hourGlass > max) {
                        max = hourGlass;
                    }
                }
            }
            return max;
        }

    //private static final Scanner scanner = new Scanner(System.in);
    private static final Scanner scanner = new Scanner(new ByteArrayInputStream((
            "-1 -1 0 -9 -2 -2\n" +
                    "-2 -1 -6 -8 -2 -5\n" +
                    "-1 -1 -1 -2 -3 -4\n" +
                    "-1 -9 -2 -4 -4 -5\n" +
                    "-7 -3 -3 -2 -9 -9\n" +
                    "-1 -3 -1 -2 -4 -5").getBytes()));
    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int[][] arr = new int[6][6];

        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }

        int result = hourglassSum(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

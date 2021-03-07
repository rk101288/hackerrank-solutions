import scala.Int;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class MissingNumbers {

    // Complete the missingNumbers function below.
    static int[] missingNumbers(int[] arr, int[] brr) {
        Map<Integer, Integer> numOfOccurArr = numberOfOcc(arr);
        Map<Integer, Integer> numOfOccurBrr = numberOfOcc(brr);

        Set<Integer> result = new HashSet<>();
        for (int i=0; i <brr.length; i++) {
            if(!numOfOccurArr.containsKey(brr[i]) || numOfOccurArr.get(brr[i]) != numOfOccurBrr.get(brr[i])) {
                result.add(brr[i]);
            }
        }

        return result.stream().sorted().mapToInt(i -> i).toArray();

    }

    static Map<Integer, Integer> numberOfOcc(int [] arr) {
        Map<Integer, Integer> result = new HashMap<>();
        for (int i=0; i <arr.length; i++) {
            if(!result.containsKey(arr[i])) {
                result.put(arr[i], 1);
            } else {
                int currentCount = result.get(arr[i]);
                result.put(arr[i], currentCount + 1);
            }
        }

        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("test"));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int m = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] brr = new int[m];

        String[] brrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            int brrItem = Integer.parseInt(brrItems[i]);
            brr[i] = brrItem;
        }

        int[] result = missingNumbers(arr, brr);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write(" ");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

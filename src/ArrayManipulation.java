import java.util.Scanner;

/**
 * Created by ricks on 1/28/18.
 */
public class ArrayManipulation {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        long [] list = new long[n];

        for (int i = 0;  i < n; i++ ) {
            list[i] = 0;
        }

        int m = in.nextInt();

        for(int a0 = 0; a0 < m; a0++){
            int a = in.nextInt();
            int b = in.nextInt();
            int k = in.nextInt();
            list = maximumInList(a, b, k, list);
        }

        System.out.println(findMax(list));

        in.close();
    }

    private static long findMax(long[] list) {
        long max = list[0];
        for(int i = 1; i < list.length; i++)  {
            if(max < list[i]) {
                max = list[i];
            }
        }
        return max;
    }

    private static long[] maximumInList(int startIndex, int endIndex, int numberToAdd, long[] list) {
        for(int i = startIndex - 1; i <= endIndex - 1; i++) {
            list[i] = list[i] + numberToAdd;
        }
        return list;
    }
}

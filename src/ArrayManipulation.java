import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * You are given a list(1-indexed) of size , initialized with zeroes. You have to perform  operations on the list and output the maximum of final values of all the  elements in the list. For every operation, you are given three integers ,  and  and you have to add value  to all the elements ranging from index  to (both inclusive).
 * <p>
 * For example, consider a list  of size . The initial list would be  = [, , ] and after performing the update  = , the new list would be  = [, , ]. Here, we've added value 30 to elements between indices 2 and 3. Note the index of the list starts from 1.
 * <p>
 * Input Format
 * <p>
 * The first line will contain two integers  and  separated by a single space.
 * Next  lines will contain three integers ,  and  separated by a single space.
 * Numbers in list are numbered from  to .
 */
public class ArrayManipulation {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        long[] list = new long[n];

        int m = in.nextInt();

        long max = 0;

        for (int a0 = 0; a0 < m; a0++) {
            int a = in.nextInt();
            int b = in.nextInt();
            int k = in.nextInt();

            for (int i = a - 1; i <= b - 1; i++) {
                list[i] = list[i] + k;
                if (max < list[i]) {
                    max = list[i];
                }
            }
        }

        System.out.println(max);

        in.close();
    }
}

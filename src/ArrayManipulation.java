import java.util.Scanner;

/**
 You are given a list(1-indexed) of size , initialized with zeroes. You have to perform  operations on the list and output the maximum of final values of all the  elements in the list. For every operation, you are given three integers ,  and  and you have to add value  to all the elements ranging from index  to (both inclusive).

 For example, consider a list  of size . The initial list would be  = [, , ] and after performing the update  = , the new list would be  = [, , ]. Here, we've added value 30 to elements between indices 2 and 3. Note the index of the list starts from 1.

 Input Format

 The first line will contain two integers  and  separated by a single space.
 Next  lines will contain three integers ,  and  separated by a single space.
 Numbers in list are numbered from  to .
 */
public class ArrayManipulation {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        long [] list = new long[n];

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

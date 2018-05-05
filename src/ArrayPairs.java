import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 You will be given an array of integers and a target value. Determine the number of pairs of array elements that have a difference equal to a target value.

 For example, given an array of [1, 2, 3, 4] and a target value of 1, we have three values meeting the condition: 2-1 = 1, 3-2 = 1 , 4-3 = 1
 */
public class ArrayPairs {
    static int pairs(int k, int[] arr) {
        int result = 0;

        for(int i = 0; i < arr.length; i++) {
            List<Integer> newArr = Arrays.stream(arr).boxed().collect(Collectors.toList()).subList(i + 1, arr.length);
            for(int j = 0; j < newArr.size(); j++) {
                    if(Math.abs(arr[i] - newArr.get(j)) == k) {
                        result ++;
                    }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] arr = new int[n];
        for(int arr_i = 0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
        }
        int result = pairs(k, arr);
        System.out.println(result);
        in.close();
    }
}

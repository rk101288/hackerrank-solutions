import java.util.ArrayList;
import java.util.List;

/**
 * Created by ricks on 9/25/17.
 */
public class TriangleOrNot {

    public static void main(String[] args) {
        int[] a = new int[] {7, 10, 7};
        int[] b = new int[] {2, 3, 4};
        int[] c = new int[] {2, 7, 4};
        triangleOrNot(a, b, c);
    }

    static String[] triangleOrNot(int[] a, int[] b, int[] c) {
        String[] responses = new String[a.length];
        for (int i = 0; i < a.length; i ++) {
            List<Integer> values = new ArrayList<Integer>();
            values.add(a[i]);
            values.add(b[i]);
            values.add(c[i]);

            values.sort(Integer::compareTo);

            if(values.get(0) + values.get(1) > values.get(2)) {
                responses[i] = "Yes";
            } else {
                responses[i] = "No";
            }
        }

        return responses;
    }
}

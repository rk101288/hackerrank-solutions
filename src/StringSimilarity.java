import java.util.ArrayList;
import java.util.List;

/**
 * Created by ricks on 9/25/17.
 */
public class StringSimilarity {
    public static void main(String[] args) {
        String[] inputs = new String[]{"ababaa"};
        stringSimilarity(inputs);

    }

    static int[] stringSimilarity(String[] inputs) {
        int[] results = new int[inputs.length];
        for (int j = 0; j < inputs.length; j++) {
            results[j] = stringSimilarity(inputs[j]);
        }
        return results;
    }

    static int stringSimilarity(String s) {
        int total = 0;
        for (int i = 0; i < s.length(); i++) { // suffix pointer
            for (int j = 0; j + i < s.length(); j++) { // original string pointer
                if (s.charAt(j) == s.charAt(j + i)) {
                    total++;
                } else {
                    break;
                }
            }
        }
        return total;
    }



}

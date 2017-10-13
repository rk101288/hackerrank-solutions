import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.*;

/**
 * Created by ricks on 10/12/17.
 */
public class Pagination1 {

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        final String fileName = System.getenv("OUTPUT_PATH");
        BufferedWriter bw = null;
        if (fileName != null) {
            bw = new BufferedWriter(new FileWriter(fileName));
        }
        else {
            bw = new BufferedWriter(new OutputStreamWriter(System.out));
        }

        String[] res;
        int num;
        num = Integer.parseInt(in.nextLine().trim());

        int results_size = 0;
        results_size = Integer.parseInt(in.nextLine().trim());

        String[] results = new String[results_size];
        for(int i = 0; i < results_size; i++) {
            String results_item;
            try {
                results_item = in.nextLine();
            } catch (Exception e) {
                results_item = null;
            }
            results[i] = results_item;
        }

        res = paginate(num, results);
        for(int res_i = 0; res_i < res.length; res_i++) {
            bw.write(String.valueOf(res[res_i]));
            bw.newLine();
        }

        bw.close();
    }

    static String[] paginate(int num, String[] results) {
        List<String> resulting = new ArrayList<>();

        HashMap<String, String> unique = new HashMap<>();
        List<String> dups = new ArrayList<>();

        int currentNumber = 1;
        for(int index = 0; index < results.length;  index++) {
            String[] csv = results[index].split(",");
            if(unique.get(csv[0]) == null) {
                unique.put(csv[0], results[index]);
            } else {
                dups.add(results[index]);
            }
        }

        for(Map.Entry<String, String> u : unique.entrySet()) {
            resulting.add(u.getValue());
            if(currentNumber != num) {
                currentNumber = currentNumber + 1;
            } else {
                resulting.add("");
                currentNumber = 1;
            }
        }

        for(String dup : dups) {
            resulting.add(dup);
            if(currentNumber != num) {
                currentNumber = currentNumber + 1;
            } else {
                resulting.add("");
                currentNumber = 1;
            }
        }

        if(resulting.get(resulting.size() - 1).equals("")) {
            resulting.remove(resulting.size() - 1);
        }

        return resulting.toArray(new String[0]);
    }
}

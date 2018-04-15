import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by ricks on 2/1/18.
 */
public class SparseArray {
    public static void main (String [] args) {
        Scanner in = new Scanner(System.in);

        List<String> strings = IntStream.range(0, in.nextInt()).mapToObj(i -> in.next()).collect(Collectors.toList());
        List<String> queries = IntStream.range(0, in.nextInt()).mapToObj(i -> in.next()).collect(Collectors.toList());

        System.out.println(strings);
        System.out.println(queries);


        queries.forEach( query -> {
            long numberOfTimes = 0;
            for(String s : strings) {
                if(s.equals(query)) {
                    numberOfTimes = numberOfTimes + 1;
                }
            }
            System.out.println(numberOfTimes);
        });
    }
}

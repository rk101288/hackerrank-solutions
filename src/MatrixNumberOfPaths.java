/**
 * Created by ricks on 9/25/17.
 */
public class MatrixNumberOfPaths {


    static int numberOfPaths(int[][] a) {
        return count(a, 0, 0);
    }

    static int count(int [][] a, int row, int col){
        if(a[row][col] != 1) {
            return 0;
        }

        if(row == a.length - 1 && col == a[0].length - 1){
            return 1;
        }

        int total = 0;
        if(row < a.length - 1) {
            total += count(a, row + 1, col);
        }
        if(col < a[0].length-1) {
            total += count(a, row, col + 1);
        }
        return total;
    }

}

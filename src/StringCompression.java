/**
 Given an array of characters, compress it in-place.

 The length after compression must always be smaller than or equal to the original array.

 Every element of the array should be a character (not int) of length 1.

 After you are done modifying the input array in-place, return the new length of the array.


 Follow up:
 Could you solve it using only O(1) extra space?
 */
public class StringCompression {

    public int compress(char[] chars) {
        int point = 0;
        int i = 0;
        int j = 0;
        while (i < chars.length) {
            if (j == chars.length || chars[i] != chars[j]){   // if we reach the end of the string or we found a position we need to do compression
                chars[point++] = chars[i];
                if (j - i <= 1) {
                    i = j;
                } else {
                    String num = Integer.toString(j - i);
                    for (int m = 0; m < num.length(); m++) {
                        chars[point++] = num.charAt(m);
                    }
                    i = j;
                }
            } else {
                j++;
            }
        }
        return point;
    }

}

/**

A left rotation operation on an array of size  shifts each of the array's elements  unit to the left. For example, if left rotations are performed on array , then the array would become .

Given an array of  integers and a number, , perform  left rotations on the array. Then print the updated array as a single line of space-separated integers.

Input Format

The first line contains two space-separated integers denoting the respective values of  (the number of integers) and  (the number of left rotations you must perform).
The second line contains  space-separated integers describing the respective elements of the array's initial state.

Constraints

Output Format

Print a single line of  space-separated integers denoting the final state of the array after performing  left rotations.

Sample Input

5 4
1 2 3 4 5
Sample Output

5 1 2 3 4
  */
object LeftRotation {
  def main(args: Array[String]) {
    val sc = new java.util.Scanner(System.in)
    var n = sc.nextInt()
    var k = sc.nextInt()
    var a = new Array[Int](n)
    for (a_i <- 0 until n) {
      a(a_i) = sc.nextInt()
    }

    val rotated = rotateLeft(a, k, n)
    for (a_i <- rotated) {
      print(a_i + " ")
    }
  }
  def rotateLeft(array: Array[Int], rotateLeft: Int, arraySize: Int): Array[Int] = {
    val sliced: Array[Int] = array.slice(0, rotateLeft)
    val remaining = array.slice(rotateLeft, arraySize)

    val result: Array[Int] = remaining ++ sliced
    result
  }
}

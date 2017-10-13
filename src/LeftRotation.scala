/**
  * Created by ricks on 9/17/17.
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

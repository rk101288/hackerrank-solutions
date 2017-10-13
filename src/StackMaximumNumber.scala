import scala.collection.mutable
import scala.collection.mutable.ListBuffer

/**
  * Created by ricks on 7/7/17.
  */
object StackMaximumNumber {
  def main(args: Array[String]) {
    val sc = new java.util.Scanner(System.in)
    var numberOfInputs = sc.nextLine().toInt

    var queries = new ListBuffer[String]
    while (numberOfInputs > 0) {
      val nextLine = sc.nextLine()
      queries += nextLine
      numberOfInputs = numberOfInputs - 1
    }

    sc.close()

    executeQueries(queries)
  }

  def executeQueries(queries: ListBuffer[String]): Unit = {
    val stack = new mutable.Stack[(Int, Int)]
    queries.foreach { query =>
      val queryWithInput: Array[String] = query.split(" ")
      if (queryWithInput.nonEmpty) {
        val queryType = queryWithInput.head.toInt
        if (queryType == 1) {
          if(stack.isEmpty) {
            stack.push((queryWithInput(1).toInt, queryWithInput(1).toInt))
          } else {
            val topElement = stack.top
            if(topElement._2 < queryWithInput(1).toInt) {
              stack.push((queryWithInput(1).toInt, queryWithInput(1).toInt))
            } else {
              stack.push((queryWithInput(1).toInt, topElement._2))
            }
          }
        } else if (queryType == 2) {
          stack.pop()
        } else if (queryType == 3) {
          println(stack.top._2)
        }
      }
    }
  }
}

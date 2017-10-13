import scala.collection.mutable.ListBuffer

/**
  * Created by ricks on 6/26/17.
  */


object BalancedBrackets extends App {
  override def main(args: Array[String]) {
    val sc = new java.util.Scanner(System.in)
    var numberOfInputs = sc.nextLine().toInt

    var values = new ListBuffer[String]
    while (numberOfInputs > 0) {
      val nextLine = sc.nextLine()
      values += nextLine
      numberOfInputs = numberOfInputs - 1
    }

    sc.close()

    values.foreach { value =>
      if(isBalanced(value)) {
        println("YES")
      } else {
        println("NO")
      }
    }
  }

  def isMatching(c1: Char, c2: Char): Boolean = (c1, c2) match {
    case ('(',')') => true
    case ('{','}') => true
    case ('[',']') => true
    case _ => false
  }

  def isBalanced(value : String) : Boolean = {
    val stack = new scala.collection.mutable.Stack[Char]
    value.foreach { v =>
      if(stack.isEmpty) {
        stack.push(v)
      }
      else{
        if(!isMatching(stack.top, v)) {
          stack.push(v)
        } else {
          stack.pop
        }
      }
    }

    stack.isEmpty
  }

}

import scala.collection.mutable.ListBuffer

/**
A bracket is considered to be any one of the following characters: (, ), {, }, [, or ].

Two brackets are considered to be a matched pair if the an opening bracket (i.e., (, [, or {) occurs to the left of a closing bracket (i.e., ), ], or }) of the exact same type. There are three types of matched pairs of brackets: [], {}, and ().

A matching pair of brackets is not balanced if the set of brackets it encloses are not matched. For example, {[(])} is not balanced because the contents in between { and } are not balanced. The pair of square brackets encloses a single, unbalanced opening bracket, (, and the pair of parentheses encloses a single, unbalanced closing square bracket, ].

By this logic, we say a sequence of brackets is considered to be balanced if the following conditions are met:

It contains no unmatched brackets.
The subset of brackets enclosed within the confines of a matched pair of brackets is also a matched pair of brackets.
Given  strings of brackets, determine whether each sequence of brackets is balanced. If a string is balanced, print YES on a new line; otherwise, print NO on a new line.

Input Format

The first line contains a single integer, , denoting the number of strings.
Each line  of the  subsequent lines consists of a single string, , denoting a sequence of brackets.

Constraints

, where  is the length of the sequence.
Each character in the sequence will be a bracket (i.e., {, }, (, ), [, and ]).
Output Format

For each string, print whether or not the string of brackets is balanced on a new line. If the brackets are balanced, print YES; otherwise, print NO.
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

import java.util.Scanner

/**
  * Created by ricks on 9/17/17.
  */
object MistVideoGame extends App {
    val sc = new Scanner(System.in)
    val p = sc.nextInt
    val d = sc.nextInt
    val m = sc.nextInt
    val s = sc.nextInt
    val answer = howManyGames(p, d, m, s)
    println("Answer " +answer)
    answer

  def howManyGames(firstGame: Int, lessThan: Int, maximumSale: Int, dollarAvailable: Int): Int =  {
    var numberOfGames = 0
    var remaining = dollarAvailable
    var currentCost = firstGame

    if(dollarAvailable < firstGame) {
      return numberOfGames
    }

    while(remaining >= currentCost) {
      numberOfGames = numberOfGames + 1
      remaining = remaining - currentCost
      currentCost = currentCost - lessThan
      if(currentCost < maximumSale) {
        currentCost = maximumSale
      }
    }

    numberOfGames
  }
}

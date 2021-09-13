package recfun
import common._

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int = {
    if (c == r || c == 0) {
      1
    } else {
      pascal(c, r - 1) + pascal(c - 1, r - 1)
    }
  }

  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = {
    def balanceAux(balanceNumber: Int, charList: List[Char]): Boolean = {
      if (balanceNumber < 0) {
        false
      } else if (charList.isEmpty && balanceNumber == 0) {
        true
      } else {
        if (charList.head == '(') {
          balanceAux(balanceNumber + 1, charList.tail)
        } else if (charList.head == ')') {
          balanceAux(balanceNumber - 1, charList.tail)
        } else {
          balanceAux(balanceNumber, charList.tail)
        }
      }
    }
    balanceAux(0, chars)
  }

  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = ???
}

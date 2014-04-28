package Hangman

import scala.io.Source
import scala.util.Random

class Dictionary {

  val fname = ".\\src\\main\\resources\\NSF-ordlisten.txt"
  val words = Source.fromFile(fname).getLines.toList

  def getWord() = {
    words(new Random().nextInt(words.size)).toLowerCase()
  }
}

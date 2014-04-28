package Hangman

import scala.collection.immutable.TreeSet

class Game(word: String, guesses: Set[Char]) {

  def this(word: String) = this(word, new TreeSet[Char])

  def guess(guess: Char) = new Game(word, guesses + guess)

  def maskedWord = word.map((char: Char) => if (guesses.contains(char)) char else '_')

  def addSpaces(str: String) = str.foldLeft("")((acc, c) => acc + ' ' + c)

  def wrongGuesses = guesses.diff(word.toSet).size

  def isLoss = wrongGuesses >= gallows.size

  def isWon = !maskedWord.contains('_')

  def isFinished = isLoss || isWon

  override def toString = gallows(wrongGuesses) + addSpaces(maskedWord) + "\n" + guesses.mkString

  def gallows = List(
    " ____ \n" +
      "/    \n" +
      "|     \n" +
      "|     \n" +
      "|     \n" +
      "|___    ",
    " ____ \n" +
      "/   | \n" +
      "|     \n" +
      "|     \n" +
      "|     \n" +
      "|___    ",
    " ____ \n" +
      "/   | \n" +
      "|   0  \n" +
      "|     \n" +
      "|     \n" +
      "|___    ",
    " ____ \n" +
      "/   | \n" +
      "|   0  \n" +
      "|   |  \n" +
      "|     \n" +
      "|___    ",
    " ____ \n" +
      "/   | \n" +
      "|   0  \n" +
      "|  -|  \n" +
      "|     \n" +
      "|___    ",
    " ____ \n" +
      "/   | \n" +
      "|   0  \n" +
      "|  -|-  \n" +
      "|     \n" +
      "|___    ",
    " ____ \n" +
      "/   | \n" +
      "|   0  \n" +
      "|  -|-  \n" +
      "|  |    \n" +
      "|___    ",
    " ____ \n" +
      "/   | \n" +
      "|   0  \n" +
      "|  -|-  \n" +
      "|  | | \n" +
      "|___    ")
}
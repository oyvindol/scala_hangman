package Hangman

object Hangman extends App {
  val word = new Dictionary().getWord
  var game = new Game(word)
  var finished = false

  while (!finished) {
    println(game)
    println("Gjett bokstav: ")
    val guess = Console.in.read.toChar
    game = game.guess(guess.toLower)
    Console.in.read.toChar //hvorfor er '/n' med her???
    finished = game.isFinished
  }

  println("Løsning: " + word)
  if (game.isLoss) println("Tsk...for dårlig!")
  else println("Velkommen til den intellektuelle eliten!")
}

# Hangman Terminal Game

Hangman-terminal-game is a Java program that implements the classic Hangman game to play on the terminal. It provides an interactive experience where one player thinks of a word, and another player attempts to guess the word letter by letter. Was developed as a practice project to enhance programming skills and prepare for an exam. It was specifically designed to utilize arrays of reference types as part of the learning process.

## How to Play

To play the game, simply compile and run the `HangMan.java` file. The program will prompt the first player to input a word, which will be hidden from the second player. The second player will then begin guessing letters of the word. The program will display a certain number of dashes representing each letter of the word, and as the second player makes correct guesses, the corresponding dashes will be replaced with the guessed letters.

## Features

- **Classic Hangman Gameplay:** Enjoy the traditional Hangman gameplay where one player guesses a word based on letters provided by another player.
- **Limited Attempts:** The guessing player has a limited number of attempts (lives) to guess the word correctly. Each incorrect guess decrements the number of lives by 1.
- **Word Encryption:** The word to be guessed is encrypted as an array of strings, each initially set to "-", allowing the guessing player to uncover the word gradually.

## Author

This Hangman Terminal Game was developed by Andrea Visani.


## License

See the [LICENSE](LICENSE) file for more details.

Enjoy playing Hangman in the terminal and have fun deciphering the hidden word!

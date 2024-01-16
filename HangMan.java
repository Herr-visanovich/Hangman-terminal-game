/**
 * Represents a simple Hangman game where one player enters a secret word,
 * and the other player tries to guess it by suggesting letters. 
 * 
 * @author Andrea Visani
 * @version 1.0
 */
public class HangMan{

	/**
	 * Main method of the program
	 * @param args Not needed command line arguments
	 */
	public static void main(String[] args) {
		/**
		 * Keeps track of the current round number, starts at 1
		 */
		int round =1;
		/**
		 * Initially set to false, becomes true when winning conditions are met
		 */
		boolean youWon = false;
		/**
		 * Initial number of lives
		 */
		int numberOfLives = 4; 
		
		/**
		 * At the beginning of the game, ask player 1 to enter the secret word
		 */
		SecretWord.setSecretWord();
		/**
		 * Print lines to hide the word
		 */
		GameMechanics.avoidCheating(100);
		
		/** Since i wanted to practice with array of reference type, this converts the secret word to 
		 * the encrypted word as a String array set to be all "-"
		 */
		String[] encryptedWord = SecretWord.convertWord();
		
	
		/**
		 * Game loop, that repeats one round until the guessing player wins,
		 * if <code>numberOfLives</code> is less than 1, a message and the hang man will be displayed, and the game ends 
		 * otherwise the program continues. 
		 * A check is performed and if winning conditions are met the loop ends, otherwise it continues.
		 */
		while(youWon == false) {
			GameMechanics.printRoundInfo(round, numberOfLives, encryptedWord);
			
			numberOfLives = GameMechanics.playRound(SecretWord.getSecretWord(), encryptedWord, numberOfLives);
			if (numberOfLives < 1)
			{
				GameMechanics.printLose();
				return;
			}
			
			youWon = GameMechanics.checkWinningCondition(SecretWord.getSecretWord(), encryptedWord);
			round++;
		} //end while 
		
		
		/**
		 * Once winning conditions are met, the encrypted word and a message are displayed and the program ends.
		 */
		if (youWon == true) {
			SecretWord.printEncrypted(encryptedWord);
			System.out.println("You won!!!!!");
		}
		
	}// end main
}

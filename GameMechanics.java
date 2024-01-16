/**
 * Represent the game mechanics of Hangman game.
 * Allows printing basic info for each round, an "anti cheat" method, playing one round, checking winning conditions.
 * Also implements method that prints a message if the player2 loses and can't guess the word with the number of attempts given.
 * 
 * @author Andrea Visani
 */
public class GameMechanics {

	/**
	 * Default constructor
	 */
	public GameMechanics() {
		
	}
	
	/**
	 * For each round prints basic information regarding the round, the lives, the round number and the word to guess.
	 * @param round The round number.
	 * @param lives The number of lives left.
	 * @param enctypted The encrypted word for each round, with the guessed characters and the one still to guess.
	 */
	public static void printRoundInfo(int round, int lives, String[] enctypted)
	{
		System.out.println("ROUND: " + round);
		System.out.println("Number of lives left: " + lives);
		System.out.println("");
		SecretWord.printEncrypted(enctypted);
	}
	
	/**
	  * Prints lines to avoid showing the phrase entered in the terminal by player 1
	  * @param numberOfLines The number of lines to be printed, can be changed base on the screen used
	  */
	public static void avoidCheating(int numberOfLines) {
		for(int i = 0 ; i < numberOfLines; i++) {
			System.out.println("DON'T SCROLL UP! DON'T CHEAT!!");
		}
		System.out.println();
	}
	
	/**
	 * The core of the program, performs a round of the game and gives feedback if a match is found or not
	 * @param real The real word that needs to be guessed
	 * @param encrypted The String array that forms the encrypted word, made of "-" 
	 * @param lives Number of lives
	 * @return The number of lives
	 */
	public static int playRound(String real, String[] encrypted, int lives) {

		/**
		 *<code>String</code> variable that will contain the Player 2 guessed character
		 */
		String letter = "";

		/**
		 * Variable used to determine if the chosen letter is part of the <code>secretWord</code>
		 */
		boolean match = false;

		/**Make sure that there is no crash if the user presses enter without providing letters,
		 * and assigns the Player 2 input to the <code>letter</code> variable
		 */
		while(letter.length() < 1) {
			System.out.println("Select one letter: ");
			letter = User.inputString();
		}

		//Make sure that only the first character is considered
		letter = letter.substring(0, 1);		

		/**
		 * Loops through the characters of the real word and, for each character, 
		 * verifies if it matches the letter stored in the <code>letter</code> variable. 
		 * If a match is identified, the corresponding position in the <code>encrypted</code> word is assigned the letter, 
		 * and the <code>match</code> variable is set to <code>true</code>.
		 */
		for(int j = 0; j < real.length(); j++) { 
			if(letter.equalsIgnoreCase(real.substring(j, j+1))) {
				encrypted[j] = letter;
				match = true;
			}
		}	
		if(match == true) {
			System.out.println("Found a match");
			System.out.println("---------------------");
		}else {
			System.out.println("match not found");
			System.out.println("---------------------");
			lives--;
		}
		return lives;
	}// end guessLetter

	/**
	 * Checks the real word and the encrypted word element by element, if they're equal returns true, otherwise false.
	 * @param real The real word
	 * @param encrypted The encrypted word
	 * @return a true <code>boolean</code> if the 2 words match, otherwise false
	 */
	public static boolean checkWinningCondition(String real, String[] encrypted) {
		boolean win = true;
		for (int i = 0; i < encrypted.length; i++) {
			if (!real.substring(i, i + 1).equalsIgnoreCase(encrypted[i])) { //if they're not equal return false.
				return !win;
			}
		}
		return win;
	}

	/**
	 * Prints the message associated with the defeat and the <code>secretWord</code>
	 */
	public static void printLose() {
		System.out.println("You LOST :(");
		System.out.println("           _______");
		System.out.println("           |     |");
		System.out.println("           O     |");
		System.out.println("         /|-|\\   |");
		System.out.println("        / |_| \\  |");
		System.out.println("          | |    |");
		System.out.println("         .| |.   |");
		System.out.println("                 |");
		System.out.println("                 |");
		System.out.println("           -----------");
		System.out.println("The word was: " + SecretWord.getSecretWord());
	}

}

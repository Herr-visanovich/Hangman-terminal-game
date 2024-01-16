/**
 * Represents a secret word used in a HangMan game.
 * This class allows setting and retrieving the secret word,
 * as well as converting it into an encrypted format for gameplay.
 * 
 * The secret word must be at least 3 characters long.
 * 
 * @author Andrea Visani
 */
public class SecretWord {

	/**
	 * Stores the secret word entered by player1
	 */
	private static String secretWord;

	/**
	 * default constructor
	 */
	public SecretWord() {

	}

	/**
	 * Prompts the user for a string at least 3 characters long and sets the secretWord variable
	 */
	public static void setSecretWord() {
		secretWord = User.inputString("Enter the secret word");
		while(secretWord.length() < 3) {
			secretWord = User.inputString("At least 3 character. Enter the secret word");
		}
	}

	/**
	 * Gets the secret word
	 * @return the word entered by the user
	 */
	public static String getSecretWord() {
		return secretWord;
	}

	/**
	 * Creates a new <code>String</code> array of the same length of the secretWord
	 * @return an arrays of "-" String, of the same length as the the secretWord
	 */
	public static String[] convertWord() {
		String[] encrypted = new String[secretWord.length()];

		for(int i = 0; i < encrypted.length ; i++) {
			encrypted[i] = "-";
		}
		return encrypted;
	}

	/**
	 * Prints an <code>String</code> array, element by element, without spaces and new lines between elements
	 * @param array A String array (made of single characters)
	 */
	public static void printEncrypted(String[] array) {
		System.out.print("Encrypted word: ");
		for(String element : array) {
			System.out.print(element);
		}
		System.out.println();
	}
}

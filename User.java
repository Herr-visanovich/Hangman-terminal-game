
import java.util.Scanner;

/**
 * This class provides utility for getting user input from the console using
 * an instance of Scanner set to new Scanner(System.in) and has methods that 
 * prevent program crashes from text inputs when numbers are expected.
 */
public class User {
	
	/**
	 * Manages the Input
	 */
	private static Scanner keyboard = new Scanner(System.in);
	
	/**
	 * This is a utility class with only static members, prevents
	 * instantiation.
	 */
	private User() { }
	
	/**
	 * Does not prompt the user, reads in an int value when there is one.  If
	 * the user does not provide input that can be converted into an int an
	 * error message is printed requesting a correct input and a loop is used
	 * to trap the user until they get this right.  A future version of 
	 * the program might have a sanity check to break the loop after several 
	 * failed attempts and then shut down the program, rather than looping
	 * (in theory) forever.
	 * @return An integer
	 */
	public static int inputInteger() {
		boolean isInputBad = true;
		boolean hasNextInt;
		int value = 0;
		while (isInputBad) {
			hasNextInt = keyboard.hasNextInt();
			if (hasNextInt) {
				value = keyboard.nextInt();
				isInputBad = false; // break out of loop
			}
			else {
				System.out.print("Invalid input.  Enter an integer number: ");
			}
			keyboard.nextLine(); // clean up input stream
		}
		return value;
	}
	
	/**
	 * This method prompts the user using the argument sent to message
	 *  and then calls to method inputInteger() to get the actual input value.
	 *  @param message A prompt provided to the user
	 *  @return An integer
	 */
	public static int inputInteger(String message) {
		// This method calls inputInteger(), so no changes are needed here.
		System.out.printf("%s", message);
		int value = inputInteger(); 
		return value;
	}
	
	/**
	 * Does not prompt the user, reads in a double value when there is one.  If
	 * the user does not provide input that can be converted into a double an
	 * error message is printed requesting a correct input and a loop is used
	 * to trap the user until they get this right.  A future version of 
	 * the program might have a sanity check to break the loop after several 
	 * failed attempts and then shut down the program, rather than looping
	 * (in theory) forever.
	 * @return A double.
	 */
	public static double inputDouble() {
		boolean isInputBad = true;
		boolean hasNextDouble;
		double value = 0.0;
		while (isInputBad) {
			hasNextDouble = keyboard.hasNextDouble();
			if (hasNextDouble) {
				value = keyboard.nextDouble();
				isInputBad = false; // break out of loop
			}
			else {
				System.out.print("Invalid input. Enter a number: ");
			}
			keyboard.nextLine(); // clean up input stream
		}
		return value;	
	}
	
	/**
	 * Accepts only the first character given by the user
	 * @return A character
	 */
	public static char inputChar() {
		String something;
		char theChar;
		something = keyboard.next();
		theChar = something.charAt(0);
		return theChar;
	}
	
	/**
	 * This method prompts the user using the argument sent to message
	 *  and then calls to method inputDouble() to get the actual input value.
	 *  @param message A prompt
	 *  @return A double
	 */
	public static double inputDouble(Object[] message) {
		// This method calls inputDouble(), so no changes are needed here.
		System.out.printf("%s", message);
		double value = inputDouble();
		return value;
	}
	
	/**
	 * This method is used to get a line of text from the console, it reads
	 * until it encounters a line terminator character.
	 * @return A string
	 */
	public static String inputString() {
		String value = keyboard.nextLine();
		return value;
	}
	
	/**
	 * This method prompts the user using the argument sent to message, 
	 * then calls to method inputString() which reads in the actual text.
	 * @param message A prompt
	 * @return A String
	 */
	public static String inputString(String message) {
		System.out.printf("%s: ", message);
		String value = inputString();
		return value;
	}
	
	  
	 /**
	  * This method prompts the user using the argument sent to prompt, then calls to method inputDouble() which makes sure that input is a number,then this methods checks if the number is positive. If not, prompts user for a positive number.
	  * @param prompt The prompt provided to the user
	  * @return A double
	  */
	public static double inputPositiveDouble(String prompt) {
		
		boolean isInputBad = true;
		double value = 0.0;
		
		while (isInputBad)
		{
			System.out.printf("%s", prompt);
			
			value = User.inputDouble();
			
			if (value > 0)
			{
				isInputBad = false;
			}
			else {
				System.out.println("Invalid input. Enter positive a number: ");
			}
		}
		return value;	
	}
}
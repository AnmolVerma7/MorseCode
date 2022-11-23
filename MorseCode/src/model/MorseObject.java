package model;

/**
 * Morse object that contains english letter and corresponding code
 * @author Anmol Verma
 * Last Modified: <November 22nd 2022>
 */
public class MorseObject {
	
	// Letter of code
	private char letter;
	
	// Morse Code of letter
	private String code;
	
	/**
	 * Constructor for morse object 
	 * @param Letter to be passed to constructor 
	 * @param Code to be passed to constructor
	 */
	public MorseObject(char letter, String code) {
		this.letter = letter;
		this.code = code;
	}
	
	/**
	 * Gets letter of Morse Object
	 * @return Letter of object
	 */
	public char getLetter() {
		return letter;
	}

	/**
	 * Sets letter of object
	 * @param Letter to be set
	 */
	public void setLetter(char letter) {
		this.letter = letter;
	}

	/**
	 * Gets code of object
	 * @return Code of object
	 */
	public String getCode() {
		return code;
	}

	/**
	 * Sets code of object
	 * @param Code to be set
	 */
	public void setCode(String code) {
		this.code = code;
	}
	
	/**
	 * Overrides toString method to return a formatted string
	 */
	public String toString() {
		return letter + " " + code;
	
	}
}

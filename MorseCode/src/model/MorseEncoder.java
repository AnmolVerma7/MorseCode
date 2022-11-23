package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * This class encodes a string into morse code
 * @author Anmol Verma
 * Last Modified: <November 22nd 2022>
 */
public class MorseEncoder {
	
	// File path to Morse Codes 
    private final String FILE_PATH = "res/codes.txt";
    
    // String array that stores a total of 26 letters
    private String[] codeArray;
    
    /**
     * Constructor for Encoder that loads data into the array
     * @throws FileNotFoundException
     */
    public MorseEncoder() throws FileNotFoundException {
    	codeArray = new String[26];
    	loadData();
    }
    
    /**
     * Reads from file, adds to array, and sorts alphabetically
     * @throws FileNotFoundException
     */
    private void loadData() throws FileNotFoundException {
    	File file = new File(FILE_PATH);
    	String letter;
		String code;
		MorseObject mo;
		
		Scanner fileReader = new Scanner(file);
		while (fileReader.hasNextLine()) {
			for (int i = 0; i < codeArray.length; i++) {
				letter = fileReader.next();
				code = fileReader.next();
				mo = new MorseObject(letter.charAt(0), code);
				codeArray[i] = mo.toString();
			}
		}
		fileReader.close();
		Arrays.sort(codeArray);
	}
    
    /**
     * Takes in message input by user, breaks into array and encodes each letter of array
     * @param Message to be made into array and has each letter encoded 
     */
	public void encodeMessage(String message) {
		String[] messageArray = message.trim().split("\\s+");
		String encodedLetter = null;
		
		for (int i = 0; i <  messageArray.length; i++ ) {
			String word = messageArray[i];
			for (int j = 0; j < word.length(); j++) {
				encodedLetter = encode(word.charAt(j));
				 System.out.print(encodedLetter + "  ");
			}
			System.out.print("    ");
		}
		System.out.print("\n");
	}
	
	/**
	 * Encodes each letter of message into morse code
	 * @param Letter to be encoded 
	 * @return String containing morse code for given letter
	 */
	private String encode(char letter) {
		String encodedLetter = null;
		for (int i = 0; i < codeArray.length; i++) {
			if (codeArray[i].charAt(0) == Character.toUpperCase(letter)) {
				encodedLetter = codeArray[i].substring(1);
			}
		}
		return encodedLetter;
	}
}

package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Decodes a message from Morse Code to English
 * AddToTree and Decode method modified from Tutorial Code
 * @author Anmol Verma
 * Last Modified: <November 22nd 2022>
 */
public class MorseDecoder {

	// File path to Morse Codes 
    private String FILE_PATH = "res/codes.txt";
    
    // Binary Tree that has a root element of something random
    BinaryTree<Character> mainTree;
    
    /**
     * Constructor for decoder that initializes a new tree with a null root element
     * and loads in data from text file
     * @throws FileNotFoundException
     */
    public MorseDecoder() throws FileNotFoundException {
    	mainTree = new BinaryTree<Character>(null);
    	loadData();
    }
    
    /**
     * Loads data from file and adds to tree
     * @throws FileNotFoundException
     */
    private void loadData() throws FileNotFoundException {
    	File file = new File(FILE_PATH);
    	String letter;
		String code;

		Scanner fileReader = new Scanner(file);
		
		while (fileReader.hasNextLine()) {
			letter = fileReader.next();
			code = fileReader.next();
			addToTree(mainTree , letter.charAt(0), code);
		}
		fileReader.close();
    }

    /**
     * Adds English letter to tree of type Character by using code read from text file
     * @param Tree where data needs to be added
     * @param Letter to placed in the node of selected tree
     * @param Code read from text file to be compared and added to tree depending on dot or dash
     */
	private void addToTree(BinaryTree<Character> tree, char letter, String code) {
		char firstCharOfCode;

        if (code.equals(".")) {
            BinaryTree<Character> newTree = new BinaryTree<Character>(letter);
            tree.setLeft(newTree);
        }
        else if (code.equals("-")) {
            BinaryTree<Character> newTree = new BinaryTree<Character>(letter);
            tree.setRight(newTree);            
        }
        else {
        	firstCharOfCode = code.charAt(0);
            code = code.substring(1);
            
            if (firstCharOfCode == '.') { 
            	addToTree (tree.getLeft(), letter, code);
            }
            else { 
            	addToTree (tree.getRight(), letter, code);
            }                
        }
	}
	
	/**
	 * Decodes message using decode method 
	 * @param Message in Morse Code to be decoded into English
	 */
	public void decodeMessage(String message) {
		// Make message into array of words and remove whitespace
		String[] messageArray = message.trim().split("       ");
		
		// Loop through array and make new word
		for (int i = 0; i < messageArray.length; i++) {
			String word = messageArray[i];
			
			// Turn word into an array of letters and remove whitespace
			String[] letter = word.split("   ");
			
			// Loop through letters, decode, and print each letter
			for (int j = 0; j < letter.length; j++) {
				System.out.print(decode(mainTree, letter[j]));
			}
			System.out.print(" ");
		}
		System.out.print("\n");
	}
	
	/**
	 * Decodes Code string into letter recursively until a decoded character is returned
	 * @param Tree to be navigated
	 * @param Code to be decoded into English
	 * @return DecodedCharacter to be returned 
	 */
	private char decode(BinaryTree<Character> tree, String code) {   
        char firstCharOfCode;
        char decodedChar;

        if (code.equals("")) {
            decodedChar = tree.getRootElement();
        }
        else {
        	firstCharOfCode = code.charAt(0);
            code = code.substring(1);
            
            // If first character of code is a dot go left
            if (firstCharOfCode == '.') { 
                decodedChar = decode(tree.getLeft(), code);
            }
            // Else go right 
            else {
                decodedChar = decode(tree.getRight(), code);
            }
        }
        return decodedChar;
    }
	
	/**
	 * Using Iterator of type Character, this method prints every element
	 * in the tree using in order traversal
	 */
	public void print() {   
        Iterator<Character> iterator = mainTree.iterator();
 
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
    } 
}

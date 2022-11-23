package application;

import java.io.FileNotFoundException;
import java.util.Scanner;

import model.MorseDecoder;
import model.MorseEncoder;

/**
 * Encodes sentence into Morse Code 
 * Decodes Morse Code into English (3 spaces between letters, 7 spaces between words)
 * @author Anmol Verma
 * @version 1.0
 * Last Modified: <November 22nd 2022> - <Generated JavaDocs> <Anmol Verma>
 */
public class MorseCodeApp {
	/**
     * This main method runs the entire program using the encoder and decoder objects
     * @throws FileNotFoundException 
     */
    public static void main(String args[]) throws FileNotFoundException {
        Scanner in = new Scanner(System.in);
        MorseEncoder encoder = new MorseEncoder();
        MorseDecoder decoder = new  MorseDecoder();
        String message;
        char choice = ' ';
        do
        {
            System.out.print ("Enter E (encode), D (decode) or Q(quit): ");
            try { 
                choice = in.nextLine().toUpperCase().charAt(0);
                switch (choice)
                {
                    case 'D':
                            System.out.println("Enter the message you'd like to decode from Morse Code: ");
                            message = in.nextLine();
                            decoder.decodeMessage(message);
                            break;
                    case 'E':
                            System.out.println("Enter the message you'd like to encode into Morse Code: ");
                            message = in.nextLine();
                            encoder.encodeMessage(message);
                            break;
                    default:   
                }
            }
            catch (StringIndexOutOfBoundsException e ) {   
            	System.out.println ("Invalid entry - try again");
            }
        } while (choice != 'Q');
    }
}

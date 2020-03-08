package DataManager;

/**
 * Class: CMSC 203
 * Instructor: Dr. Grinberg
 * Description:
 * This program encrypts and decrypts a code based on a cipher and a key depeding on what the user determines
 * Due: 03/08/2020
 * I pledge that I have completed the programming assignment independently. I have not copied the code from a student or any source. 
 * I have not given my code to any student. Print your Name here: Kobie Marsh
 * @author Kobie Marsh
 * 
 */

import java.util.ArrayList;
import java.util.List;


public class CryptoManager {
	
	private static final char LOWER_BOUND = ' ';
	private static final char UPPER_BOUND = '_';
	private static final int RANGE = UPPER_BOUND - LOWER_BOUND + 1;
	
	/**
	 * This method determines if a string is within the allowable bounds of ASCII codes 
	 * according to the LOWER_BOUND and UPPER_BOUND characters
	 * @param plainText a string to be encrypted, if it is within the allowable bounds
	 * @return true if all characters are within the allowable bounds, false if any character is outside
	 */
	public static boolean stringInBounds (String plainText) {
		boolean trueOrFalse = false;
		for(int i = 0; i < plainText.length(); i++){ 
			char ascii = plainText.charAt(i);
			if((int)ascii >= (int)LOWER_BOUND && (int)ascii <= (int)UPPER_BOUND) 
				trueOrFalse = true;
			else {
				trueOrFalse = false;
				break;
			}
		}
		System.out.print((int)LOWER_BOUND + " " +(int)UPPER_BOUND);
		return trueOrFalse;
	}

	/**
	 * Encrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in plainText is replaced by the character \"offset\" away from it 
	 * @param plainText an uppercase string to be encrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the encrypted string
	 */
	public static String encryptCaesar(String plainText, int key) {
		List<Character> encryptedChar = new ArrayList<>();
		String encryptedString = null;
		if(key < (int)LOWER_BOUND || key > (int)UPPER_BOUND) {
			do {
				if(key > (int)UPPER_BOUND)
					key -= RANGE;
				else if(key < (int)LOWER_BOUND)
					key += RANGE;
			}while(key < (int)LOWER_BOUND || key > (int)UPPER_BOUND);
		}
		for(int i = 0; i < plainText.length(); i++) {
			int ascii = plainText.charAt(i);
			ascii += key;
			if(ascii < (int)LOWER_BOUND || ascii > (int)UPPER_BOUND) {
				do {
					if(ascii > (int)UPPER_BOUND)
						ascii -= RANGE;
					else if(ascii < (int)LOWER_BOUND)
						ascii += RANGE;
				}while(ascii < (int)LOWER_BOUND || ascii > (int)UPPER_BOUND);
			}
			encryptedChar.add((char)ascii); 
			
		}  
		encryptedString = String.valueOf(encryptedChar);
		encryptedString = encryptedString.replaceAll("^\\[|]$", "").replace(", ", "");
		return encryptedString;
	}
	
	/**
	 * Encrypts a string according the Bellaso Cipher.  Each character in plainText is offset 
	 * according to the ASCII value of the corresponding character in bellasoStr, which is repeated
	 * to correspond to the length of plainText
	 * @param plainText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the encrypted string
	 */
	public static String encryptBellaso(String plainText, String bellasoStr) {
		List<Character> encryptedChar = new ArrayList<>();
		String encryptedString = null;
		
		int k = 0;
		for(int i = 0; i<plainText.length(); i++) {
			
			if(k > bellasoStr.length()-1) {
				i--;
				k=0;
				continue;
			}
			else if(k <= bellasoStr.length()-1) {
				int addChar = (int)bellasoStr.charAt(k++) + (int)plainText.charAt(i); 
				
				if(addChar < (int)LOWER_BOUND || addChar > (int)UPPER_BOUND) {
					do {
						if(addChar > (int)UPPER_BOUND)
							addChar -= RANGE;
						else if(addChar < (int)LOWER_BOUND)
							addChar += RANGE;
					}while(addChar < (int)LOWER_BOUND || addChar > (int)UPPER_BOUND);
				}
				encryptedChar.add((char)addChar);
			}	
		}
		
		encryptedString = String.valueOf(encryptedChar);
		encryptedString = encryptedString.replaceAll("^\\[|]$", "").replace(", ", "");
		return encryptedString;
	}
	
	/**
	 * Decrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in encryptedText is replaced by the character \"offset\" characters before it.
	 * This is the inverse of the encryptCaesar method.
	 * @param encryptedText an encrypted string to be decrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the plain text string
	 */
	public static String decryptCaesar(String encryptedText, int key) {
		String decryptedString = null;
		List<Character> decryptedChar = new ArrayList<>();
		if(key < (int)LOWER_BOUND && key > (int)UPPER_BOUND) {
			do {
				if(key > (int)UPPER_BOUND)
					key -= RANGE;
				else if(key < (int)LOWER_BOUND)
					key += RANGE;
			}while(key < (int)LOWER_BOUND && key > (int)UPPER_BOUND);
		}
		for(int i = 0; i < encryptedText.length(); i++) {
			int crypt = encryptedText.charAt(i);
			crypt -= key;
			if(crypt < (int)LOWER_BOUND) {
				do {
					crypt+=RANGE;
				}while(crypt < (int)LOWER_BOUND);
			}
			decryptedChar.add((char)crypt);
		}
		decryptedString = String.valueOf(decryptedChar);
		decryptedString = decryptedString.replaceAll("^\\[|]$", "").replace(", ", "");
		return decryptedString;
	}

	/**
	 * Decrypts a string according the Bellaso Cipher.  Each character in encryptedText is replaced by
	 * the character corresponding to the character in bellasoStr, which is repeated
	 * to correspond to the length of plainText.  This is the inverse of the encryptBellaso method.
	 * @param encryptedText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the decrypted string
	 */
	public static String decryptBellaso(String encryptedText, String bellasoStr) {
		String decryptedString = null;
		List<Character> decryptedChar = new ArrayList<>();
		int k = 0;
		for(int i = 0; i<encryptedText.length(); i++) {
			if(k > bellasoStr.length()-1) {
				i--;
				k=0;
				continue;
			}
			else if(k <= bellasoStr.length()-1) {
				int addChar = (int)encryptedText.charAt(i) - (int)bellasoStr.charAt(k++); 
				if(addChar < (int)LOWER_BOUND || addChar > (int)UPPER_BOUND) {
					do {
						if(addChar > (int)UPPER_BOUND)
							addChar -= RANGE;
						else if(addChar < (int)LOWER_BOUND)
							addChar += RANGE;
					}while(addChar < (int)LOWER_BOUND || addChar > (int)UPPER_BOUND);
				}
				decryptedChar.add((char)addChar);
			}	
		}
		decryptedString = String.valueOf(decryptedChar);
		decryptedString = decryptedString.replaceAll("^\\[|]$", "").replace(", ", "");
		return decryptedString;
	}

}
	
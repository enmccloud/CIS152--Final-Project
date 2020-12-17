/**
 * Decoder Class
 * 
 * @author Nikki McCloud
 * @version 1.0
 */
package HighScore;

public class Decoder {

	/**
	 * Encrypt Method
	 * 
	 * @param stats
	 * @param shift
	 * @return shifts characters via ceasar cipher and gives encrypted message
	 */
	public static String Encrypt(String stats, int shift) {
		String cCipher = "";
		for (int score = 0; score < stats.length(); score++) {
			char name = stats.charAt(score);

			cCipher = cCipher + shiftChar(name, shift);
		}
		return cCipher;
	}

	/**
	 * Shift Character Method
	 * 
	 * @param c
	 * @param shift
	 * @return encoded Char- shifted by cesear cipher.
	 */
	private static char shiftChar(char c, int shift) {

		if ('0' <= c && c <= '9') {
			return shiftChar('0', '9', c, shift);
		} else if ('a' <= c && c <= 'z') {
			return shiftChar('a', 'z', c, shift);
		} else if ('A' <= c && c <= 'Z') {
			return shiftChar('A', 'Z', c, shift);
		} else {
			throw new IllegalArgumentException("Input is incorrect.");
		}

	}

	/**
	 * Shift Character Method Expanded
	 * 
	 * @param smallest
	 * @param biggest
	 * @param c
	 * @param shift
	 * @return shifts char based on biggest/smallest.
	 */
	private static char shiftChar(char smallest, char biggest, char c, int shift) {
		int charSort = biggest - smallest + 1;
		shift = shift % charSort;

		c = (char) (c + shift);
		// handle wrapping
		if (c < smallest) {
			c += charSort;
		} else if (c > biggest) {
			c -= charSort;
		}
		return c;
	}

	/**
	 * Decrypt Method
	 * 
	 * @param stats
	 * @param shift
	 * @return decrypts player stats
	 */
	public static String Decrypt(String stats, int shift) {
		return Encrypt(stats, -shift);
	}
}
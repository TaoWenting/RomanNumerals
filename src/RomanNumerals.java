import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class RomanNumerals {
	
	private static Map<String, Integer> arabicAndRoman = new HashMap<String, Integer>();

	public static void main(String[] args) {
		fillArabicToRomanMap();
	}
    private static void fillArabicToRomanMap() {
    	arabicAndRoman.put("I",      1);
		arabicAndRoman.put("II",     2);
		arabicAndRoman.put("III",    3);
		arabicAndRoman.put("IV",     4);
		arabicAndRoman.put("V",      5);
		arabicAndRoman.put("VI",     6);
		arabicAndRoman.put("VII",    7);
		arabicAndRoman.put("VIII",   8);
		arabicAndRoman.put("IX",     9);
		arabicAndRoman.put("X",      10);
		arabicAndRoman.put("XX",   20);
		arabicAndRoman.put("XXX",   30);
		arabicAndRoman.put("XL",      40);
		arabicAndRoman.put("L",      50);
		arabicAndRoman.put("LX",      60);
		arabicAndRoman.put("LXX",      70);
		arabicAndRoman.put("LXX",      80);
		arabicAndRoman.put("XC",      90);
		arabicAndRoman.put("C",      100);
		arabicAndRoman.put("CC",      200);
		arabicAndRoman.put("CCC",      300);
		arabicAndRoman.put("CD",   	400);
		arabicAndRoman.put("D",   	500);
		arabicAndRoman.put("DC",   	600);
		arabicAndRoman.put("DCC",   	700);
		arabicAndRoman.put("DCCC",   	800);
		arabicAndRoman.put("CM",   	900);	// TODO Auto-generated method stub
		
	}
	public int convertToInteger(String romanNum) {
		int result = 0;

		/*
		 * A Roman number list created in order to iterate over all of the
		 * specific characters in the Roman number and then remove them in order
		 * to calculate the final sum
		 */

		List<Character> romanNumberList = new ArrayList<Character>();

		for (int i = 0; i < romanNum.length(); i++) {
			romanNumberList.add(romanNum.charAt(i));
		}

		while (romanNumberList.size() > 0) {

			/*
			 * 1st case: if there is only one character left or if the Roman
			 * number is only one character
			 */

			if (romanNumberList.size() == 1) {
				if (arabicAndRoman.containsKey(romanNumberList.get(0))) {
					result += arabicAndRoman.get(romanNumberList.get(0));
					romanNumberList.remove(0);
				}
			}

			if (romanNumberList.size() > 1) {
				for (int i = 0; i <= 0; i++) {

					/*
					 * 2nd case: Iff the number of characters left is more than 1
					 * and if there is a sign before the number which reduces
					 * the value of the specific character eg. the Roman number
					 * "IX" or 9 in Arabic here the value of the number "X" (10
					 * in Arabic) is reduced by 1 to 9 because of the "I"
					 * before.
					 */
					if (arabicAndRoman.get(romanNumberList.get(i + 1)) > arabicAndRoman.get(romanNumberList.get(i))) {
						result += (arabicAndRoman.get(romanNumberList.get(i + 1))
								- arabicAndRoman.get(romanNumberList.get(i)));
						romanNumberList.remove(i + 1);
						romanNumberList.remove(i);

						/*
						 * 3rd case: Iff the number of characters left is more than 1
						 * and if there is no characters before in the Roman number that reduce
						 * the value of the number eg. the Roman number "XVI" or 16 in Arabic notation.
						 * The number "X" is not reduced by any number since there is nothing before it and
						 * the number "V" is not reduced by any number because no smaller Roman number is before it
						 *  
						 */
						
					} else {
						result += arabicAndRoman.get(romanNumberList.get(i));
						romanNumberList.remove(i);
					}

				}
			}

		}

		return result;
	}
	
}
        
   

import static org.junit.Assert.*;

import org.junit.Test;

public class TestRomanNumerals {

	@Test
	public void test() {
		RomanNumerals test = new RomanNumerals();;

		assertEquals(1984, test.convertToInteger( "MCMLXXXIV"));
     //   assertEquals(test.convertToInteger( "MMXIV"), 2014);
	}

}

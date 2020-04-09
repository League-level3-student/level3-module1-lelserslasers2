package _03_IntroToStacks;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Stack;

import org.junit.Test;

public class _03_TestMatchingBrackets {

	@Test
	public void testMatchingBrackets() {
		assertTrue(doBracketsMatch("{}"));
		assertTrue(doBracketsMatch("{{}}"));
		assertTrue(doBracketsMatch("{}{}{{}}"));
		assertFalse(doBracketsMatch("{{}"));
		assertFalse(doBracketsMatch("}{"));
	}

	// USE A STACK TO COMPLETE THE METHOD FOR CHECKING IF EVERY OPENING BRACKET HAS A MATCHING CLOSING BRACKET
	private boolean doBracketsMatch(String b) {
		int opening = 0;
		int closing = 0;
		int reqC = 0;
		for (int i = 0; i < b.length(); i++) {
			if (reqC < 0) {
				return false;
			}
			if(b.charAt(i) == '{') {
				opening = opening + 1;
				reqC = reqC + 1;
			}
			else {
				closing = closing + 1;
				reqC = reqC - 1;
			}
		}
		if (opening == closing) {
			return true;
		}
		else {
			return false;
		}
	}

}
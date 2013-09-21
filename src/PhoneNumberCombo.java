import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PhoneNumberCombo {
	static Map<Character, Character[]> map;
	ArrayList<String> result;
	static {
		map = new HashMap<Character, Character[]>();
		map.put('2', new Character[] { 'a', 'b', 'c' });
		map.put('3', new Character[] { 'd', 'e', 'f' });
		map.put('4', new Character[] { 'g', 'h', 'i' });
		map.put('5', new Character[] { 'j', 'k', 'l' });
		map.put('6', new Character[] { 'm', 'n', 'o' });
		map.put('7', new Character[] { 'p', 'q', 'r', 's' });
		map.put('8', new Character[] { 't', 'u', 'v', });
		map.put('9', new Character[] { 'w', 'x', 'y', 'z' });

	}

	/**
	 * http://leetcode.com/oldoj#question_17
	 */
	public ArrayList<String> letterCombinations(String digits) {
		// Start typing your Java solution below
		// DO NOT write main() function
		result = new ArrayList<String>();
		generate("", digits.toCharArray(), 0);
		return result;
	}

	private void generate(String partial, char[] digits, int current) {
		if (current >= digits.length) {
			result.add("");
		} else if (current == digits.length - 1) {
			Character[] candidates = map.get(digits[current]);
			if (candidates != null) {
				for (char c : candidates) {
					result.add(partial + c);
				}
			}
		} else {
			Character[] candidates = map.get(digits[current]);
			for (char c : candidates) {
				generate(partial + c, digits, current + 1);
			}
		}
	}

	public static void main(String[] args) {
		PhoneNumberCombo pnc = new PhoneNumberCombo();
		System.out.println(pnc.letterCombinations("23"));
	}
}

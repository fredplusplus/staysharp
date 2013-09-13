import java.util.HashMap;
import java.util.Map;

public class RomanToInt {
	/**
	 * http://leetcode.com/onlinejudge#question_13
	 */
	public int romanToInt(String s) {
		// Start typing your Java solution below
		// DO NOT write main() function
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		map.put('I', 1);
		map.put('V', 5);
		map.put('X', 10);
		map.put('L', 50);
		map.put('C', 100);
		map.put('D', 500);
		map.put('M', 1000);
		int prev = 0;
		int curr = 0;
		int result = 0;
		for (char c : s.toCharArray()) {
			curr = map.get(c);
			result += curr;
			if (curr > prev) {
				result -= prev * 2;
			}
			prev = curr;
		}
		return result;
	}
}

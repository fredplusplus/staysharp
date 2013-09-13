import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class ValidParenthese {
	/**
	 * http://leetcode.com/onlinejudge#question_20
	 */
	public boolean isValid(String s) {
		LinkedList<Character> list = new LinkedList<Character>();
		Map<Character, Character> validMap = new HashMap<Character, Character>();
		validMap.put('(', ')');
		validMap.put('[', ']');
		validMap.put('{', '}');
		for (char c : s.toCharArray()) {
			if (c == '(' || c == '[' || c == '{') {
				list.addLast(c);
			} else {
				if (list.size() == 0) {
					return false;
				}
				char endOfList = list.getLast();
				if (c == validMap.get(endOfList)) {
					list.removeLast();
				} else {
					return false;
				}
			}
		}
		return list.size() == 0;
	}
}

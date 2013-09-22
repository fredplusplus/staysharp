import java.util.Stack;

public class LongestValidParenthese {
	/**
	 * http://leetcode.com/oldoj#question_32
	 */
	public int longestValidParentheses(String s) {
		char[] str = s.toCharArray();
		Stack<Integer> stack = new Stack<Integer>();
		int maxLength = 0;
		int last = -1; // last unmatched )
		for (int i = 0; i < str.length; i++) {
			if (str[i] == '(') {
				stack.push(i);
			} else {
				if (stack.isEmpty()) {
					last = i;
				} else {
					stack.pop();
					if (stack.isEmpty()) {
						maxLength = Math.max(maxLength, i - last);
					} else {
						maxLength = Math.max(maxLength, i - stack.peek());
					}
				}
			}
		}
		return maxLength;
	}

	public static void main(String[] args) {
		LongestValidParenthese lvp = new LongestValidParenthese();
		int len = lvp.longestValidParentheses("(()())(()()()()");
		System.out.println(len);
	}
}

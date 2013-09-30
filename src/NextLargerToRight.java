import java.util.Stack;

public class NextLargerToRight {
	/**
	 * http://www.geeksforgeeks.org/next-greater-element/
	 */
	public int[] nextLargerToRight(int[] num) {
		int[] result = new int[num.length];
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(0);
		for (int i = 1; i < num.length; i++) {
			int next = num[i];
			while (!stack.isEmpty() && num[stack.peek()] < next) {
				result[stack.pop()] = i;
			}
			stack.push(i);
		}
		while (!stack.isEmpty()) {
			result[stack.pop()] = -1;
		}
		return result;
	}
}

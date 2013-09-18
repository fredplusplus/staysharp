import java.util.Stack;

public class LargestRectangle {
	/**
	 * http://leetcode.com/oldoj#question_84
	 */
	public int largestRectangleArea(int[] height) {
		Stack<Integer> stack = new Stack<Integer>();
		int maxArea = 0;
		for (int i = 0; i < height.length; i++) {
			if (stack.isEmpty() || height[stack.peek()] <= height[i]) {
				stack.push(i);
			} else {
				while (!stack.isEmpty() && height[stack.peek()] > height[i]) {
					int current = stack.pop();
					int area = height[current] * (stack.isEmpty() ? i : (i - stack.peek() - 1));
					maxArea = Math.max(area, maxArea);
				}
				stack.push(i);
			}
		}
		while (!stack.isEmpty()) {
			int current = stack.pop();
			int area = height[current] * (stack.isEmpty() ? height.length : height.length - stack.peek() - 1);
			maxArea = Math.max(area, maxArea);
		}
		return maxArea;
	}

	public static void main(String[] args) {
		LargestRectangle lr = new LargestRectangle();
		System.out.println(lr.largestRectangleArea(new int[] { 2, 1, 5, 6, 2, 3 }));
	}
}

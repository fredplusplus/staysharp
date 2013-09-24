import java.util.Arrays;

public class ThreeSumClosest {
	/**
	 * http://leetcode.com/oldoj#question_16
	 */
	public int threeSumClosest(int[] num, int target) {
		Arrays.sort(num);
		int res = num[0] + num[1] + num[2];
		for (int i = 0; i < num.length - 2; i++) {
			int start = i + 1;
			int end = num.length - 1;
			while (start < end) {
				int sum = num[i] + num[start] + num[end];
				if (Math.abs(sum - target) < Math.abs(res - target)) {
					res = sum;
				}
				if (sum == target) {
					break;
				} else if (sum > target) {
					end--;
				} else {
					start++;
				}
			}
		}
		return res;
	}
}

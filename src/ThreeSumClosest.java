import java.util.ArrayList;
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

	public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		Arrays.sort(num);
		for (int i = 0; i < num.length; i++) {
			if (i > 0 && i < num.length && num[i] == num[i - 1]) {
				i++;
			}
			int start = i + 1;
			int end = num.length - 1;
			while (start < end) {
				if (num[i] + num[start] + num[end] == 0) {
					ArrayList<Integer> line = new ArrayList<Integer>();
					line.add(num[i]);
					line.add(num[start]);
					line.add(num[end]);
					result.add(line);
					do {
						start++;
					} while (start < end && num[start] == num[start - 1]);
					do {
						end--;
					} while (start < end && num[end] == num[end + 1]);
				} else if (num[i] + num[start] + num[end] > 0) {
					end--;
				} else {
					start++;
				}
			}
		}
		return result;
	}
}

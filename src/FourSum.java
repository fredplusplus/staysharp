import java.util.ArrayList;
import java.util.Arrays;

public class FourSum {
	/**
	 * http://leetcode.com/oldoj#question_18
	 */
	public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
		Arrays.sort(num);
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		int i = 0;

		while (i < num.length - 3) {
			int j = i + 1;
			while (j < num.length - 2) {
				int start = j + 1;
				int end = num.length - 1;
				while (start < end) {
					int sum = num[i] + num[j] + num[start] + num[end];
					if (sum == target) {
						ArrayList<Integer> set = new ArrayList<Integer>();
						set.add(num[i]);
						set.add(num[j]);
						set.add(num[start]);
						set.add(num[end]);
						res.add(set);
						start++;
						while (start < end && num[start] == num[start - 1]) {
							start++;
						}
						end--;
						while (start < end && num[end] == num[end + 1]) {
							end--;
						}
					} else if (sum > target) {
						end--;
						while (start < end && num[end] == num[end + 1]) {
							end--;
						}
					} else {
						start++;
						while (start < end && num[start] == num[start - 1]) {
							start++;
						}
					}
				}
				j++;
				while (j < num.length - 2 && num[j] == num[j - 1]) {
					j++;
				}
			}
			i++;
			while (i < num.length - 3 && num[i] == num[i - 1]) {
				i++;
			}
		}
		return res;
	}
}

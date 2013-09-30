public class GetGroupSum {
	/**
	 * http://www.crazyforcode.com/sum-elements-array-sum-equal-number/
	 */
	public boolean hasGroupSum(int[] nums, int target) {
		int sum = nums[0];
		int start = 0;
		for (int end = 1; end < nums.length; end++) {
			while (sum > target && start < end) {
				sum -= nums[start];
				start++;
			}
			if (sum == target) {
				return true;
			}
			sum += nums[end];
		}
		return false;
	}
}

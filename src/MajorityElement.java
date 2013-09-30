public class MajorityElement {
	/**
	 * http://www.crazyforcode.com/find-majority-element-array-on/
	 */
	int findMajority(int[] nums) {
		int candidate = nums[0];
		int counter = 0;
		for (int i = 0; i < nums.length; i++) {
			if (candidate == nums[i]) {
				counter++;
			} else if (counter == 0) {
				candidate = nums[i];
				counter++;
			} else {
				counter--;
			}
		}
		return candidate;
	}
}

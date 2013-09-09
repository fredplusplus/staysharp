public class SearchInsertPosition {
	/**
	 * http://leetcode.com/onlinejudge#question_35
	 */
	public int searchInsert(int[] A, int target) {
		return binarySearch(A, 0, A.length - 1, target);
	}

	private int binarySearch(int[] nums, int start, int end, int target) {
		if (start >= end) {
			if (nums[start] >= target) {
				return start;
			} else {
				return start + 1;
			}
		}
		int mid = start + (end - start) / 2;
		if (nums[mid] == target) {
			return mid;
		} else if (nums[mid] > target) {
			return binarySearch(nums, start, mid - 1, target);
		} else {
			return binarySearch(nums, mid + 1, end, target);
		}
	}
}

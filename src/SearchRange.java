public class SearchRange {
	/**
	 * http://leetcode.com/oldoj#question_36
	 */
	public int[] searchRange(int[] A, int target) {
		int[] range = new int[2];
		int lower = 0;
		int upper = A.length;
		int mid = 0;
		while (lower < upper) {
			mid = (lower + upper) / 2;
			if (A[mid] < target)
				lower = mid + 1;
			else
				upper = mid;
		}

		// If the target is not found, return (-1, -1)
		if (lower < 0 || lower >= A.length || A[lower] != target) {
			range[0] = -1;
			range[1] = -1;
			return range;
		}

		range[0] = lower;

		// Search for upper bound
		upper = A.length;
		while (lower < upper) {
			mid = (lower + upper) / 2;
			if (A[mid] > target)
				upper = mid;
			else
				lower = mid + 1;
		}
		range[1] = upper - 1;

		return range;
	}

	public static void main(String[] args) {
		SearchRange sr = new SearchRange();
		sr.searchRange(new int[] { 2, 2 }, 3);
	}
}

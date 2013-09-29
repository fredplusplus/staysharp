public class SearchInRotatedArray {
	/**
	 * http://leetcode.com/oldoj#question_81
	 */
	public boolean search(int[] A, int target) {
		if (A == null || A.length == 0) {
			return false;
		} else {
			return search(A, target, 0, A.length - 1);
		}
	}

	private boolean search(int[] a, int target, int left, int right) {
		if (left > right) {
			return false;
		}
		int mid = left + (right - left) / 2;
		if (a[mid] == target) {
			return true;
		} else {
			boolean found = false;
			if (a[mid] > a[left] && a[left] <= target && target < a[mid]) {
				found = found || search(a, target, left, mid - 1);
			}
			if (!found && a[mid] < a[right] && a[mid] < target && target <= a[right]) {
				found = search(a, target, mid + 1, right);
			}
			if (!found && a[mid] <= a[left]) {
				found = found || search(a, target, left, mid - 1);
			}
			if (!found && a[mid] >= a[right]) {
				found = search(a, target, mid + 1, right);
			}
			return found;
		}
	}
}

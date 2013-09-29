public class BinarySearchInRotatedArray {
	/**
	 * http://leetcode.com/oldoj#question_33
	 * 
	 */
	public int search1(int[] A, int target) {
		if (A == null) {
			return -1;
		}
		int start = 0;
		int end = A.length;
		int result = -1;
		while (start < end) {
			int mid = start + (end - start) / 2;
			if (A[mid] == target) {
				result = mid;
				break;
			}
			if (A[start] < A[mid]) {
				if (A[start] <= target && target < A[mid]) {
					end = mid;
				} else {
					start = mid + 1;
				}
			} else {
				if (A[mid] < target && target <= A[end - 1]) {
					start = mid + 1;
				} else {
					end = mid;
				}
			}
		}
		return result;
	}

	public boolean search(int[] A, int target) {
		if (A == null) {
			return false;
		}
		int start = 0;
		int end = A.length;
		boolean result = false;
		while (start < end) {
			int mid = start + (end - start) / 2;
			if (A[mid] == target) {
				result = true;
				break;
			}
			if (A[start] < A[mid]) {
				if (A[start] <= target && target < A[mid]) {
					end = mid;
				} else {
					start = mid + 1;
				}
			} else {
				if (A[mid] < target && target <= A[end - 1]) {
					start = mid + 1;
				} else {
					end = mid;
				}
			}
		}
		return result;
	}
}

public class MedianOfTwoSortedArray {
	/**
	 * http://leetcode.com/oldoj#question_4
	 */
	public double findMedianSortedArrays(int A[], int B[]) {
		if (A.length == 0) {
			return findMedian(B);
		} else if (B.length == 0) {
			return findMedian(A);
		} else if (A.length > B.length) {
			return findMedian(A, B, 0, A.length - 1);
		} else {
			return findMedian(B, A, 0, B.length - 1);
		}
	}

	private double findMedian(int[] A) {
		if (A.length == 1) {
			return A[0];
		}
		if (A.length % 2 == 1) {
			return A[A.length / 2 - 1];
		} else {
			int mid = A.length / 2;
			return (A[mid] + A[mid - 1]) / 2.0;
		}
	}

	private double findMedian(int[] A, int[] B, int l, int r) {
		if (l > r) {
			return findMedian(B, A, Math.max(0, (A.length + B.length) / 2 - A.length),
					Math.min(B.length, (A.length + B.length) / 2));
		}
		int i = (l + r) / 2;
		int j = (A.length + B.length) / 2 - i - 1;
		if (j >= 0 && A[i] < B[j]) {
			return findMedian(A, B, i + 1, r);
		} else if (j < B.length - 1 && A[i] > B[j + 1]) {
			return findMedian(A, B, l, i - 1);
		} else {
			if ((A.length + B.length) % 2 == 1) {
				return A[i];
			} else if (i > 0) {
				if (j >= 0 && j < B.length) {
					return (A[i] + Math.max(B[j], A[i - 1])) / 2.0;
				} else {
					return (A[i] + A[i - 1]) / 2.0;
				}

			} else {
				return (A[i] + B[j]) / 2.0;
			}
		}
	}

	public static void main(String[] args) {
		MedianOfTwoSortedArray m = new MedianOfTwoSortedArray();

		System.out.println(m.findMedianSortedArrays(new int[] { 4 }, new int[] { 1, 2, 3, 5, 6, 7 }));
	}
}

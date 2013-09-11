public class TrapRainWater {
	/**
	 * http://leetcode.com/onlinejudge#question_42
	 */
	public int trap(int[] A) {
		if (A == null) {
			return 0;
		}
		int high = 0;
		for (int i = 0; i < A.length; i++) {
			if (A[i] > A[high]) {
				high = i;
			}
		}
		int rain = 0;
		int h = 0;
		for (int i = 0; i < high; i++) {
			if (A[i] < h) {
				rain += h - A[i];
			} else {
				h = A[i];
			}
		}
		h = 0;
		for (int i = A.length - 1; i > high; i--) {
			if (A[i] < h) {
				rain += h - A[i];
			} else {
				h = A[i];
			}
		}
		return rain;
	}

	public static void main(String[] args) {
		TrapRainWater wt = new TrapRainWater();
		System.out.println(wt.trap(new int[] { 1, 0, 1, 0 }));
	}
}

/**
 * http://leetcode.com/onlinejudge#question_31
 * 
 */
public class NextPermutation {
	public void nextPermutation(int[] num) {
		// error checking
		if (num == null || num.length <= 1) {
			return;
		}
		// find the rightmost i-1/ith pair s.t num[i-1]<num[i]
		int r = num.length, l = num.length;
		for (int i = num.length - 1; i >= 1; i--) {
			if (num[i] > num[i - 1]) {
				r = i;
				l = i - 1;
				break;
			}
		}
		// if found:
		if (r == l + 1) {
			// move i to right as long as num[i-1 < num[i
			while (r < num.length - 1 && num[r + 1] > num[l]) {
				r++;
			}
			// swap i-1 and new i
			int temp = num[l];
			num[l] = num[r];
			num[r] = temp;
			// reverse everything to the right of i-1
			l++;
			r = num.length - 1;
			while (l < r) {
				temp = num[l];
				num[l] = num[r];
				num[r] = temp;
				l++;
				r--;
			}
		} else {
			// if not found:
			l = 0;
			r = num.length - 1;
			while (l < r) {
				int temp = num[l];
				num[l] = num[r];
				num[r] = temp;
				l++;
				r--;
			}
			return;
		}
	}
}

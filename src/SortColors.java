/**
 * http://leetcode.com/onlinejudge#question_75
 * 
 * 
 */
public class SortColors {
	public void sortColors(int[] A) {
		int zero = 0;
		int one = 0;
		int two = A.length - 1;
		while (one <= two) {
			if (A[one] == 2) {
				// swap one two
				int temp = A[one];
				A[one] = A[two];
				A[two] = temp;
				two--;
			} else if (A[one] == 0) {
				// swap zero/one
				int temp = A[one];
				A[one] = A[zero];
				A[zero] = temp;
				zero++;
				one++;
			} else {
				one++;
			}
		}
	}
	
	
}

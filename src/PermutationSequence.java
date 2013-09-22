import java.util.ArrayList;

public class PermutationSequence {

	/**
	 * http://leetcode.com/oldoj#question_60
	 */
	public String getPermutation(int n, int k) {
		int[] fact = prepareFactorial(n);
		int[] index = new int[n];
		k--;
		for (int i = n - 1; i >= 0; i--) {
			while (k >= fact[i]) {
				index[i]++;
				k -= fact[i];
			}
		}
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		for (int i = 1; i <= n; i++) {
			numbers.add(i);
		}
		String result = "";
		for (int i = n - 1; i >= 0; i--) {
			result += numbers.get(index[i]);
			numbers.remove(index[i]);
		}
		return result;
	}

	public int[] prepareFactorial(int n) {
		int[] fact = new int[n + 1];
		fact[0] = 1;
		fact[1] = 1;
		for (int i = 1; i <= n; i++) {
			fact[i] = i * fact[i - 1];
		}
		return fact;
	}

	public static void main(String[] args) {
		PermutationSequence ps = new PermutationSequence();
		String res = ps.getPermutation(3, 2);
		System.out.println(res);
	}

}

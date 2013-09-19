import java.util.ArrayList;

public class GrayCode {
	/**
	 * http://leetcode.com/oldoj#question_89
	 */
	public ArrayList<Integer> grayCode(int n) {
		ArrayList<Integer> codes = new ArrayList<Integer>();
		for (int i = 0; i <= n; i++) {
			if (i == 0) {
				codes.add(0);
			} else {
				int mask = 1 << (i - 1);
				for (int j = codes.size() - 1; j >= 0; j--) {
					int grayForJ = mask | codes.get(j);
					codes.add(grayForJ);
				}
			}
		}
		return codes;
	}

	public static void main(String[] args) {
		GrayCode gc = new GrayCode();
		System.out.println(gc.grayCode(3));
	}
}

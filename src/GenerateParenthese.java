import java.util.ArrayList;

/**
 * http://leetcode.com/onlinejudge#question_22
 * 
 */
public class GenerateParenthese {
	public ArrayList<String> generateParenthesis(int n) {
		ArrayList<String> result = new ArrayList<String>();
		generate(result, "", n, 0);
		return result;
	}

	private void generate(ArrayList<String> result, String partial, int l, int r) {
		if (l == 0 && r == 0) {
			result.add(partial);
			return;
		}
		if (l > 0) {
			generate(result, partial + "(", l - 1, r + 1);
		}
		if (r > 0) {
			generate(result, partial + ")", l, r - 1);
		}
	}
}

import java.util.ArrayList;

/**
 * http://leetcode.com/onlinejudge#question_118
 * 
 */
public class PascalTriangle {
	public ArrayList<ArrayList<Integer>> generate(int numRows) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (numRows == 0) {
			return result;
		} else {
			for (int row = 0; row < numRows; row++) {
				ArrayList<Integer> rowResult = new ArrayList<Integer>();
				rowResult.add(1);
				for (int col = 0; col < row - 1; col++) {
					rowResult.add(result.get(row - 1).get(col) + result.get(row - 1).get(col + 1));
				}
				if (row > 0) {
					rowResult.add(1);
				}
				result.add(rowResult);
			}
			return result;
		}
	}
}

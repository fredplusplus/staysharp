import java.util.ArrayList;

public class TrianglePath {
	/**
	 * http://leetcode.com/onlinejudge#question_120
	 */
	public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
		if (triangle == null || triangle.size() == 0) {
			return 0;
		} else {
			return solve(new int[triangle.size()], triangle, 0);
		}
	}

	private int solve(int[] sums, ArrayList<ArrayList<Integer>> triangle, int level) {
		if (level == triangle.size()) {
			int min = sums[0];
			for (int i = 0; i < level; i++) {
				min = Math.min(sums[i], min);
			}
			return min;
		} else {
			ArrayList<Integer> currentLevel = triangle.get(level);
			int[] newSum = new int[currentLevel.size()]; 
			for (int i = 0; i < currentLevel.size(); i++) {
				if (i == 0) {
					newSum[i] = currentLevel.get(i) + sums[i];

				} else if (i == currentLevel.size() - 1) {
					newSum[i] = sums[i - 1] + currentLevel.get(i);
				} else {
					newSum[i] = currentLevel.get(i) + Math.min(sums[i], sums[i - 1]);
				}
			}
			sums = newSum;
			return solve(sums, triangle, level + 1);
		}
	}
}

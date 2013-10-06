/**
 * http://leetcode.com/onlinejudge#question_97
 * 
 * @author fanzhang
 * 
 */
public class InteleavingString {
	public boolean isInterleave(String s1, String s2, String s3) {
		if (s1 == null || s1.length() == 0) {
			return s2.equals(s3);
		} else if (s2 == null || s2.length() == 0) {
			return s1.equals(s3);
		}
		int s1len = s1.length();
		int s2len = s2.length();
		int s3len = s3.length();
		if (s1len + s2len != s3len) {
			return false;
		}
		boolean[][] result = new boolean[s1len + 1][s2len + 1];
		result[0][0] = true;
		for (int i = 1; i < s1len + 1; i++) {
			result[i][0] = result[i - 1][0] && s3.charAt(i - 1) == s1.charAt(i - 1);
		}
		for (int i = 1; i < s2len + 1; i++) {
			result[0][i] = result[0][i - 1] && s3.charAt(i - 1) == s2.charAt(i - 1);
		}
		for (int i = 1; i < result.length; i++) {
			for (int j = 1; j < result[0].length; j++) {
				if (s3.charAt(i + j - 1) != s1.charAt(i - 1) && s3.charAt(i + j - 1) != s2.charAt(j - 1)) {
					result[i][j] = false;
				} else if (s3.charAt(i + j - 1) == s1.charAt(i - 1) && s3.charAt(i + j - 1) != s2.charAt(j - 1)) {
					result[i][j] = result[i - 1][j];
				} else if (s3.charAt(i + j - 1) != s1.charAt(i - 1) && s3.charAt(i + j - 1) == s2.charAt(j - 1)) {
					result[i][j] = result[i][j - 1];
				} else {
					result[i][j] = result[i][j - 1] || result[i - 1][j];
				}
			}
		}
		return result[s1len][s2len];
	}

	public static void main(String[] args) {
		InteleavingString is = new InteleavingString();
		System.out.println(is.isInterleave("aabaac", "aadaaeaaf", "aadaaeaabaafaac"));
	}
}

/**
 * http://leetcode.com/onlinejudge#question_97
 * 
 * @author fanzhang
 * 
 */
public class InteleavingString {
	public boolean isInterleave(String s1, String s2, String s3) {
		// define C[i][j] is true when c[0... i+j-1] is interleaving of a[0..i]
		// + b[0..j]
		int len1 = s1.length();
		int len2 = s2.length();
		int len3 = s3.length();
		if (len1 + len2 != len3) {
			return false;
		}
		if (len1 ==0) {
		    return s3.equals(s2);
		} else if (len2 ==0) {
		    return s3.equals(s1);
		}
		boolean[][] result = new boolean[len1][len2];
		// all strings empty case
		result[0][0] = true;

		for (int i = 0; i < len1; i++) {
			for (int j = 0; j < len2; j++) {
				// s1 is empty
				if (i == 0 && s2.charAt(j) == s3.charAt(j)) {
					if (j == 0) {
						result[i][j] = true;
					} else {
						result[i][j] = result[i][j - 1];
					}
				}
				// s2 is empty
				else if (j == 0 && s1.charAt(i) == s3.charAt(i)) {
					if (i == 0) {
						result[i][j] = true;
					} else {
						result[i][j] = result[i - 1][j];
					}
				}
				// both available, s1 matches s3, s2 doesnt
				else if (s1.charAt(i) == s3.charAt(i + j) && s2.charAt(j) != s3.charAt(i + j)) {
					result[i][j] = result[i - 1][j];
				} else if (s1.charAt(i) != s3.charAt(i + j) && s2.charAt(j) == s3.charAt(i + j)) {
					result[i][j] = result[i][j - 1];
				} else if (s1.charAt(i) == s3.charAt(i + j) && s2.charAt(j) == s3.charAt(i + j)) {
					result[i][j] = result[i][j - 1] || result[i - 1][j];
				} else {
					result[i][j] =false;
				}
			}
		}
		return result[len1-1][len2-1];
	}
	
	public static void main(String[] args) {
		InteleavingString is = new InteleavingString();
		System.out.println(is.isInterleave("aa", "ab", "aaba"));
	}
}

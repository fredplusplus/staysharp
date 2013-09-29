/**
 * http://leetcode.com/onlinejudge#question_65
 * 
 * @author fanzhang
 * 
 */
public class ValidNumber {
	/**
	 * term ok n       n   y n y  y  n  n     y n y   y
	 * max len m       1   m 1 m  m  1  1     m 1 m   m
	 * area    1       2   3 4 5  12  6  7     8 9 10  11
	 * format <space>[+|-]num.num sp|[e [+|-] num.num] <space>
	 */
	public boolean isNumber(String s) {
		int area = 1;
		for (Character c : s.toCharArray()) {
			switch (c) {
				case ' ':
					if (area == 1 || area == 11 || area == 5 || area == 12) {
						if (area == 5) {
							area = 12;
						}
						break;
					}
					return false;
				case '+':
				case '-':
					if (area == 1 || area == 6) {
						area ++;
						break;
					} else {
						return false;
					}
				case '.':
					if (area == 1 || area == 2) {
						area = 5;
					} else if (area == 6 || area == 7 ) {
						area = 10;
					}
					else if (area == 3 || area == 8) {
						area +=2;
						break;
					} else {
						return false;
					}
				case 'e':
					if (area == 5 || area == 3) {
						area = 6;
						break;
					} else {
						return false;
					}
				default:
					if (c >= '0' && c <='9' && (area == 1 || area ==2 ||area == 3 || area == 5 || area == 6 ||area == 7||area == 8 || area == 10)) {
						if (area == 1) {
							area = 3;
						}
						else if (area == 2) {
							area = 3;
						}
						else if (area == 6 || area == 7) {
							area = 8;
						}
						break;
					} else {
						return false;
					}
			}
		}
		return (area == 3 || area == 5 || area == 8 || area == 10 || area == 11 | area == 12);
	}
}

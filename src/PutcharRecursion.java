public class PutcharRecursion {
	/**
	 * http://leetcode.com/2010/02/here-is-one-of-questions-from-microsoft.html
	 */
	public String putString(long val) {
		String result = "";
		if (val == 0) {
			return "0";
		}
		if (val < 0) {
			val = -val;
			result = "-";
		}
		return result + put(val);
	}

	private String put(long val) {
		if (val == 0) {
			return "";
		} else {
			return put(val / 10) + val % 10;
		}
	}

	public static void main(String[] args) {
		PutcharRecursion pr = new PutcharRecursion();
		System.out.println(pr.putString(0));
		System.out.println(pr.putString(-123));
		System.out.println(pr.putString(123));
		System.out.println(pr.putString(12340));
		System.out.println(pr.putString(120340));

	}

}

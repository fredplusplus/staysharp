public class CountAndSay {
	/**
	 * http://leetcode.com/oldoj#question_38
	 */
	public String countAndSay(int n) {
		char[] say = new char[] { '1' };
		int i = 1;
		while (i < n) {
			String newSay = "";
			Character c = say[0];
			int startIndex = 0;
			for (int j = 1; j < say.length; j++) {
				if (c != say[j]) {
					int count = j - startIndex;
					newSay += count;
					newSay += c;
					c = say[j];
					startIndex = j;
				}
			}
			newSay += say.length - startIndex;
			newSay += c;
			say = newSay.toCharArray();
			i++;
		}
		return new String(say);
	}
}

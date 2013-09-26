public class WordCount {
	/**
	 * http://leetcode.com/2010/02/c-code-to-count-number-of-words-in.html
	 */
	public int count(String paragraph) {
		int count = 0;
		boolean inWord = false;
		if (paragraph != null) {
			for (Character c : paragraph.toCharArray()) {
				if (c == ' ') {
					if (inWord) {
						count++;
					}
					inWord = false;
				} else {
					inWord = true;
				}
			}
			if (inWord) {
				count++;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		WordCount wc = new WordCount();
		System.out.println(wc.count(" hello world x"));
	}
}

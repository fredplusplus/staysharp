import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;

public class WordLadder {
	/**
	 * http://leetcode.com/oldoj#question_127
	 */
	public int ladderLength(String start, String end, HashSet<String> dict) {
		dict.add(end);
		LinkedList<String> queue = new LinkedList<String>();
		queue.addLast(start);
		dict.remove(start);
		int currentLevelCount = 1;
		int nextLevelCount = 0;
		int ret = 0;
		while (!queue.isEmpty()) {
			String word = queue.removeFirst();
			currentLevelCount--;

			for (int i = 0; i < word.length(); i++) {
				char[] rawWord = word.toCharArray();
				for (int j = 0; j < 26; j++) {
					rawWord[i] = (char) (j + 'a');
					if (end.equals(new String(rawWord))) {
						return ret + 2;
					}
					String candidate = new String(rawWord);
					if (dict.contains(candidate)) {
						queue.addLast(candidate);
						dict.remove(candidate);
						nextLevelCount++;
					}
				}
			}
			if (currentLevelCount == 0) {
				currentLevelCount = nextLevelCount;
				nextLevelCount = 0;
				ret++;
			}
		}
		return 0;
	}

	public static void main(String[] args) {
		WordLadder wl = new WordLadder();
		HashSet<String> dict = new HashSet<String>();
		dict.addAll(Arrays.asList("hot", "cog", "dot", "dog", "hit", "lot", "log"));
		System.out.println(wl.ladderLength("hit", "cog", dict));
	}
}

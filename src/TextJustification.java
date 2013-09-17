import java.util.ArrayList;

public class TextJustification {
	/**
	 * http://leetcode.com/oldoj#question_68
	 */
	public ArrayList<String> fullJustify(String[] words, int L) {
		ArrayList<String> result = new ArrayList<String>();
		ArrayList<String> line = new ArrayList<String>();
		int lineLength = 0;
		int wordLength = 0;
		for (String word : words) {
			if (lineLength + word.length() <= L) {
				line.add(word);
				lineLength += word.length() + 1;
				wordLength += word.length();
			} else {
				// justify all
				result.add(justify(line, wordLength, L, false));
				// reset and add current
				line = new ArrayList<String>();
				line.add(word);
				lineLength = word.length() + 1;
				wordLength = word.length();
			}
		}
		if (!line.isEmpty()) {
			// justify all
			result.add(justify(line, wordLength, L, true));
		}
		return result;
	}

	private String justify(ArrayList<String> line, int wordLength, int L, boolean lastLine) {
		int empties = line.size() - 1;
		if (empties == 0 || lastLine) {
			String result = "";
			for (int i = 0; i < line.size(); i++) {
				result += line.get(i);
				if (i != line.size() - 1) {
					result += " ";
				}
			}
			for (int i = result.length(); i < L; i++) {
				result += " ";
			}
			return result;
		} else {
			int smallSpace = (L - wordLength) / empties;
			int bigSpaceCount = (L - wordLength) % empties;
			String space = "";
			for (int i = 0; i < smallSpace; i++) {
				space += " ";
			}
			StringBuilder result = new StringBuilder();
			for (int i = 0; i < line.size(); i++) {
				result.append(line.get(i));
				if (i < bigSpaceCount) {
					result.append(" ");
				}
				if (i != line.size() - 1) {
					result.append(space);
				}
			}
			return result.toString();
		}
	}
}

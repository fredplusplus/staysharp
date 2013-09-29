import java.util.ArrayList;
import java.util.HashMap;

public class SubstringWithConcatenationOfAllWords {
	/**
	 * http://leetcode.com/oldoj#question_30
	 */
	public ArrayList<Integer> findSubstring(String S, String[] L) {
		HashMap<String, Integer> needMaster = new HashMap<String, Integer>();
		ArrayList<Integer> set = new ArrayList<Integer>();
		int len = L[0].length();
		int totalLen = len * L.length;
		for (String l : L) {
			if (needMaster.get(l) == null) {
				needMaster.put(l, 1);
			} else {
				needMaster.put(l, needMaster.get(l) + 1);
			}
		}

		for (int i = 0; i <= S.length() - totalLen; i++) {
			HashMap<String, Integer> need = new HashMap<String, Integer>(needMaster);
			for (int j = 0; j < totalLen; j += len) {
				String sub = S.substring(i + j, i + j + len);
				Integer needCount = need.get(sub);
				if (needCount == null) {
					break;
				} else {
					needCount--;
					if (needCount == 0) {
						need.remove(sub);
					} else {
						need.put(sub, needCount);
					}
				}
			}
			if (need.isEmpty()) {
				set.add(i);
			}
		}
		return set;
	}
}

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class GroupOfAnagram {
	/**
	 * http://leetcode.com/onlinejudge#question_49
	 */
	public ArrayList<String> anagrams(String[] strs) {
		Map<String, ArrayList<String>> anaMap = new HashMap<String, ArrayList<String>>();
		for (String s : strs) {
			String ana = getAnaKey(s);
			ArrayList<String> anagrams = anaMap.get(ana);
			if (anagrams == null) {
				anagrams = new ArrayList<String>();
			}
			anagrams.add(s);
			anaMap.put(ana, anagrams);
		}
		ArrayList<String> result = new ArrayList<String>();
		for (Entry<String, ArrayList<String>> entry : anaMap.entrySet()) {
			if (entry.getValue().size() > 1) {
				result.addAll(entry.getValue());
			}
		}
		return result;
	}

	private String getAnaKey(String str) {
		int[] chars = new int[26];
		for (char c : str.toCharArray()) {
			chars[c - 'a']++;
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < chars.length; i++) {
			if (chars[i] > 0) {
				sb.append((char) ('a' + i)).append(chars[i]).append(":");
			}
		}
		return sb.toString();
	}
}

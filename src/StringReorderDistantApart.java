public class StringReorderDistantApart {

	/**
	 * http://leetcode.com/2010/05/here-is-another-google-phone-interview.html
	 */
	public String reorderString(String source, int k) {
		int[] freq = new int[256];
		for (Character c : source.toCharArray()) {
			freq[c]++;
		}
		int[] used = new int[256];
		String result = "";
		for (int i = 0; i < source.length(); i++) {
			boolean[] excep = new boolean[256];
			boolean done = false;
			while (!done) {
				int j = findMaxFreq(freq, excep);
				if (j == -1) {
					return null;
				}
				excep[j] = true;
				if (used[j] <= 0) {
					used[j] = k;
					freq[j]--;
					result += (char) j;
					done = true;
				}
			}
			for (int j = 0; j < 256; j++) {
				used[j]--;
			}
		}
		return result;
	}

	private int findMaxFreq(int[] freq, boolean[] excep) {
		int maxFreq = -1;
		for (int i = 0; i < freq.length; i++) {
			if (excep[i] == false && freq[i] > 0 && (maxFreq == -1 || freq[i] > freq[maxFreq])) {
				maxFreq = i;
			}
		}
		return maxFreq;
	}
}

import java.util.HashMap;
import java.util.Map;

/**
 * http://leetcode.com/onlinejudge#question_128
 * 
 * 
 */
public class LongestConsequtiveSequence {
	public int longestConsecutive(int[] nums) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (nums == null || nums.length == 0) {
			return 0;
		} else {
			int max = 0;
			Map<Integer, Integer> countMap = new HashMap<Integer, Integer>();
			for (Integer num : nums) {
				Integer numCount = countMap.get(num);
				if (numCount != null) {
					continue;
				} else {
					Integer nextCount = countMap.get(num + 1);
					Integer previousCount = countMap.get(num - 1);
					numCount = (nextCount == null ? 0 : nextCount) + (previousCount == null ? 0 : previousCount) + 1;
					countMap.put(num, numCount);
					if (nextCount != null) {
						countMap.put(num + nextCount, numCount);
					}
					if (previousCount != null) {
						countMap.put(num - previousCount, numCount);
					}
					if (numCount > max) {
						max = numCount;
					}
				}
			}
			return max;
		}
	}

	public static void main(String[] args) {
		LongestConsequtiveSequence seq = new LongestConsequtiveSequence();

		System.out.println(seq.longestConsecutive(new int[] { 0, 3, 7, 2, 5, 8, 4, 6, 0, 1 }));
	}
}

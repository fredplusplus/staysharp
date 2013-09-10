/**
 * http://leetcode.com/onlinejudge#question_11
 * 
 * @author fanzhang
 * 
 */
public class ContainerWithMostWater {
	public int maxArea(int[] height) {
		if (height == null || height.length <= 1) {
			return 0;
		} else {
			int max = 0;
			int low = 0;
			int high = height.length - 1;
			while (low < high) {
				int area = (high - low) * Math.min(height[low], height[high]);
				max = Math.max(max, area);
				if (height[low] < height[high]) {
					low++;
				} else {
					high--;
				}
			}
			return max;
		}
	}
}

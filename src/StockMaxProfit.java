/**
 * http://leetcode.com/onlinejudge#question_121
 * 
 * @author fanzhang
 * 
 */
public class StockMaxProfit {
	public int maxProfit(int[] prices) {
		if (prices == null || prices.length < 2) {
			return 0;
		}
		int min = prices[0];
		int maxDiff = 0;
		for (int price : prices) {
			if (price < min) {
				min = price;
			} else {
				int diff = price - min;
				if (diff > maxDiff) {
					maxDiff = diff;
				}
			}
		}
		return maxDiff;
	}
}

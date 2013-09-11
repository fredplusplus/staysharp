public class StockMaxProfit {
	/**
	 * http://leetcode.com/onlinejudge#question_121
	 * 
	 * @author fanzhang
	 * 
	 */
	public int maxProfit1(int[] prices) {
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

	/**
	 * http://leetcode.com/onlinejudge#question_122
	 */
	public int maxProfit(int[] prices) {
		if (prices == null || prices.length <= 1) {
			return 0;
		}
		int profit = 0;
		for (int i = 1; i < prices.length; i++) {
			int diff = prices[i] - prices[i - 1];
			if (diff > 0) {
				profit += diff;
			}
		}
		return profit;
	}
}

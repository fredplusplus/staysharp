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
	public int maxProfit2(int[] prices) {
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

	/**
	 * http://leetcode.com/onlinejudge#question_123
	 * 
	 */
	public int maxProfit(int[] prices) {
		if (prices == null || prices.length <= 1) {
			return 0;
		}
		int[] backProfit = new int[prices.length];
		int[] futureProfit = new int[prices.length];
		int low = prices[0];
		for (int i = 1; i < backProfit.length; i++) {
			if (prices[i] < low) {
				low = prices[i];
				backProfit[i] = backProfit[i - 1];
			} else {
				int profit = prices[i] - low;
				backProfit[i] = Math.max(backProfit[i - 1], profit);
			}
		}
		int high = prices[prices.length - 1];
		for (int i = futureProfit.length - 2; i >= 0; i--) {
			if (prices[i] > high) {
				high = prices[i];
				futureProfit[i] = futureProfit[i + 1];
			} else {
				int profit = high - prices[i];
				futureProfit[i] = Math.max(profit, futureProfit[i + 1]);
			}
		}
		int maxProfit = 0;
		for (int i = 0; i < prices.length; i++) {
			int profit = backProfit[i] + futureProfit[i];
			maxProfit = Math.max(maxProfit, profit);
		}
		return maxProfit;
	}
}

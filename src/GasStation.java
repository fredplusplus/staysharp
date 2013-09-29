public class GasStation {
	/**
	 * http://oj.leetcode.com/problems/gas-station/
	 */
	public int canCompleteCircuit(int[] gas, int[] cost) {
		int[] netCost = new int[2 * gas.length];
		for (int i = 0; i < gas.length; i++) {
			netCost[i] = gas[i] - cost[i];
		}
		for (int i = gas.length; i < 2 * gas.length; i++) {
			netCost[i] = netCost[i - gas.length];
		}
		int startPoint = 0;
		int count = 0;
		int tank = 0;
		for (int i = 0; i < netCost.length; i++) {
			tank += netCost[i];
			if (tank < 0) {
				count = 0;
				tank = 0;
				startPoint = i + 1;
			} else {
				count++;
				if (count == gas.length) {
					break;
				}
			}
		}
		if (count == gas.length) {
			return startPoint;
		} else {
			return -1;
		}
	}
}

public class PointInRectangle {
	/**
	 * http://leetcode.com/2010/04/how-to-determine-if-point-is-inside.html
	 */
	public boolean isInside(Point topLeft, Point bottomRight, Point p) {
		return topLeft.x < p.x && topLeft.y > p.y && bottomRight.x > p.x && bottomRight.y < p.y;
	}

	public static class Point {
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}

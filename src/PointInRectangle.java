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

	public static void main(String[] args) {
		PointInRectangle pir = new PointInRectangle();
		System.out.println(pir.isInside(new Point(10, 10), new Point(20, 0), new Point(15, 5)));
		System.out.println(pir.isInside(new Point(10, 10), new Point(20, 0), new Point(15, 15)));
	}
}

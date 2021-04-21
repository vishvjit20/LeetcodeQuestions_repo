import java.util.PriorityQueue;

class Point {
	int x, y, distance;
	Point(int x, int y) {
		this.x = x;
		this.y = y;
		distance = x * x + y * y;
	}
	public int[] toArray() {
		return new int[] {x, y};
	}
}

public class KClosestPointsToOrigin {
	public static int[][] kClosest(int[][] points, int K) {
		PriorityQueue<Point> pq = new PriorityQueue<>((Point a, Point b) -> a.distance - b.distance);
		for (int i = 0; i < points.length; i++) {
			pq.offer(new Point(points[i][0], points[i][1]));
		}
		int result[][] = new int[K][2];
		for (int i = 0; i < K; i++) {
			result[i] = pq.poll().toArray();
		}
		return result;
	}
	public static void main(String args[]) {
		int points[][] = {
							{1, 3},
							{-2, 2}
						 };
		int k = 1;
		int res[][] = kClosest(points, k);
		for (int i = 0; i < res.length; i++) {
			System.out.println(res[i][0] + " " + res[i][1]);
		}
	}
}


public class KnightProbability {
	public static int[][] dirs = new int[][] {
		{-2, -1}, 
		{-1, -2}, 
		{1, -2}, 
		{2, -1}, 
		{2, 1}, 
		{1, 2}, 
		{-1, 2}, 
		{-2, 1}
	};
	public static double knightProbability(int n, int k, int r, int c) {
		return find(n, k, r, c);
	}
	public static double find(int n, int k, int r, int c) {
		if (r < 0 || c < 0 || r >= n || c >= n) return 0;
		if (k == 0) return 1;
		double rate = 0;
		for (int i = 0; i < dirs.length; i++) {
			rate += 0.125 * find(n, k - 1, r + dirs[i][0], c + dirs[i][1]);
		}
		return rate;
	}
	public static void main(String args[]) {
		int n = 3, k = 2, r = 0, c = 0;
		System.out.println(knightProbability(n, k, r, c));
	}
}

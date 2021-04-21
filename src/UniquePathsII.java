
public class UniquePathsII {
	public static int uniquePathsWithObstacles(int[][] grid) {
		int n = grid.length;
		int m = grid[0].length;
		
		if (grid[0][0] == 1) 
			return 0;
		int dp[][] = new int[n][m];
		
		for (int i = 0; i < n; i++) {
			if (grid[i][0] == 0)
				dp[i][0] = 1;
			else break;
		}
		
		for (int j = 0; j < m; j++) {
			if (grid[0][j] == 0)
				dp[0][j] = 1;
			else break;
		}
		
		for (int i = 1; i < n; i++) {
			for (int j = 1; j < m; j++) {
				if (grid[i][j] == 1) dp[i][j] = 0;
				else dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
			}
		}
		return dp[n - 1][m - 1];
	}
	public static void main(String args[]) {
		int grid[][] = {
				{0,0,0}, 
				{0,1,0}, 
				{0,0,0}
		};
		System.out.println(uniquePathsWithObstacles(grid));
	}
}

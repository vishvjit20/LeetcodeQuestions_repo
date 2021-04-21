
public class LongestIncreasingPathInAMatrix {
	public static int longestIncreasingPath(int[][] matrix) {
		if (matrix.length == 0) 
			return 0;
		int max = 0;
		int n = matrix.length;
		int m = matrix[0].length;
		
		int cache[][] = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				max = Math.max(max, dfs(matrix, Integer.MIN_VALUE, i, j, cache));
			}
		}
		return max;
	}
	public static int dfs(int[][] matrix, int min, int i, int j, int cache[][]) {
		if (i < 0 || j < 0 || i == matrix.length || j == matrix[0].length)
			return 0;
		if (matrix[i][j] <= min) return 0;
		
		min = matrix[i][j];
		if (cache[i][j] != 0)
			return cache[i][j];

		int a = dfs(matrix, min, i - 1, j, cache) + 1;
		int b = dfs(matrix, min, i + 1, j, cache) + 1;
		int c = dfs(matrix, min, i, j - 1, cache) + 1;
		int d = dfs(matrix, min, i, j + 1, cache) + 1;
		
		int max = Math.max(a, Math.max(b, Math.max(c, d)));
		cache[i][j] = max;
		return max;
	}
	
	public static void main(String args[]) {
		int mat[][] = {
					   {  0,  1,  2,  3,  4,  5,  6,  7,  8,  9},
		               { 19, 18, 17, 16, 15, 14, 13, 12, 11, 10},
		               { 20, 21, 22, 23, 24, 25, 26, 27, 28, 29},
		               { 39, 38, 37, 36, 35, 34, 33, 32, 31, 30},
		               { 40, 41, 42, 43, 44, 45, 46, 47, 48, 49},
		               { 59, 58, 57, 56, 55, 54, 53, 52, 51, 50},
		               { 60, 61, 62, 63, 64, 65, 66, 67, 68, 69},
		               { 79, 78, 77, 76, 75, 74, 73, 72, 71, 70},
		               { 80, 81, 82, 83, 84, 85, 86, 87, 88, 89},
		               { 99, 98, 97, 96, 95, 94, 93, 92, 91, 90},
		               {100,101,102,103,104,105,106,107,108,109},
		               {119,118,117,116,115,114,113,112,111,110},
		               {120,121,122,123,124,125,126,127,128,129},
		               {139,138,137,136,135,134,133,132,131,130},
		               {  0,  0,  0,  0,  0,  0,  0,  0,  0,  0}
		          };
		int res = longestIncreasingPath(mat);
		System.out.println(res);
	}
}

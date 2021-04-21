
public class NumberOfIslands {
	public static int numIslands(char nums[][]) {
		if (nums.length == 0)
			return 0;
		int cnt = 0; 
		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < nums[0].length; j++) {
				if (nums[i][j] == '1') {
					cnt++;
					countIslands(nums, i, j);
				}
			}
		}
		return cnt;
	}
	public static void countIslands(char[][] grid, int i, int j) {
		if (i < 0 || i == grid.length || j < 0 || j == grid[0].length || grid[i][j] == '0')
			return;
		
		grid[i][j] = '0';
		countIslands(grid, i + 1, j);
		countIslands(grid, i - 1, j);
		countIslands(grid, i, j + 1);
		countIslands(grid, i, j - 1);
	}
	
	public static void main(String args[]) {
		char grid[][] = {
				 			{'1','1','0','0','0'},
				 			{'1','1','0','0','0'},
				 			{'0','0','1','0','0'},
				 			{'0','0','0','1','1'}
	                    };
		
		System.out.println(numIslands(grid));
	}
}

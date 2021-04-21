// You are given an m x n grid where each cell can have one of three values:

// 0 representing an empty cell,
// 1 representing a fresh orange, or
// 2 representing a rotten orange.
// Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.

// Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is // impossible, return -1.



import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {
	public static int orangesRotting(int[][] grid) {
		Queue<int[]> q = new LinkedList<>();
		int fresh_count = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 2) {
					q.offer(new int[] {i, j});
				}
				else if (grid[i][j] == 1) {
					fresh_count++;
				}
			}
		}
		if (fresh_count == 0) return 0;
		int count = 0;
		int dirs[][] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
		while(!q.isEmpty()) {
			count++;
			int size = q.size();
			while (size-- > 0) {
				int point[] = q.poll();
				for (int dir[] : dirs) {
					int x = point[0] + dir[0];
					int y = point[1] + dir[1];
					if (x < 0 || x == grid.length || y < 0 || y == grid[0].length || grid[x][y] == 0 						 						  || grid[x][y] == 2) continue;
					grid[x][y] = 2;
					q.offer(new int[] {x, y});
					fresh_count--;
				}
			}
		}
		return fresh_count == 0 ? count - 1 : -1;
	}
	public static void main(String args[]) {
		int [][]grid = {
							{2, 1, 1},
							{1, 1, 0},
							{0, 1, 1}
						};
		int res = orangesRotting(grid);
		System.out.println(res);
	}
}

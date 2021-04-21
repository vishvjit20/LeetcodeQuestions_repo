import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathInBinaryMatrix {
	public static int directions[][]  = new int[][]{
		{0, 1}, 
		{1, 1}, 
		{1, 0}, 
		{-1, 1},
		{-1, 0}, 
		{-1, -1}, 
		{0, -1}, 
		{1, -1}
	};
	public static int shortestPathBinaryMatrix(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;
		if (grid[0][0] == 1 || grid[m - 1][n - 1] == 1)
			return -1;
		
		int ans = 0;
		boolean[][] visited = new boolean[m][n];
		visited[0][0] = true;
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {0, 0});
		while (!q.isEmpty()) {
			int size = q.size();
			while (size-- > 0) {
				int pop[] = q.remove();
				if (pop[0] == m - 1 && pop[1] == n - 1) 
				{
					return ans + 1;
				}
				for (int i = 0; i < 8; i++) {
					int nextX = directions[i][0] + pop[0];
					int nextY = directions[i][1] + pop[1];
					
					if (nextX >= 0 && nextX < m && nextY >= 0 && nextY < n && !visited[nextX][nextY] && grid[nextX][nextY] == 0) {
						q.add(new int[] {nextX, nextY});
						visited[nextX][nextY] = true;
					}
				}
			}
			ans++;
		}
		return -1;
 	}
	public static void main(String args[]) {
		int[][] grid = {
							{0, 0, 0},
							{1, 1, 0},
							{1, 1, 0}
						};
		int res = shortestPathBinaryMatrix(grid);
		System.out.println(res);
	}
}

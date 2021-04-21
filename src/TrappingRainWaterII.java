import java.util.PriorityQueue;

class Cell implements Comparable<Cell> {
	int row, col, val;
	public Cell(int row, int col, int val) {
		this.row = row;
		this.col = col;
		this.val = val;
	}
	public int compareTo(Cell other) {
		return this.val - other.val;
	}
}
public class TrappingRainWaterII {
	private static int water;
	private static boolean visited[][];
	public static int trapRainWater(int heights[][]) {
		PriorityQueue<Cell> walls = new PriorityQueue<>();
		water = 0;
		visited = new boolean[heights.length][heights[0].length];
		int rows = heights.length;
		int cols = heights[0].length;
		for (int c = 0; c < cols; c++) {
			walls.add(new Cell(0, c, heights[0][c]));
			walls.add(new Cell(rows - 1, c, heights[rows - 1][c]));
			visited[0][c] = true;
			visited[rows - 1][c] = true;
		}
		for (int r = 1; r < rows - 1; r++) {
			walls.add(new Cell(r, 0, heights[r][0]));
			walls.add(new Cell(r, cols - 1, heights[r][cols - 1]));
			visited[r][0] = true;
			visited[r][cols - 1] = true;
		}
		while(walls.size() > 0) {
			Cell min = walls.poll();
			visit(heights, min, walls);
		}
		return water;
	}
	
	public static void visit(int[][] heights, Cell start, PriorityQueue<Cell> walls) {
		fill(heights, start.row + 1, start.col, walls, start.val);
		fill(heights, start.row - 1, start.col, walls, start.val);
		fill(heights, start.row, start.col + 1, walls, start.val);
		fill(heights, start.row, start.col - 1, walls, start.val);
	}
	
	public static void fill(int height[][], int row, int col, PriorityQueue<Cell> walls, int min) {
		if (row < 0 || row == height.length || col < 0 || col == height[0].length || visited[row][col]) 			
			return;
		else if (height[row][col] >= min) {
			walls.add(new Cell(row, col, height[row][col]));
			visited[row][col] = true;
			return;
		}
		else {
			water += min - height[row][col];
			visited[row][col] = true;
			fill(height, row + 1, col, walls, min);
			fill(height, row - 1, col, walls, min);
			fill(height, row, col + 1, walls, min);
			fill(height, row, col - 1, walls, min);
		}
	}
	public static void main(String args[]) {
		int grid[][] = {
							{12,13,1,12},
							{13,4,13,12},
							{13,8,10,12},
							{12,13,12,12},
							{13,13,13,13}
						};
		int res = trapRainWater(grid);
		System.out.println(res);
	}
}

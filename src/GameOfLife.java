
/**
 * Any live cell with less than two live neighbors dies as if caused by under-population.
 * Any live cell with two or three live neighbors lives on to the next generation.
 * Any live cell with more than three live neighbors dies, as if by over-population.
 * Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
 * */


public class GameOfLife {
//	public static void gameOfLife(int[][] board) {
//		int neighbors[] = {0, -1, 1};
//		int rows = board.length;
//		int cols = board[0].length;
//		
//		int[][] copyBoard = new int[rows][cols];
//		for (int i = 0; i < rows; i++)
//			for (int j = 0; j < cols; j++)
//				copyBoard[i][j] = board[i][j];
//		
//		// Iterate through board cell by cell
//		for (int row = 0; row < rows; row++) {
//			for (int col = 0; col < cols; col++) {
//				int liveNeighbors = 0;
//				for (int i = 0; i < 3; i++) {
//					for (int j = 0; j < 3; j++) {
//						if (!(neighbors[i] == 0 && neighbors[j] == 0)) {
//							int r = row + neighbors[i];
//							int c = col + neighbors[j];
//							if (r < rows && r >= 0 && c < cols && c >= 0 && copyBoard[r][c] == 1) {
//								liveNeighbors++;
//							}
//						}
//					}
//				}
//				if (copyBoard[row][col] == 1 && (liveNeighbors < 2 || liveNeighbors > 3)) {
//					board[row][col] = 0;
//				}
//				if (copyBoard[row][col] == 0 && (liveNeighbors == 3)) board[row][col] = 1;
//			}
//		}
//	}
	
	public static void gameOfLife(int board[][]) {
		int []neighbors = {0, 1, -1};
		int rows = board.length;
		int cols = board[0].length;
		
		for (int row = 0; row < rows; row++) {
			for (int col = 0; col < cols; col++) {
				int liveNeighbors = 0;
				for (int i = 0; i < 3; i++) {
					for (int j = 0; j < 3; j++) {
						if (!(neighbors[i] == 0 && neighbors[j] == 0)) {
							int r = row + neighbors[i];
							int c = col + neighbors[j];
							
							if (r >= 0 && r < rows && c >= 0 && c < cols && Math.abs(board[r][c]) == 1)
								liveNeighbors++;
						}
					}
				}
				if (board[row][col] == 1 && (liveNeighbors < 2 || liveNeighbors > 3))
					board[row][col] = -1;
				if (board[row][col] == 0 && liveNeighbors == 3) board[row][col] = 2;
			}
		}
		for (int row = 0; row < rows; row++) {
			for (int col = 0; col < cols; col++) {
				if (board[row][col] > 0) 
					board[row][col] = 1;
				else board[row][col] = 0;
			}
		}
	}
	
	
	public static void main(String[] args) {
		int[][] board = {{0,1,0},{0,0,1},{1,1,1},{0,0,0}};
		gameOfLife(board);
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}
}

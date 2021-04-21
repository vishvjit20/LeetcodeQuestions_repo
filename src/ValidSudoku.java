import java.util.HashMap;

public class ValidSudoku {
	public static boolean isValidSudoku(char[][] board) {
		@SuppressWarnings("unchecked")
		HashMap<Integer, Integer>[] rows = new HashMap[9];
		@SuppressWarnings("unchecked")
		HashMap<Integer, Integer>[] cols = new HashMap[9];
		@SuppressWarnings("unchecked")
		HashMap<Integer, Integer>[] boxes = new HashMap[9];
		
		for (int i = 0; i < 9; i++) {
			rows[i] = new HashMap<>();
			cols[i] = new HashMap<>();
			boxes[i] = new HashMap<>();
		}
		
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				char num = board[i][j];
				if (num != '.') {
					int n = (int)num;
					int box_idx = (i / 3) * 3 + j / 3;
					
					rows[i].put(n, rows[i].getOrDefault(n, 0) + 1);
					cols[j].put(n, cols[j].getOrDefault(n, 0) + 1);
					boxes[box_idx].put(n, boxes[box_idx].getOrDefault(n, 0) + 1);
					if (rows[i].get(n) > 1 || cols[j].get(n) > 1 || boxes[box_idx].get(n) > 1) {
						return false;
					}
				}
			}
		}
		return true;
	}
	public static void main(String args[]) {
		char[][] board = {
							{'5', '3', '.', '.', '7', '.', '.', '.', '.'},
							{'6', '.', '.', '1', '9', '5', '.', '.', '.'},
							{'.', '9', '8', '.', '.', '.', '.', '6', '.'},
							{'8', '.', '.', '.', '6', '.', '.', '.', '3'},
							{'4', '.', '.', '8', '.', '3', '.', '.', '1'},
							{'7', '.', '.', '.', '2', '.', '.', '.', '6'},
							{'.', '6', '.', '.', '.', '.', '2', '8', '.'},
							{'.', '.', '.', '4', '1', '9', '.', '.', '5'},
							{'.', '.', '.', '.', '8', '.', '.', '7', '9'}
		};
		
		System.out.println(isValidSudoku(board));
	}
}

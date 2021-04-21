
public class WordSearch {
	public static boolean exist(char[][] board, String word) {
		if (board.length == 0)
			return false;
		for (int i = 0; i < board.length; i++) 
			for (int j = 0; j < board[0].length; j++) 
				if (board[i][j] == word.charAt(0) && dfs(board, word, i, j, 0))
					return true;
		return false;
	}
	public static boolean dfs(char[][] board, String word, int i, int j, int c) {
		if (c == word.length())
			return true;
		if (i < 0 || i == board.length || j < 0 || j == board[0].length || board[i][j] != word.charAt(c))
			return false;
		char temp = board[i][j];
		board[i][j] = 'x';
		boolean res = dfs(board, word, i + 1, j, c + 1) ||
				  dfs(board, word, i - 1, j, c + 1) ||
				  dfs(board, word, i, j + 1, c + 1) ||
				  dfs(board, word, i, j - 1, c + 1);
		board[i][j] = temp;
		return res;
	}
	public static void main(String args[]) {
		char board[][] = {  
							{'A','B','C','E'},
							{'S','F','C','S'},
							{'A','D','E','E'}
						};
		String word = "SEED";
		System.out.println(exist(board, word));
	}
}

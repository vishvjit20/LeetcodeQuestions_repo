import java.util.LinkedList;
import java.util.Queue;

public class SnakesAndLadders {
	public static int snakesAndLadder(int[][] board) {
		int n = board.length;
		int arr[] = new int[n* n];
		int i = n - 1, j = 0, inc = 1, idx = 0;
		while (idx < n * n) {
			arr[idx++] = board[i][j];
			if (inc == 1 && j == n - 1) {
				inc = -1;
				i--;
			}
			else if (inc == -1 && j == 0) {
				inc = 1;
				i--;
			}
			else j += inc;
		}
		boolean[] visited = new boolean[n* n];
		Queue<Integer> q = new LinkedList<>();
		int start = arr[0] > -1 ? arr[0] - 1 : 0;
		int steps = 0;
		q.offer(start);
		visited[start] = true;
		while (!q.isEmpty()) {
			int size = q.size();
			while (size-- > 0) {
				int curr = q.poll();
				if (curr == n * n - 1) {
					return steps;
				}
				for (int next = curr + 1; next <= Math.min(curr + 6, n * n - 1); next++) {
					int dest = arr[next] > -1 ? arr[next] - 1 : next;
					if (!visited[dest]) {
						visited[dest] = true;
						q.offer(dest);
					}
				}
			}
			steps++;
		}
		return -1;
	}
	public static void main(String args[]) {
		int board[][] = {
							{-1,-1,-1,-1,-1,-1}, 
							{-1,-1,-1,-1,-1,-1}, 
							{-1,-1,-1,-1,-1,-1}, 
							{-1,35,-1,-1,13,-1}, 
							{-1,-1,-1,-1,-1,-1}, 
							{-1,15,-1,-1,-1,-1}
						};
		System.out.println(snakesAndLadder(board));
	}
}

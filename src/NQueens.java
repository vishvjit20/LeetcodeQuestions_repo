import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens {
	public static List<List<String>> solveNQueens(int n) {
		List<List<String>> result = new ArrayList<>();
		boolean[] cols = new boolean[n];
		boolean[] ndiag = new boolean[2 * n - 1];
		boolean[] rdiag = new boolean[2 * n - 1];
		solve(0, cols, ndiag, rdiag, result, new ArrayList<>(), n);
		return result;
	}
	public static void solve(int rowIdx, boolean[] cols, boolean[] ndiag, boolean[] rdiag, List<List<String>> res, List<String> list, int n) {
		if (rowIdx == n) {
			res.add(new ArrayList<>(list));
			return;
		}
		char[] row = new char[n];
		Arrays.fill(row, '.');
		for (int colIdx = 0; colIdx < n; colIdx++) {
			if (!cols[colIdx] && !ndiag[rowIdx + colIdx] && !rdiag[rowIdx - colIdx + n - 1]) {
				row[colIdx] = 'Q';
				list.add(new String(row));
				ndiag[rowIdx + colIdx] = true;
				rdiag[rowIdx - colIdx + n - 1] = true;
				cols[colIdx] = true;
				solve(rowIdx + 1, cols, ndiag, rdiag, res, list, n);
				cols[colIdx] = false;
				rdiag[rowIdx - colIdx + n - 1] = false;
				ndiag[rowIdx + colIdx] = false;
				list.remove(list.size() - 1);
				row[colIdx] = '.';
			}
		}
	}
	public static void main(String args[]) {
		List<List<String>> ls = solveNQueens(4);
		System.out.println(ls);
	}
}

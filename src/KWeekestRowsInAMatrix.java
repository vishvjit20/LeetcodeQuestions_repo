
public class KWeekestRowsInAMatrix {
	public static int[] kWeekestRows(int[][] mat, int k) {
		int res[] = new int[k];
		int count[] = new int[mat.length];
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				if (mat[i][j] == 1) {
					count[i]++;
				}
			}
		}
		int idx = 0;
		while (k-- > 0) {
			int minIdx = 0;
			for (int i = 0; i < mat.length; i++) {
				if (count[i] < count[minIdx]) {
					minIdx = i;
				}
			}
			res[idx++] = minIdx;
			count[minIdx] = Integer.MAX_VALUE;
		}
		return res;
	}
	public static void main(String args[]) {
		int mat[][] = {
						 {1, 1, 0, 0, 0},
						 {1, 1, 1, 1, 0},
						 {1, 0, 0, 0, 0},
						 {1, 1, 0, 0, 0},
						 {1, 1, 1, 1, 1}
					   };
		int k = 3;
		int[] res = kWeekestRows(mat, k);
		for (int x : res) System.out.print(x + " ");
	}
}

import java.util.HashMap;

public class FourSumII {
	public static int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
		HashMap<Integer, Integer> map = new HashMap<>();
		int cnt = 0;
		for (int i = 0 ; i < A.length; i++) {
			for (int j = 0; j < B.length; j++) {
				int sum = A[i] + B[j];
				map.put(sum, map.getOrDefault(sum, 0) + 1);
			}
		}
		for (int i = 0; i < C.length; i++) {
			for (int j = 0; j < D.length; j++) {
				int sum = -(C[i] + D[j]);
				if (map.containsKey(sum))
					cnt += map.get(sum);
			}
		}
		return cnt;
	}
	public static void main(String args[]) {
		int[] A = {1, 2}, B = {-2, -1}, C = {-1, 2}, D = {0, 2};
		int res = fourSumCount(A, B, C, D);
		System.out.println(res);
	}
}

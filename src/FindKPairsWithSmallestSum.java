import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class FindKPairsWithSmallestSum {
	public static List<List<Integer>> kSmallestPairs(int[] n1, int[] n2, int k) {
		List<List<Integer>> res = new ArrayList<>();
		if (n1.length == 0 || n2.length == 0 || k == 0)
			return res;
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] + a[1] - b[0] - b[1]);
		for (int i = 0; i < n1.length && i < k; i++) {
			pq.add(new int[] {n1[i], n2[0], 0});
		}
		while (k-- > 0 && !pq.isEmpty()) {
			List<Integer> list = new ArrayList<>();
			int[] curr = pq.poll();
			list.add(curr[0]);
			list.add(curr[1]);
			res.add(list);
			if (curr[2] == n2.length - 1) 
				continue;
			pq.add(new int[] {curr[0], n2[curr[2] + 1], curr[2] + 1});
		}
		return res;
	}
	public static void main(String args[]) {
		int[] n1 = {1, 1, 2};
		int[] n2 = {1, 2, 3};
		int k = 4;
		System.out.println(kSmallestPairs(n1, n2, k));
	}
}

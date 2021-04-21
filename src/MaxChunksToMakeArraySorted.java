import java.util.ArrayList;
import java.util.List;

public class MaxChunksToMakeArraySorted {
	public static List<List<Integer>> maxChunksToSorted(int[] arr) {
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> list = new ArrayList<>();
		int max = 0;
		for (int i = 0; i < arr.length; i++) {
			list.add(arr[i]);
			max = Math.max(max, arr[i]);
			if (max == i) {
				res.add(list);
				list = new ArrayList<>();
			}
		}
		return res;
	}
	public static void main(String args[]) {
		int nums[] = {0, 2, 1, 4, 3, 5, 7, 6};
		System.out.println(maxChunksToSorted(nums));
	}
}

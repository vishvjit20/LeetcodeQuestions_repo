import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class IncreasingSubsequence {
	public static List<List<Integer>> findSubsequences(int[] nums) {
		Set<List<Integer>> res = new HashSet<List<Integer>>();
		List<Integer> list = new ArrayList<>();
		allSeqHelper(nums, 0, res, list);
		List<List<Integer>> result = new ArrayList<>(res);
		return result;
	}
	public static void allSeqHelper(int[] nums, int idx, Set<List<Integer>> res, List<Integer> list) {
		if (list.size() >= 2) {
			res.add(new ArrayList<>(list));
		} 
		for (int i = idx; i < nums.length; i++) {
			if (list.size() == 0 || list.get(list.size() - 1) <= nums[i]) {
				list.add(nums[i]);
				allSeqHelper(nums, i + 1, res, list);
				list.remove(list.size() - 1);
			}
		}
	}
	public static void main(String args[]) {
		int nums[] = {4, 3, 6, 7, 5, 7};
		List<List<Integer>> res = findSubsequences(nums);
		System.out.println(res);
	}
}

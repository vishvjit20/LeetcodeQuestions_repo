import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
	public static List<List<Integer>> combinationSum(int nums[], int target) {
		List<List<Integer>> res = new ArrayList<>();
		solve(nums, 0, target, res, new ArrayList<>());
		return res;
	}
	public static void solve(int nums[], int start, int target, List<List<Integer>> res, List<Integer> list) {
		if (target < 0) return;
		if (target == 0) {
			res.add(new ArrayList<>(list));
			return;
		}
		for (int i = start; i < nums.length; i++) {
			list.add(nums[i]);
			solve(nums, i, target - nums[i], res, list);
			list.remove(list.size() - 1);
		}
	}
	public static void main(String args[]) {
		int nums[] = {3, 6, 7, 8, 9, 15, 11, 13, 18, 23, 19};
		int target = 20;
		List<List<Integer>> res = combinationSum(nums, target);
		System.out.println(res);
	}
}

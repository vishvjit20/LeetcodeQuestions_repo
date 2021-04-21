import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {
	public static List<List<Integer>> combinationSum2(int nums[], int target) {
		List<List<Integer>> res = new ArrayList<>();
		Arrays.sort(nums);
		solve(nums, 0, target, res, new ArrayList<>(), new boolean[nums.length]);
		return res;
	}
	public static void solve(int nums[], int idx, int target, List<List<Integer>> res, List<Integer> list, boolean []visited) {
		if (target < 0) return;
		if (target == 0) {
			res.add(new ArrayList<>(list));
			return;
		}
		for (int i = idx; i < nums.length; i++) {
			if (visited[i]) continue;
			if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) continue;
			visited[i] = true;
			list.add(nums[i]);
			solve(nums, i + 1, target - nums[i], res, list, visited);
			visited[i] = false;
			list.remove(list.size() - 1);
		}
	}
	public static void main(String[] args) {
		int nums[] = {10,1,2,7,6,1,5};
		int target = 8;
		List<List<Integer>> res = combinationSum2(nums, target);
		System.out.println(res);
	}

}

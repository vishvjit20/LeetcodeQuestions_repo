import java.util.ArrayList;
import java.util.List;

public class Subsets {
	public static List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		generateSubsets(0, nums, res, new ArrayList<>());
		return res;
	}
	public static void generateSubsets(int idx, int[] nums, List<List<Integer>> res, List<Integer> list) {
		res.add(new ArrayList<>(list));
		for (int i = idx; i < nums.length; i++) {
			list.add(nums[i]);
			generateSubsets(i + 1, nums, res, list);
			list.remove(list.size() - 1);
		}
	}
	public static void main(String args[]) {
		int nums[] = {1, 2, 3, 4};
		List<List<Integer>> res = subsets(nums);
		for (List<Integer> r : res) System.out.println(r);
	}
}

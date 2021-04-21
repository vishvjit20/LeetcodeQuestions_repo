import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII {
	public static List<List<Integer>> subsetsWithDup(int[] nums) {
		List<List<Integer>> list = new ArrayList<>();
		Arrays.sort(nums);
		generateSubsets(0, list, new ArrayList<>(), nums);
		return list;
	}
	public static void generateSubsets(int idx, List<List<Integer>> res, List<Integer> list, int nums[]) {
		res.add(new ArrayList<>(list));
		for (int i = idx; i < nums.length; i++) {
			if (i > idx && nums[i] == nums[i - 1]) continue;
			list.add(nums[i]);
			generateSubsets(i + 1, res, list, nums);
			list.remove(list.size() - 1);
		}
	}
	public static void main(String args[]) {
		int nums[] = {1, 2, 2, 4, 5};
		List<List<Integer>> list = subsetsWithDup(nums);
		for (List<Integer> ls : list) System.out.println(ls); 
	}
}

import java.util.ArrayList;
import java.util.List;

public class AllTheDuplicatesInArray {
	public static List<Integer> findDuplicates(int[] nums) {
		List<Integer> res = new ArrayList<>();
		for (int i = 0; i < nums.length; i++) {
			int idx = Math.abs(nums[i]) - 1;
			if (nums[idx] < 0) res.add(Math.abs(idx + 1));
			nums[idx] = -nums[idx];
		}
		return res;
	}
	public static void main(String args[]) {
		int nums[] = {4,3,2,7,8,2,3,1};
		System.out.println(findDuplicates(nums));
	}
}

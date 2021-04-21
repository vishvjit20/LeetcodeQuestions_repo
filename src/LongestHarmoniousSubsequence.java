import java.util.HashMap;
import java.util.Map;

public class LongestHarmoniousSubsequence {
	public static int findLHS(int []nums) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int n : nums) {
			map.put(n, map.getOrDefault(n, 0) + 1);
		}
		int maxLen = 0;
		for (Map.Entry<Integer, Integer> e : map.entrySet()) {
			int key = e.getKey();
			int val = e.getValue();
			if (map.get(key + 1) != null) {
				maxLen = Math.max(maxLen, map.get(key + 1) + val);
			}
			if (map.get(key - 1) != null) {
				maxLen = Math.max(maxLen, map.get(key - 1) + val);
			}
		}
		return maxLen;
	}
	public static void main(String args[]) {
		int nums[] = {1,3,2,2,5,2,3,7};
		int res = findLHS(nums);
		System.out.println(res);
	}
}

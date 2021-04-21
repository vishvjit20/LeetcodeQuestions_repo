import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SortArrayByIncFreq {
	public static int[] frequencySort(int[] nums) {
		Map<Integer, Integer> map = new HashMap<>();
		
		for (int n : nums) 
			map.put(n, map.getOrDefault(n, 0) + 1);
		
		List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
		Collections.sort(list, (a, b) -> {
			if (a.getValue() == b.getValue()) {
				return b.getKey() - a.getKey();
			}
			return a.getValue() - b.getValue();
		});
		
		int idx = 0;
		int res[] = new int[nums.length];
		for (Map.Entry<Integer, Integer> entry : list) {
			int count = entry.getValue();
			int key = entry.getKey();
			for (int i = 0; i < count; i++) 
				res[idx++] = key;
		}
		return res;
	}
	public static void main(String args[]) {
		int nums[] = {1,1,2,2,2,3};
		int res[] = frequencySort(nums);
		for (int r : res) System.out.print(r + " ");
	}
}

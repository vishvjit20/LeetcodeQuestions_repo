import java.util.HashMap;
import java.util.Stack;

public class NextGreaterElementI {
	public static int[] nextGreaterElement(int[] findNums, int[] nums) {
		HashMap<Integer, Integer> map = new HashMap<>();
		Stack<Integer> stk = new Stack<>();
		for (int n : nums) {
			while (!stk.isEmpty() && stk.peek() < n) 
				map.put(stk.pop(), n);
			stk.push(n);
		}
		
		for (int i = 0; i < findNums.length; i++) {
			findNums[i] = map.getOrDefault(findNums[i], -1);
		}
		return findNums;
	}
	public static void main(String args[]) {
		int[] findNums = {4, 1, 2};
		int[] nums = {1, 3, 4, 2};
		int[] res = nextGreaterElement(findNums, nums);
		for (int r : res) System.out.print(r + " ");
	}
}

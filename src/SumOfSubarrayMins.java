import java.util.ArrayDeque;

class Pair {
	int element;
	int numMin;
	Pair(int element, int numMin) {
		this.element = element;
		this.numMin = numMin;
	}
}

public class SumOfSubarrayMins {
	public static int sumSubarrayMins(int arr[]) {
		int[] left = new int[arr.length];
		int right[] = new int[arr.length];
		
		ArrayDeque<Pair> stk1 = new ArrayDeque<>();
		ArrayDeque<Pair> stk2 = new ArrayDeque<>();
		
		for (int i = 0; i < arr.length; i++) {
			int curr_ele = arr[i];
			int cnt = 1;
			while (!stk1.isEmpty() && stk1.peek().element > curr_ele) {
				cnt += stk1.peek().numMin;
				stk1.pop();
			}
			stk1.push(new Pair(curr_ele, cnt));
			left[i] = cnt;
		}
		
		for (int i = arr.length - 1; i >= 0; i--) {
			int curr_ele = arr[i];
			int cnt = 1;
			while (!stk2.isEmpty() && stk2.peek().element >= curr_ele) {
				cnt += stk2.peek().numMin;
				stk2.pop();
			}
			stk2.push(new Pair(curr_ele, cnt));
			right[i] = cnt;
		}
		
		long ans = 0;
		int M = (int)Math.pow(10, 9) + 7;
		for (int i = 0; i < arr.length; i++) {
			ans = (ans + (long)left[i] * right[i] * arr[i]) % M;
		}
		return (int)ans;
	}
	public static void main(String args[]) {
		int arr[] = {11,81,94,43,3};
		int res = sumSubarrayMins(arr);
		System.out.println(res);
	}
}

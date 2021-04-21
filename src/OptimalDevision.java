
public class OptimalDevision {
	public static String optimalDevision(int nums[]) {
		int n = nums.length;
		StringBuilder expr = new StringBuilder();
		for (int i = 0; i < n; i++) {
			if (i > 0) expr.append("/");
			if (i == 1 && n > 2) expr.append("(");
			expr.append(nums[i]);
			if (i == n - 1 && n > 2) expr.append(")");
		}
		return expr.toString();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {10000, 10000, 10, 2};
		System.out.println(optimalDevision(arr));
	}
}

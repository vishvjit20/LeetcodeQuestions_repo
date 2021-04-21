
public class MaximumScorePerformingMultiplication {
	public static int maximumScore(int[] nums, int[] multipliers) {
		int m = multipliers.length;
		return solve(nums, multipliers, 0, 0, new Integer[m + 1][m + 1]);
	}
	public static int solve(int[] nums, int[] multipliers, int start, int idx, Integer[][] dp) {
		if (idx == multipliers.length) 
			return 0;
		
		int end = nums.length - 1 - (idx - start);
		
		if (dp[start][idx] != null)
			return dp[start][idx];
		
		int val1 = nums[start] * multipliers[idx] + solve(nums, multipliers, start + 1, idx + 1, dp);
		int val2 = nums[end] * multipliers[idx]+ solve(nums, multipliers, start, idx + 1, dp);
		
		dp[start][idx] = Math.max(val1, val2);
		return dp[start][idx];
	}
	public static void main(String args[]) {
		int nums[] = {1, 2, 3};
		int multipliers[] = {3, 2, 1};
		int res = maximumScore(nums, multipliers);
		System.out.println(res);
	}
}

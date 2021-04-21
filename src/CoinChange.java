
public class CoinChange {
	public static int coinChange(int[] coins, int amount) {
		int dp[][] = new int[coins.length + 1][amount + 1];
		
		for (int i = 0; i < dp[0].length; i++) {
			dp[0][i] = Integer.MAX_VALUE - 1;
		}
		
		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[0].length; j++) {
				if (coins[i - 1] <= j) {
					dp[i][j] = Math.min(dp[i - 1][j], 1 + dp[i][j - coins[i - 1]]);
				}
				else dp[i][j] = dp[i - 1][j];
			}
		}
		return dp[coins.length][amount] == Integer.MAX_VALUE - 1 ? -1 : dp[coins.length][amount];
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int coins[] = {1, 2, 5};
		int amount = 11;
		
		int res = coinChange(coins, amount);
		System.out.println(res);
	}
}


public class LongestPalindromicSubstring {
	public static String longestPalindrome(String s) {
		boolean dp[][] = new boolean[s.length()][s.length()];
		String res = "";
		for (int g = 0; g < s.length(); g++) {
			for (int i = 0, j = g; j < s.length(); j++) {
				if (g == 0) {
					dp[i][j] = true;
				}
				else if (g == 1) {
					if (s.charAt(i) == s.charAt(j)) {
						dp[i][j] = true;
					}
					else dp[i][j] = false;
				}
				else {
					if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1] == true) {
						dp[i][j] = true;
					}
					else dp[i][j] = false;
				}
				if (dp[i][j]) 
					res = s.substring(i, j + 1);
			}
		}
		return res;
	}
	
	public static void main(String args[]) {
		String s = "babad";
		System.out.println(longestPalindrome(s));
	}
}

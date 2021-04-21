import java.util.Arrays;

public class LongestSubstrWithAtleastKRepeatingChars {
	public static int longestSubstring(String s, int k) {
		if (s.length() == 0 || k > s.length())
			return 0;
		int freqMap[] = new int[26];
		int n = s.length();
		int res = 0;
		for (int start = 0; start < n; start++) {
			Arrays.fill(freqMap, 0);
			for (int end = start; end < s.length(); end++) {
				freqMap[s.charAt(end) - 'a']++;
				if (isValid(freqMap, k)) {
					res = Math.max(res, end - start + 1);
				}
			}
		}
		return res;
	}
	public static boolean isValid(int[] freqMap, int k) {
		int countLetters = 0;
		int countAtLeastK = 0;
		for (int freq : freqMap) {
			if (freq > 0) countLetters++;
			if (freq >= k) countAtLeastK++;
		}
		return countLetters == countAtLeastK;
	}
	public static void main(String args[]) {
		System.out.println(longestSubstring("ababbc", 2));
	}
}

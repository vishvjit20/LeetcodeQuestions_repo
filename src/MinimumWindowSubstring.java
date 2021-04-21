import java.util.HashMap;

public class MinimumWindowSubstring {
	public static String minWindow(String s, String t) {
		String ans = "";
		HashMap<Character, Integer> freqMap = new HashMap<>();
		for (int i = 0; i < t.length(); i++) {
			char c = t.charAt(i);
			freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
		}
		int i = -1;
		int j = -1;
		int cnt = 0;
		int desiredCnt = t.length();
		HashMap<Character, Integer> strMap = new HashMap<>();
		while (true) {
			// acquire
			boolean f1 = false;
			boolean f2 = false;
			while (i < s.length() - 1 && cnt < desiredCnt) {
				i++;
				char c = s.charAt(i);
				strMap.put(c, strMap.getOrDefault(c, 0) + 1);
				if (strMap.getOrDefault(c, 0) <= freqMap.getOrDefault(c, 0)) {
					cnt++;
				}
				f1 = true;
			}
			// release and collect
			while (j < i && cnt == desiredCnt) {
				String potentialAns = s.substring(j + 1, i + 1);
				if (ans.length() == 0 || potentialAns.length() < ans.length()) {
					ans = potentialAns;
				}
				j++;
				char c = s.charAt(j);
				if (strMap.get(c) == 1) {
					strMap.remove(c);
				}
				else strMap.put(c, strMap.get(c) - 1);
				if (strMap.getOrDefault(c, 0) < freqMap.getOrDefault(c, 0)) {
					cnt--;
				}
				f2 = true;
			}
			if (f1 == false && f2 == false) {
				break;
			}
		}
		return ans;
	}
	public static void main(String args[]) {
		String s = "ADOBECODEBANC";
		String t = "ABC";
		String res = minWindow(s, t);
		System.out.println(res);
	}
}

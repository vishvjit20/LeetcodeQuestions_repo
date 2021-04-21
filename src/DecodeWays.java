
public class DecodeWays {
	public static int numDecodings(String s) {
		if (s.length() == 0 || s == null)
			return 0;
		return helper(s, 0);
	}
	public static int helper(String s, int idx) {
		if (idx == s.length())
			return 1;
		if (idx > s.length())
			return 0;
		int d1 = 0, d2 = 0;
		String s1 = s.substring(idx, idx + 1);
		d1 = Integer.parseInt(s1);
		if (d1 != 0) {
			d1 = helper(s, idx + 1);
		}
		if (idx < s.length() - 1) {
			String s2 = s.substring(idx, idx + 2);
			d2 = Integer.parseInt(s2);
			if (d2 > 9 && d2 < 27) {
				d2 = helper(s, idx + 2);
			}
			else return d1;
		}
		return d1 + d2;
	}
	public static void main(String args[]) {
		String str = "2263";
		System.out.println(numDecodings(str));
	}
}

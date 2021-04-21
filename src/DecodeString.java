
public class DecodeString {
	public static int i = 0;
	public static String decodeString(String s) {
		StringBuilder res = new StringBuilder();
		
		while (i < s.length() && s.charAt(i) != ']') {
			if (Character.isDigit(s.charAt(i))) {
				int k = 0;
				while (Character.isDigit(s.charAt(i))) {
					k = k * 10 + (s.charAt(i++) - '0');
				}
				i++;
				String r = decodeString(s);
				while (k-- > 0) {
					res.append(r);
				}
				i++;
			}
			else res.append(s.charAt(i++));
		}
		return res.toString();
	}
	public static void main(String args[]) {
		String s = "3[a]2[bc]";
		String res = decodeString(s);
		System.out.println(res);
	}
}

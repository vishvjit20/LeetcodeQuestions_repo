
public class AddBinary {
	public static String addBinary(String a, String b) {
		int x = a.length();
		int y = b.length();
		boolean carry = false;
		StringBuilder sb = new StringBuilder();
		int longer = x > y ? x : y;
		for (int i = 1; i <= longer; i++) {
			char aVal = (x - i) < 0 ? '0' : a.charAt(x - i);
			char bVal = (y - i) < 0 ? '0' : b.charAt(y - i);
			if (aVal == '0' && bVal == '0') {
				if (carry) {
					sb.append('1');
					carry = false;
				}
				else sb.append('0');
			}
			else if (aVal == '1' && bVal == '1') {
				if (carry) {
					sb.append('1');
				}
				else {
					sb.append('0');
					carry = true;
				}
			}
			else {
				if (carry) sb.append('0');
				else sb.append('1');
			}
		}
		if (carry) sb.append('1');
		return sb.reverse().toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(addBinary("100", "1010"));
	}

}

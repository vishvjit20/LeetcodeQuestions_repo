
public class RemoveOuterMostParenthesis {
	public static String removeOuterParentheses(String s) {
		int open = 0, close = 0, start = 0;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '(') open++;
			else if (c == ')') close++;
			if (open == close) {
				sb.append(s.substring(start+1, i));
				start = i + 1;
			}
		}
		return sb.toString();
	}
	public static void main(String args[]) {
		String str = "(()())(())";
		System.out.println(removeOuterParentheses(str));
	}
}

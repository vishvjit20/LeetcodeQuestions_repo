
public class RemoveAllAdjacentDuplicates2 {
	public static String removeDuplicates(String s, int k) {
		int count[] = new int[s.length()];
		StringBuilder sb = new StringBuilder();
		for (char c : s.toCharArray()) {
			sb.append(c);
			int last = sb.length() - 1;
			count[last] = 1 + (last > 0 && sb.charAt(last) == sb.charAt(last - 1) ? count[last - 1]: 0);
			if (count[last] >= k) sb.delete(sb.length() - k, sb.length());
		}
		return sb.toString();
	}
	public static void main(String args[]) {
		String s = "deeedbbcccbdaa";
		int k = 3;
		System.out.println(removeDuplicates(s, k));
	}
}

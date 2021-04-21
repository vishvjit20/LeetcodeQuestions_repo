import java.util.Stack;

public class SimplifyPath {
	public static String simplifyPath(String path) {
		Stack<String> st = new Stack<>();
		String res = "/";
		for (int i = 0; i < path.length(); i++) {
			String dir = "";
			while (i < path.length() && path.charAt(i) == '/') i++;
			while (i < path.length() && path.charAt(i) != '/') {
				dir += path.charAt(i);
				i++;
			} 
			if (dir.equals(".")) continue;
			else if (dir.equals("..")) {
				if (!st.isEmpty()) {
					st.pop();
				}
			}
			else if (dir.length() != 0) st.push(dir);
		}
		Stack<String> st1 = new Stack<>();
		while (!st.isEmpty()) 
			st1.push(st.pop());
		while (!st1.isEmpty()) {
			if (st.size() == 1) res += st1.pop();
			else res += st1.pop() + "/";
		}
		return res;
	}
	public static void main(String args[]) {
		String str = "/a/b/.././c/d/e//////f///g/../h";
		String res = simplifyPath(str);
		System.out.println(res);
	}
}

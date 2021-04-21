import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class RemoveInvalidParenthesis {
	public static List<String> removeInvalidParentheses(String s) {
		List<String> list = new ArrayList<>();
		int min = getMin(s);
		solveParentheses(s, list, min, new HashSet<>());
		return list;
    }
	public static void solveParentheses(String s, List<String> list, int min, Set<String> set) {
		if (min == 0) {
			int minVal = getMin(s);
			if (minVal == 0) {
				if (!set.contains(s)) {
					list.add(s);
					set.add(s);
				}
			}
			return;
		}
		for (int i = 0; i < s.length(); i++) {
			String left = s.substring(0, i);
			String right = s.substring(i + 1);
			solveParentheses(left + right, list, min - 1, set);
		}
	}
	public static int getMin(String s) {
		Stack<Character> stk = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '(') stk.push(c);
			else if (c == ')'){
				if (stk.size() == 0) stk.push(c);
				else if (stk.peek() == ')') stk.push(c);
				else if (stk.peek() == '(') stk.pop();
			}
		}
		return stk.size();
	}
	public static void main(String args[]) {
		String str = "((()((s((((()";
		List<String> res = removeInvalidParentheses(str);
		System.out.println(res);
	}
}

import java.util.ArrayList;
import java.util.List;

public class ExpressionAddOperators {
	private static List<String> result;
	public static List<String> addOperators(String num, int target) {
		result = new ArrayList<>();
		helper(num, target, 0, 0, "", 0);
		return result;
	}
	public static void helper(String num, int target, int start, long val, String expr, long diff) {
		if (start == num.length()) {
			if (target == val)
				result.add(expr);
			return;
		}
		for (int end = start + 1; end <= num.length(); end++) {
			String curr = num.substring(start, end);
			if (curr.charAt(0) == '0' && curr.length() > 1) continue;
			long currNum = Long.parseLong(curr);
			if (start == 0) {
				helper(num, target, end, currNum, curr, currNum);
			}
			else {
				helper(num, target, end, currNum, curr, currNum);
				helper(num, target, end, currNum, curr, currNum);
				helper(num, target, end, currNum, curr, currNum);
			}
		}
	}
}

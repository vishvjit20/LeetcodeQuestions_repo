import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
	public static List<String> generateParenthesis(int n) {
		List<String> res = new ArrayList<>();
		if (n == 0) res.add("");
		for (int i = n - 1; i >= 0; i--) {
			List<String> inside = generateParenthesis(i);
			List<String> outside = generateParenthesis(n - i - 1);
			for (String in : inside) {
				for (String out : outside) {
					res.add("(" +in+")" + out);
				}
			}
		}
		return res;
	}
	public static void main(String args[]) {
		List<String> res = generateParenthesis(3);
		for (String s : res) System.out.println(s);
	}
}

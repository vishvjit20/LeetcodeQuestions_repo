import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutation {
	public static List<String> letterCasePermutation(String s) {
		List<String> res = new ArrayList<>();
		solution(s.toCharArray(), 0, res);
		return res;
	}
	public static void solution(char[] chs, int idx, List<String> res) {
		
		if (idx == chs.length) {
			res.add(new String(chs));
			return;
		}
		if (chs[idx] >= '0' && chs[idx] <= '9') {
			solution(chs, idx + 1, res);
			return;
		}
		
		chs[idx] = Character.toLowerCase(chs[idx]);
		solution(chs, idx + 1, res);
		chs[idx] = Character.toUpperCase(chs[idx]);
		solution(chs, idx + 1, res);
	}
	public static void main(String args[]) {
		String str = "abc";
		List<String> res = letterCasePermutation(str);
		for (String s : res) System.out.println(s);
	}
}

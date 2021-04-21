import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationOfPhoneNo {
	public static List<String> letterCombinations(String digits) {
		List<String> list = new ArrayList<>();
		if (digits == null || digits.length() == 0)
			return list;
		Map<Character, String> map = new HashMap<>();
		map.put('2', "abc");
		map.put('3', "def");
		map.put('4', "ghi");
		map.put('5', "jkl");
		map.put('6', "mno");
		map.put('7', "pqrs");
		map.put('8', "tuv");
		map.put('9', "wxyz");
		letterCombinationsHelper(digits, 0, map, new StringBuilder(), list);
		return list;
	}
	public static void letterCombinationsHelper(String digits, int i, Map<Character, String> map, StringBuilder ans, List<String> res) {
		if (i == digits.length()) {
			res.add(ans.toString());
			return;
		}
		
		String curr = map.get(digits.charAt(i));
		for (int k = 0; k < curr.length(); k++) {
			ans.append(curr.charAt(k));
			letterCombinationsHelper(digits, i + 1, map, ans, res);
			ans.deleteCharAt(ans.length() - 1);
		}
	}
	public static void main(String args[]) {
		String str = "235";
		List<String> res = letterCombinations(str);
		System.out.println(res);
	}
}

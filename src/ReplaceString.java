import java.util.*;

public class ReplaceString {
	public static String replaceString(List<String> dictionary, String sentence) {
		
		Set<String> dictSet = new HashSet<>();
		for (String word : dictionary)
			dictSet.add(word);
		StringBuilder sb = new StringBuilder();
		for (String word : sentence.split("\\s+")) {
			String prefix = "";
			for (int i = 1; i <= word.length(); i++) {
				prefix = word.substring(0, i);
				if (dictSet.contains(prefix))
					break;
			}
			if (sb.length() > 0) 
				sb.append(" ");
			sb.append(prefix);
		}
		return sb.toString();
	}
	public static void main(String args[]) {
		List<String> ls = new ArrayList<>();
		ls.add("cat");
		ls.add("catt");
		ls.add("rat");
		ls.add("rata");
		ls.add("bat");
		String sentence = "the cattle battle the rattle snake";
		System.out.println(replaceString(ls, sentence));
	}
}

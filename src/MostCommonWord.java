import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MostCommonWord {
	public static String mostCommonWord(String paragraph, String[] banned) {
		String normalized = paragraph.replaceAll("[^a-zA-Z0-9]", " ").toLowerCase();
		String words[] = normalized.split("\\s+");
		
		Set<String> set = new HashSet<>();
		for (String word : banned)
			set.add(word);
		
		Map<String, Integer> map = new HashMap<>();
		for (String word : words) {
			if (!set.contains(word)) {
				map.put(word, map.getOrDefault(word, 0) + 1); 
			}
		}
		
		return Collections.max(map.entrySet(), Map.Entry.comparingByValue()).getKey();
	}
	
	public static void main(String args[]) {
		String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
		String[] banned = {"hit"};
		System.out.println(mostCommonWord(paragraph, banned));
	}
}

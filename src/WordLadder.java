import java.util.*;

public class WordLadder {
	public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
		if (!wordList.contains(endWord))
			return 0;
		
		HashMap<String, Boolean> map = new HashMap<>();
		for (int i = 0; i < wordList.size(); i++)
			map.put(wordList.get(i), false);
		int len = 1;
		Queue<String> q = new LinkedList<>();
		q.add(beginWord);
		map.put(beginWord, true);
		while(!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				String w = q.poll();
				if (w.equals(endWord))
					return len;
				wordMatch(w, map, q);
			}
			len++;
		}
		return 0;
	}
	public static void wordMatch(String w, HashMap<String, Boolean> map, Queue<String> q) {
		for (int i = 0; i < w.length(); i++) {
			char[] word = w.toCharArray();
			for (int j = 0; j < 26; j++) {
				char c = (char)('a' + j);
				word[i] = c;
				String s = String.valueOf(word);
				if (map.containsKey(s) && map.get(s) == false) {
					q.add(s);
					map.put(s, true);
				}
			}
		}
	}
	public static void main(String args[]) {
		String bWord = "hit";
		String eWord = "cog";
		List<String> words = new ArrayList<>();
		words.add("hot");
		words.add("dot");
		words.add("dog");
		words.add("lot");
		words.add("log");
		words.add("cog");
		int res = ladderLength(bWord, eWord, words);
		System.out.println(res);
	}
}

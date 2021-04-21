import java.util.HashMap;
import java.util.PriorityQueue;

public class SortCharactersByFrequency {
	public static String frequencySort(String s) {
		HashMap<Character, Integer> map = new HashMap<>();
		for (char c : s.toCharArray()) {
			map.put(c, map.getOrDefault(c, 0) + 1);
		}
		
		PriorityQueue<Character> pq = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));
		pq.addAll(map.keySet());
		StringBuilder sb = new StringBuilder();
		 
		while (!pq.isEmpty()) {
			char c = pq.poll();
			for (int i = 0; i < map.get(c); i++) {
				sb.append(c);
			}
		}
		return sb.toString();
	}
	public static void main(String args[]) {
		String s = "vishwajeet_singh_kushwah";
		System.out.println(frequencySort(s));
	}
}

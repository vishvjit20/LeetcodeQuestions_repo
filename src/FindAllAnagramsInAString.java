import java.util.ArrayList;
import java.util.List;

public class FindAllAnagramsInAString {
	public static List<Integer> findAnagrams(String s, String p) {
        int hash[] = new int[26];
        List<Integer> result = new ArrayList<>();
        
        for (char c : p.toCharArray()) 
        	hash[c - 'a']++;
        
        int windowStart = 0;
        int windowEnd = 0;
        while (windowEnd < s.length()) {
        	if (hash[s.charAt(windowEnd) - 'a'] > 0) {
        		hash[s.charAt(windowEnd++) - 'a']--;
        		if (windowEnd - windowStart == p.length())
        			result.add(windowStart);
        	}
        	else if (windowStart == windowEnd) {
        		windowStart++;
        		windowEnd++;
        	}
        	else hash[s.charAt(windowStart++) - 'a']++;
        }
        return result;
    }
	public static void main(String args[]) {
		String s = "cbaebabacd";
		String p = "abc";
		
		List<Integer> res = findAnagrams(s, p);
		System.out.println(res);
	}
}

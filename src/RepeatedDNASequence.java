import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class RepeatedDNASequence {
	 public static List<String> findRepeatedDnaSequences(String s) {
		 if (s == null || s.length() < 10)
			 return new ArrayList<>();
		 
		 int start = 0;
		 int end = 10;
		 HashSet<String> set = new HashSet<>();
		 HashSet<String> res = new HashSet<>();
		 StringBuilder sb = new StringBuilder(s);
		 while (end <= s.length()) {
			 String curr = sb.substring(start, end);
			 if (set.contains(curr))
				 res.add(curr);
			 set.add(curr);
			 start++;
			 end++;
		 }
		 return new ArrayList<>(res);
	 }
	 public static void main(String args[]) {
		 String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
		 List<String> res = findRepeatedDnaSequences(s);
		 System.out.println(res);
	 }
}

import java.util.*;

public class PermutationSequence {
	 public static String getPermutation(int n, int k) {
	     List<Integer> numbers = new ArrayList<>();
	     int []factorial = new int[n + 1];
	     StringBuilder sb = new StringBuilder();
	     
	     int sum = 1;
	     factorial[0] = 1;
	     
	     for (int i = 1; i <= n; i++) {
	    	 sum *= i;
	    	 factorial[i] = sum;
	     }
	     
	     for (int i = 1; i <= n; i++) 
	    	 numbers.add(i);
	     
	     k--;
	     for (int i = 1; i <= n; i++) {
	    	 int idx = k/factorial[n - i];
	    	 sb.append(String.valueOf(numbers.get(idx)));
	    	 numbers.remove(idx);
	    	 k-=idx*factorial[n - i];
	     }
	     return String.valueOf(sb);
	 }
}

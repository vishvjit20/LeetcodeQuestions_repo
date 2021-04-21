
public class ShortestDistanceToACharacter {
	public static int[] shortestToChar(String s, char c) {
		int n = s.length();
		int c_position = -n;
		int output[] = new int[n];
		
		for (int i = 0; i < n; i++) {
			if (s.charAt(i) == c) 
				c_position = i;
			output[i] = i - c_position;
		}
		
		for (int i = n - 1; i >= 0; i--) {
			if (s.charAt(i) == c) 
				c_position = i;
			output[i] = Math.min(output[i], Math.abs(i - c_position));
		}

		return output;
	}
	public static void main(String args[]) {
		String str = "loveleetcode";
		char c = 'e';
		int []res = shortestToChar(str, c);
		for (int x : res) System.out.print(x + " ");
	}
}

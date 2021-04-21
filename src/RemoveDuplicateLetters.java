import java.util.Stack;

public class RemoveDuplicateLetters {
	public static String removeDuplicateLetters(String s) {
        int res[] = new int[26];
        char ch[] = s.toCharArray();
        for (char c : ch) res[c - 'a']++;
        boolean visited[] = new boolean[26];
        Stack<Character> stk = new Stack<>();
        int idx;
        for (char c : ch) {
        	idx = c - 'a';
        	res[idx]--;
        	if (visited[idx]) continue;
        	while (!stk.isEmpty() && c < stk.peek() && res[stk.peek() - 'a'] != 0)
        		visited[stk.pop() -  'a'] = false;
        	stk.push(c);
        	visited[idx] = true;
        }
        StringBuilder sb = new StringBuilder();
        while (!stk.isEmpty()) sb.insert(0, stk.pop());
        return sb.toString();
    }
	public static void main(String args[]) {
		String str = "cacb";
		String res = removeDuplicateLetters(str);
		System.out.println(res);
	}
}

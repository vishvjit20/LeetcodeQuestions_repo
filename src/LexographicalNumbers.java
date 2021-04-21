import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LexographicalNumbers {
	public static List<Integer> lexicalOrder(int n) {
		List<Integer> list = new ArrayList<>();
		if (n < 1) return list;
		for (int i = 1; i <= 9; i++) {
			dfs(n, i, list);
		}
		return list;
	}
	public static void dfs(int n, int curr, List<Integer> res) {
		if (curr > n) return;
		res.add(curr);
		for (int i = 0; i < 10; i++) {
			if (10 * curr + i > n)
				return;
			dfs(n, 10 * curr + i, res);
		}
	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		List<Integer> res = lexicalOrder(n);
		for (int r : res) System.out.println(r);
		sc.close();
	}
}

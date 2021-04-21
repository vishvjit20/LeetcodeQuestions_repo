import java.util.HashSet;
import java.util.Set;

public class HappyNumber {
	public static boolean isHappy(int n) {
		Set<Integer> set = new HashSet<>();
		while (n != 1 && !set.contains(n)) {
			set.add(n);
			int sum = 0;
			while (n > 0) {
				sum += Math.pow(n % 10, 2);
				n /= 10;
			}
			n = sum;
		}
		return n == 1;
	}
	public static void main(String args[]) {
		int n = 19;
		System.out.println(isHappy(n));
	}
}

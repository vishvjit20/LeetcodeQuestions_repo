
public class EliminationGame {
	public static int lastRemaining(int n) {
		int head = 1, step = 1;
		boolean direction = true;
		while (n > 1) {
			if (direction) head += step;
			else head += n % 2 == 0 ? 0 : step;
			step *= 2;
			n /= 2;
			direction = !direction;
		}
		return head;
	}
	public static void main(String args[]) {
		int n = 9;
		System.out.println(lastRemaining(n));
	}
}

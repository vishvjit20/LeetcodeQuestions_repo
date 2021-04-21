
public class DistributeCandies {
	public static int[] distributeCandies(int candies, int num_people) {
		int n = num_people;
		int res[] = new int[n];
		int candy = 1, i = 0;
		while (candy <= candies) {
			if (i == n) i = 0;
			res[i++] += candy;
			candies -= candy;
			candy += 1;
		}
		if (candies > 0) {
			if (i == n) i = 0;
			res[i] += candies;
		}
		return res;
	}
	public static void main(String args[]) {
		int res[] = distributeCandies(20, 4);
		for (int r : res) System.out.print(r + " ");
	}
}

import java.util.Arrays;

public class CandyDistribution {
	public static int candy(int[] ratings) {
		int n = ratings.length;
		int a[] = new int[n];
		int b[] = new int[n];
		Arrays.fill(a, 1);
		Arrays.fill(b, 1);
		int cnt = 0;
		for (int i = 1; i < n; i++)
			if (ratings[i] > ratings[i - 1])
				a[i] = a[i - 1] + 1;
		for (int i = n - 2; i >= 0; i--) 
			if (ratings[i] > ratings[i + 1])
				b[i] = b[i + 1] + 1;
		for (int i = 0; i < n; i++)
			cnt += Math.max(a[i], b[i]);
		return cnt;
	}
	public static void main(String args[]) {
		int arr[] = {1, 3, 2};
		System.out.println(candy(arr));
	}
}

import java.util.Arrays;

public class ThreeSumWithMultiplicity {
	public static int threeSumMulti(int[] arr, int target) {
		int n = arr.length;
		int MOD = 1000000007;
		long cnt = 0;
		Arrays.sort(arr);
		for (int i = 0; i < n - 2; i++) {
			int j = i + 1;
			int k = n - 1;
			int t = target - arr[i];
			while(j < k) {
				if (arr[j] + arr[k] < t) j++;
				else if (arr[j] + arr[k] > t) k--;
				else if (arr[j] != arr[k]) {
					int left = 1, right = 1;
					while (j + 1 < k && arr[j] == arr[j + 1]) {
						left++;
						j++;
					}
					while (k - 1 > j && arr[k] == arr[k - 1]) {
						right++;
						k--;
					}
					cnt += left * right;
					cnt %= MOD;
					j++;
					k--;
				}
				else {
					cnt += (k - j + 1) * (k - j) / 2;
					cnt = cnt % MOD;
					break;
				}
			}
		}
		return (int)cnt;
	}
	public static void main(String args[]) {
		int arr[] = {1,1,2,2,3,3,4,4,5,5};
		int target = 8;
		System.out.println(threeSumMulti(arr, target));
	}
}

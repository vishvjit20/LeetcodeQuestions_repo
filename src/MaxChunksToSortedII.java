public class MaxChunksToSortedII {
	public static int maxChunksToSorted(int arr[]) {
		int max = 0;
		int cnt = 0;
		
		for (int i = 0; i < arr.length; i++) {
			max = Math.max(max, arr[i]);
			System.out.println(max);
			if (max == arr[i]) cnt++;
		}
		return cnt == arr.length ? 1 : cnt;
	}
	public static void main(String args[]) {
		int[] nums = {2, 1, 3, 4, 4};
		System.out.println(maxChunksToSorted(nums));
	}
}

/*
 * nums = [2, 3, 4, 5, 7, 4, 8, 9, 1]
 *        check if  nums[k] < nums[k + 1]
 *        [2, 3, 4, 5, 7, 8, 4, 9, 1] ----Wrong 
 *        [2, 3, 4, 5, 7, 4, 9, 8, 1]
 *        [2, 3, 4, 5, 7, 4, 9, 1, 8]
 *        
 * nums = [1, 2, 7, 9, 6, 4, 1]
 * 		  [1, 2, 9, 7, 6, 4, 1]
 * 		  [1, 2, 9, 1, 4, 6, 7]
 * 		  
 * **/
public class NextPermutation {
	public static void swap(int nums[], int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
	public static void reverse(int nums[], int i, int j) {
		while (i < j) {
			swap(nums, i, j);
			i++;
			j--;
		}
	}
	public static void nextPermutation(int nums[]) {
		int i, j, n = nums.length;
		for (i = n - 2; i >= 0; i--) 
		{
			if (nums[i] < nums[i + 1]) 
				break;
		}
		if (i < 0) reverse(nums, 0, n - 1);
		else {
			for (j = n - 1; j > i; j--) {
				if (nums[j] > nums[i]) {
					break;
				}
			}
			swap(nums, i, j);
			reverse(nums, i + 1, n - 1);
		}
	}
	public static void main(String args[]) {
		int nums[] = {1, 2, 7, 9, 6, 4, 1};
		nextPermutation(nums);
		for (int x : nums) System.out.print(x + " ");
	}
}

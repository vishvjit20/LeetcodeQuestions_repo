public class SlidingWindowMaximum {
//	public static int[] maxSlidingWindow(int[] nums, int k) {
//		int n = nums.length;
//		if (n == 0 || k == 0) {
//			return new int[0];
//		}
//		int numOfWindow = n - k + 1;
//		int[] result = new int[numOfWindow];
//		
//		for (int start = 0; start < numOfWindow; start++) {
//			int end = start + k - 1;
//			int maxVal = nums[start];
//			for (int i = start + 1; i <= end; i++) 
//				if (nums[i] > maxVal) 
//					maxVal = nums[i];
//			result[start] = maxVal;
//		}
//		return result;
//	}
	
	public static int[] maxSlidingWindow(int[] nums, int k) {
		int n = nums.length;
		if (n == 0 || k == 0) {
			return new int[0];
		}
		
		int result[] = new int[n - k + 1];
		
		int left[] = new int[n];
		int right[] = new int[n];
		
        left[0] = nums[0];
        right[n - 1] = nums[n - 1];
		  
		for (int i = 1; i < n; ++i) {
			if (i % k == 0) 
				left[i] = nums[i];
			else            
				left[i] = Math.max(left[i - 1], nums[i]);
			
		    int j = n - i - 1;
		    if (j % k == (k - 1)) 
		    	right[j] = nums[j];
		    else                  
		    	right[j] = Math.max(right[j + 1], nums[j]);
	  }

		for (int i = 0, j = i + k - 1; j < n; j++, i++) {
			result[i] = Math.max(right[i], left[j]);
		}
		return result;
	}
	public static void main(String args[]) {
		int nums[] = {1, 3, -1, -3, 5, 3, 6, 7};
		int k = 3;
		int[] res = maxSlidingWindow(nums, k);
		for (int r : res) System.out.print(r + " ");
	}
}

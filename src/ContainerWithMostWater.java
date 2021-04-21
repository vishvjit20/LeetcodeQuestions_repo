
public class ContainerWithMostWater {
	public static int maxArea(int height[]) {
		int n = height.length;
		if (n <= 1) return 0;
		int start = 0, end = n - 1;
		int max_area = 0;
		while (start < end) {
			int area = Math.min(height[start], height[end]) * (end - start);
			max_area = Math.max(area, max_area);
			int delta = height[start] - height[end];
			if (delta > 0) end--;
			else if (delta < 0) start++;
			else {
				start++;
				end--;
			}
		}
		return max_area;
	}
	public static void main(String args[]) {
		int nums[] = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
		int max = maxArea(nums);
		System.out.println(max);
	}
}

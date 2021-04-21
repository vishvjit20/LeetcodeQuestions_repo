import java.util.ArrayList;
import java.util.List;

public class FindKClosestPoints {
	public static List<Integer> findClosestElements(int arr[], int k, int x) {
		int low = 0;
		int high = arr.length - 1;
		while (high - low >= k) {
			if ((Math.abs(arr[low] - x)) > Math.abs(arr[high] - x)) {
				low++;
			}
			else high--;
		}
		List<Integer> res = new ArrayList<>();
		for (int i = low; i <= high; i++)
			res.add(arr[i]);
		return res;
	}
	public static void main(String args[]) {
		int arr[] = {1, 2, 3, 4, 5, 6, 7, 8};
		int k = 6; 
		int x = 6;
		System.out.println(findClosestElements(arr, k, x));
	}
}

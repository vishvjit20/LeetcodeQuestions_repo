
public class CapacityToShipPackageWithinDDays {
	public static int shipWithinDays(int[] weights, int D) {
        int left = 0, right = 0;
        for (int w : weights) {
        	left = Math.max(left, w);
        	right += w;
        }
        
        while (left < right) {
        	int mid = left + (right - left) / 2;
        	int need = 1, curr = 0;
        	for (int w : weights) {
        		if (curr + w > mid) {
        			need += 1;
        			curr = 0;
        		} 
        		curr += w;
        	}
        	if (need > D) left = mid + 1;
        	else right = mid;
        }
        return left;
    }
	public static void main(String args[]) {
		int []weights = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		int D = 5;
		System.out.println(shipWithinDays(weights, D));
	}
}


import java.util.LinkedList;
import java.util.List;

class ArrayValOrigIdx {
	int val, idx;
	public ArrayValOrigIdx(int val, int idx) {
		this.val = val;
		this.idx = idx;
	}
}

public class CountOfSmallerNumberAfterSelf {	
	public static List<Integer> countSmaller(int[] nums) {
		List<Integer> res = new LinkedList<>();
		if (nums.length == 0)
			return res;
		int n = nums.length;
		int[] result = new int[n];
		
		ArrayValOrigIdx[] newNums = new ArrayValOrigIdx[n];
		for (int i = 0; i < n; i++) {
			newNums[i] = new ArrayValOrigIdx(nums[i], i);
		}
		
		mergeSortAndCount(newNums, 0, n - 1, result);
		for (int i : result) res.add(i);
		return res;
	}
	
	private static void mergeSortAndCount(ArrayValOrigIdx[] nums, int start, int end, int[] res) {
		
		if (start >= end) return;
		
		int mid = start + (end - start) / 2;
		mergeSortAndCount(nums, start, mid, res);
		mergeSortAndCount(nums, mid + 1, end, res);
		
		int leftPos = start;
		int rightPos = mid + 1;
		LinkedList<ArrayValOrigIdx> merged = new LinkedList<>();
		int count = 0;
		while (leftPos <= mid && rightPos <= end) {
			if (nums[leftPos].val > nums[rightPos].val) {
				count++;
				merged.add(nums[rightPos]);
				rightPos++;
			}
			else {
				res[nums[leftPos].idx] += count;
				merged.add(nums[leftPos]);
				leftPos++;
			}
		}
		while (leftPos <= mid) {
			res[nums[leftPos].idx] += count;
			merged.add(nums[leftPos]);
			leftPos++;
		}
		while (rightPos <= end) {
			merged.add(nums[rightPos]);
			rightPos++;
		}
		
		int pos = start;
		for (ArrayValOrigIdx m : merged) {
			nums[pos] = m;
			pos++;			
		}
	}
	
	public static void main(String args[]) {
		int[] nums = {5, 2, 6, 1, 3, 4, 5, 6, 3, 1};
		List<Integer> list = countSmaller(nums);
		System.out.println(list);
	}
}

import java.util.Arrays;
import java.util.Stack;

class Pairs implements Comparable<Pairs> {
	int start, end;
	Pairs(int start, int end) {
		this.start = start;
		this.end = end;
	}
	public int compareTo(Pairs p) {
		if (this.start != p.start) 
			return this.start - p.start;
		return this.end - p.end;
	}
}

public class MergeIntervals {
	public static int[][] merge(int[][] nums) {
		Pairs pairs[] = new Pairs[nums.length];
		for (int i = 0; i < nums.length; i++) {
			pairs[i] = new Pairs(nums[i][0], nums[i][1]);
		}
		Arrays.sort(pairs);
		Stack<Pairs> st = new Stack<>();
		for (int i = 0; i < pairs.length; i++) {
			if (i == 0) st.push(pairs[i]);
			else {
				Pairs top = st.peek();
				if (top.end < pairs[i].start)
					st.push(pairs[i]);
				else {
					top.end = Math.max(top.end, pairs[i].end);
				}
			}
		}
		Stack<Pairs> stk = new Stack<>();
		while (!st.isEmpty()) stk.push(st.pop());
		
		int res[][] = new int[stk.size()][2];
		for (int i = 0; i < res.length; i++) {
			Pairs p = stk.pop();
			res[i][0] = p.start;
			res[i][1] = p.end;
		}
		return res;
	}
	public static void main(String args[]) {
		int nums[][] = {
							{7, 21}, {3, 5}, {9, 54}, {104, 200}, {222, 420}, 
							{555, 600}, {580, 700}, {705, 722}, {0, 4}, {1000, 2000}
						};
		int res[][] = merge(nums);
		for (int i = 0; i < res.length; i++) 
			System.out.println(res[i][0] + " " + res[i][1]);
	}
}

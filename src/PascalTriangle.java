import java.util.*;

public class PascalTriangle {
	public static List<List<Integer>> generate(int numRows) {
		List<List<Integer>> list = new ArrayList<>();
		if (numRows == 0)
			return list;
		List<Integer> first_row = new ArrayList<>();
		first_row.add(1);
		list.add(first_row);
		for (int i = 1; i < numRows; i++) {
			List<Integer> prev = list.get(i - 1);
			List<Integer> curr = new ArrayList<>();
			curr.add(1);
			for (int j = 1; j < i; j++) {
				curr.add(prev.get(j - 1) + prev.get(j));
			}
			curr.add(1);
			list.add(curr);
		}
		return list;
	}
	public static void main(String args[]) {
		System.out.println(generate(10));
	}
}

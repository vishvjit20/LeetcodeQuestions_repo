import java.util.Arrays;
import java.util.HashSet;

public class PrisonCellsAfterNDays {
	public static int[] prisonAfterNDays(int[] cells, int n) {
		if (cells == null || cells.length == 0 || n <= 0) return cells;
		boolean hasCycle = false;
		int cycle = 0;
		HashSet<String> set = new HashSet<>();
		for (int i = 0; i < n; i++) {
			int []next = nextDayCells(cells);
			String key = Arrays.toString(next);
			if (!set.contains(key)) {
				set.add(key);
				cycle++;
			}
			else {
				hasCycle = true;
				break;
			}
			cells = next;
		}
		if (hasCycle) {
			n = n % cycle;
			for (int i = 0; i < n; i++) {
				cells = nextDayCells(cells);
			}
		}
		return cells;
	}
	
	public static int[] nextDayCells(int[] cells) {
		int[] temp = new int[cells.length];
		for (int i = 1; i < cells.length - 1; i++) 
			if (cells[i - 1] == cells[i + 1])
				temp[i] = 1;
		return temp;
	}
	public static void main(String args[]) {
		int cells[] = {1,0,0,1,0,0,1,0};
		int n = 1000000000;
		int []res = prisonAfterNDays(cells, n);
		for (int x : res) System.out.print(x + " ");
	}
}

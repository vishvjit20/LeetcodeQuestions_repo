import java.util.Arrays;
import java.util.Comparator;

public class MeetingRoom {
	public static boolean canAttendMeeting(int interval[][]) {
		if (interval.length == 0)
			return false;
		
		Arrays.sort(interval, new Comparator<int[]>() {
			public int compare(int a[], int b[]) {
				return a[0] - b[0];
			}
		});
		
		int[] prev = interval[0];
		for (int i = 1; i < interval.length; i++) {
			int[] curr = interval[i];
			if (prev[1] > curr[0]) 
				return false;
			prev = curr;
		}
		return true;
	}
	public static void main(String args[]) {
		int interval[][] = {{0, 3}, {5, 10}, {15, 20}};
		System.out.println(canAttendMeeting(interval));
	}
}

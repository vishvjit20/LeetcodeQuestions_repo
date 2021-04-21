import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber {
	public static String largestNumber(int[] nums) {
		String []str = new String[nums.length];
		for (int i = 0; i < nums.length; i++) {
			str[i] = String.valueOf(nums[i]);
		}
		Arrays.sort(str, new Comparator<String>() {
			public int compare(String a, String b) {
				return (b + a).compareTo(a + b);
			}
		});
		StringBuilder sb = new StringBuilder();
		for (String s : str) {
			sb.append(s);
		}
		if (sb.charAt(0) == '0')
			return String.valueOf('0');
		return sb.toString();
	}
	public static void main(String args[]) {
		int nums[] = {10, 2, 3, 7, 21};
		System.out.println(largestNumber(nums));
	}
}

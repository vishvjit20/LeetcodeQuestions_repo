import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddress {
	
	public static List<String> restoreIpAddresses(String s) {
		List<String> solution = new ArrayList<>();
		restoreIp(s, "", solution, 0, 0);
		return solution;
	}
	
	public static void restoreIp(String s, String restored, List<String> solution, int idx, int count) {
		if (count > 4) return;
		if (count == 4 && idx == s.length()) {
			solution.add(restored);
		}
		
		for (int i = 1; i < 4; i++) {
			if (idx + i > s.length()) break;
			String str = s.substring(idx, idx + i);
			if ((str.startsWith("0") && str.length() > 1) || (i == 3 && Integer.parseInt(str) > 255))
				continue;
			restoreIp(s, restored + str + (count == 3 ? "" : "."), solution, idx + i, count + 1);
		}
	}
	
	public static void main(String args[]) {
		String str = "25525511135";
		List<String> res = restoreIpAddresses(str);
		System.out.println(res);
	}
}

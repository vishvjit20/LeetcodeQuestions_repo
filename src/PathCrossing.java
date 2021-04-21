import java.util.HashSet;

public class PathCrossing {
	public static boolean isPathCrossing(String path) {
		if (path.length() <= 1) return false;
		int x = 0, y = 0;
		HashSet<String> set = new HashSet<>();
		set.add(x +"#"+ y);
		for (char c : path.toCharArray()) {
			if (c == 'N') y++;
			else if (c == 'S') y--;
			else if (c == 'E') x++;
			else x--;
			String key = x +"#"+ y;
			if (set.contains(key)) {
				return true;
			}
			set.add(key);
		}
		return false;
	}
	public static void main(String args[]) {
		String path = "NESWW";
		System.out.println(isPathCrossing(path));
	}
}

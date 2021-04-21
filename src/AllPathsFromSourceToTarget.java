import java.util.ArrayList;
import java.util.List;

public class AllPathsFromSourceToTarget {
	public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> path = new ArrayList<>();
		path.add(0);
		dfsSearch(graph, 0, res, path);
		return res;
 	}
	public static void dfsSearch(int[][] graph, int node, List<List<Integer>> res, List<Integer> path) {
		if (node == graph.length - 1) {
			res.add(new ArrayList<>(path));
			return;
		}
		
		for (int next : graph[node]) {
			path.add(next);
			dfsSearch(graph, next, res, path);
			path.remove(path.size() - 1);
		}
	}
	public static void main(String args[]) {
		int[][] graph = {
							{4, 3, 1},
							{3, 2, 4},
							{3},
							{4},
							{}
						};
		List<List<Integer>> res = allPathsSourceTarget(graph);
		System.out.println(res);
	}
}

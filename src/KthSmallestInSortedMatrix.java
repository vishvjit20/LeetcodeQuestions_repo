import java.util.PriorityQueue;

class Node {
	int row;
	int col;
	public Node(int row, int col) {
		this.row = row;
		this.col = col;
	}
}

public class KthSmallestInSortedMatrix {
	public static int kthSmallest(int[][] matrix, int k) {
		PriorityQueue<Node> minHeap = new PriorityQueue<>((n1, n2) -> matrix[n1.row][n1.col] - matrix[n2.row][n2.col]);
		for (int i = 0; i < matrix.length; i++) 
			minHeap.offer(new Node(i, 0));
		int count = 0;
		int result = 0;
		while (!minHeap.isEmpty()) {
			Node node = minHeap.poll();
			result = matrix[node.row][node.col];
			if (++count == k) {
				break;
			}
			node.col++;
			if (node.col < matrix[0].length)
				minHeap.add(node);
		}
		return result;
	}
	public static void main(String args[]) {
		int matrix[][] = {
							{ 1,  5,  9},
							{10, 11, 13},
							{12, 13, 15}
						 };
		int k = 8;
		int res = kthSmallest(matrix, k);
		System.out.println(res);
	}
}

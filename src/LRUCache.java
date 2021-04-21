
import java.util.*;

public class LRUCache {
	class Node {
		int key;
		int value;
		Node prev;
		Node next;
		Node (int key, int value) {
			this.key = key;
			this.value = value;
		}
	}
	private Map<Integer, Node> map = new HashMap<>();
	private Node first;
	private Node last;
	private int capacity;
	
	public LRUCache(int capacity) {
		this.capacity = capacity;
		first = new Node(0, 0);
		last = new Node(0, 0);
		first.next = last;
		last.prev = first;
	}
	
	public void put(int key, int value) {
		if (map.containsKey(key)) {
			remove(map.get(key));
		}
		if (map.size() == capacity) {
			remove(last.prev);
		}
		insert(new Node(key, value));
	}
	
	public int get(int key) {
		Node node = map.get(key);
		if (node == null) {
			return -1;
		}
		remove(node);
		insert(node);
		return node.value;
	}
	private void insert(Node node) {
		map.put(node.key, node);
		first.next.prev = node;
		node.next = first.next;
		node.prev = first;
		first.next = node;
	}
	private void remove(Node node) {
		map.remove(node.key);
		node.prev.next = node.next;
		node.next.prev = node.prev;
	}
}

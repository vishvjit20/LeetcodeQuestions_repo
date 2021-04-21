import java.util.*;

public class WordSearchII {
	public static class TrieNode {
		char c;
		boolean isWord;
		TrieNode[] children;
		TrieNode(char c) {
			this.c = c;
			isWord = false;
			children = new TrieNode[26];
		}
	}
	public static TrieNode root = new TrieNode('0');
	public static void addToTrie(String[] words) {
		for (String word : words) {
			TrieNode curr = root;
			for (int i = 0; i < word.length(); i++) {
				char c = word.charAt(i);
				if (curr.children[c - 'a'] == null) {
					curr.children[c - 'a'] = new TrieNode(c);
				}
				curr = curr.children[c - 'a'];
			}
			curr.isWord = true;
		}
	}
	public static boolean visited[][];
	public static List<String> findWords(char[][] board, String[] words) {
		Set<String> set = new HashSet<>();
		visited = new boolean[board.length][board[0].length];
		addToTrie(words);
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (root.children[board[i][j] - 'a'] != null) {
					search(board, i, j, "", set, root);
				}
			}
		}
		return new ArrayList<>(set);
	}
	public static void search(char[][] board, int i, int j, String word, Set<String> result, TrieNode node) {
		if (i < 0 || i == board.length || j < 0 || j == board[0].length || visited[i][j] || node.children[board[i][j] - 'a'] == null) {
			return;
		}
		visited[i][j] = true;
		node = node.children[board[i][j] - 'a'];
		if (node.isWord) result.add(word + board[i][j]);
		
		search(board, i - 1, j, word + board[i][j], result, node);
		search(board, i + 1, j, word + board[i][j], result, node);
		search(board, i, j - 1, word + board[i][j], result, node);
		search(board, i, j + 1, word + board[i][j], result, node);
		visited[i][j] = false;
	}
	public static void main(String args[]) {
		char[][] board = {
							{'o', 'a', 'a', 'n'},
							{'e', 't', 'a', 'e'}, 
							{'i', 'h', 'k', 'r'}, 
							{'i', 'f', 'l', 'v'}
						};
		String[] words = {"oath","pea","eat","rain"};
		System.out.println(findWords(board, words));
	}
} 

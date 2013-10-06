public class WordSearch {
	public boolean exist(char[][] board, String word) {
		if (board == null) {
			return false;
		}
		if (word == null || word.length() == 0) {
			return true;
		}
		boolean[][] visited = new boolean[board.length][board[0].length];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (search(board, visited, word, i, j, 0)) {
					return true;
				}
			}
		}
		return false;
	}

	private boolean search(char[][] board, boolean[][] visited, String word, int i, int j, int index) {
		if (visited[i][j] || board[i][j] != word.charAt(index)) {
			return false;
		}
		if (index == word.length() - 1) {
			return true;
		}
		visited[i][j] = true;
		boolean found = false;
		if (!found && i > 0) {
			found = search(board, visited, word, i - 1, j, index + 1);
		}
		if (!found && i < board.length - 1) {
			found = search(board, visited, word, i + 1, j, index + 1);
		}
		if (!found && j < board[0].length - 1) {
			found = search(board, visited, word, i, j + 1, index + 1);
		}
		if (!found && j > 0) {
			found = search(board, visited, word, i, j - 1, index + 1);
		}
		visited[i][j] = false;
		return found;
	}

	public static void main(String[] args) {
		WordSearch ws = new WordSearch();
		System.out.println(ws.exist(new char[][] { { 'a' } }, "ab"));
	}
}

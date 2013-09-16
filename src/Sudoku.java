import java.util.HashMap;
import java.util.Map;

public class Sudoku {
	/**
	 * http://leetcode.com/oldoj#question_36
	 */
	public boolean isValidSudoku(char[][] board) {
		return checkRow(board) && checkCol(board) && checkSquare(board);
	}

	private boolean checkRow(char[][] board) {
		for (int i = 0; i < 9; i++) {
			Map<Character, Boolean> map = new HashMap<Character, Boolean>();
			for (int j = 0; j < 9; j++) {
				if (isDigit(board[i][j])) {
					if (map.containsKey(board[i][j])) {
						return false;
					} else {
						map.put(board[i][j], true);
					}
				}
			}
		}
		return true;
	}

	private boolean checkCol(char[][] board) {
		for (int i = 0; i < 9; i++) {
			Map<Character, Boolean> map = new HashMap<Character, Boolean>();
			for (int j = 0; j < 9; j++) {
				if (isDigit(board[j][i])) {
					if (map.containsKey(board[j][i])) {
						return false;
					} else {
						map.put(board[j][i], true);
					}
				}
			}
		}
		return true;
	}

	private boolean checkSquare(char[][] board) {
		for (int i = 0; i < 9; i += 3) {
			for (int j = 0; j < 9; j += 3) {
				Map<Character, Boolean> map = new HashMap<Character, Boolean>();
				for (int m = 0; m < 3; m++) {
					for (int n = 0; n < 3; n++) {
						if (isDigit(board[i + m][j + n])) {
							if (map.containsKey(board[i + m][j + n])) {
								return false;
							} else {
								map.put(board[i + m][j + n], true);
							}
						}
					}
				}
			}
		}
		return true;
	}

	private boolean isDigit(char c) {
		return c >= '0' && c <= '9';
	}
}

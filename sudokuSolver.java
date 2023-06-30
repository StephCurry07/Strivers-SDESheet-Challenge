public class sudokuSolver {
/********* Do it once again... Finally solved it...*******/
    public static boolean solve(int[][] board) {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (board[i][j] == 0) {
					for (int k = 1; k <= 9; k++) {
						if (isValid(k, board, i, j)) {
							board[i][j] = k;
							if (solve(board) == true)
								return true;
							else 
								board[i][j] = 0;
						}
					}
					return false;
				}
			}
		}
		return true;
	}

	public static boolean isValid(int val, int[][] board, int row, int col) {
		for (int i = 0; i < 9; i++) {
			if (board[row][i] == val) {
				return false;
			}
			if (board[i][col] == val) {
				return false;
			}
			if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == val) {
				return false;
			}
		}
		return true;
	}

	public static boolean isItSudoku(int matrix[][]) {
		return solve(matrix);
	}
}

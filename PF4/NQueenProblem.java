/**
 * N Queens Problem - The N Queen is the problem of placing N chess queens on an
 * N×N chess board so that no two queens attack each other. (Thus, a solution
 * requires that no two queens share the same row, column, or diagonal)
 * 
 * @author Udit Saxena
 *
 */
public class NQueenProblem {

	/**
	 * This function check if a queen can be placed on board[row][column]
	 * 
	 * @param board
	 *            - 2D Array of N*N dimension (Square Matrix)
	 * @param row
	 *            - row number of Array
	 * @param column
	 *            - column number of array
	 * @param dimensionOfMatrix
	 *            - dimension of square Matrix
	 * @return boolean - if queen can be placed on board it return True else
	 *         False
	 */
	boolean isSafe(int board[][], int row, int column, int dimensionOfMatrix) {
		int rowIndex, columnIndex;
		// Check this column on down side
		for (rowIndex = 0; rowIndex < row; rowIndex++) {
			if (board[rowIndex][column] == 1) {
				return false;
			}
		}
		// Check upper diagonal on left side
		for (rowIndex = row, columnIndex = column; rowIndex >= 0 && columnIndex >= 0; rowIndex--, columnIndex--) {
			if (board[rowIndex][columnIndex] == 1) {
				return false;
			}
		}

		// Check upper diagonal on right side
		for (rowIndex = row, columnIndex = column; rowIndex >= 0 && columnIndex < dimensionOfMatrix; rowIndex--, columnIndex++) {
			if (board[rowIndex][columnIndex] == 1) {
				return false;
			}
		}

		return true;
	}
/**
 * 
* @param board
	 *            - 2D Array of N*N dimension (Square Matrix)
	 * @param row
	 *            - row number of Array
	 * @param column
	 *            - column number of array
	 * @param dimensionOfMatrix
	 *            - dimension of square Matrix
	 * @return boolean 
	 * 			  - if nQueen problem is Solvable than it return True else False
 */
	boolean nQueen(int board[][], int row, int dimensionOfMatrix) {
		// base case: If all queens are placed then return true
		if (row >= dimensionOfMatrix) {
			return true;
		}
		// consider this row and trying to place queen in all column one by one
		for (int columnIndex = 0; columnIndex < dimensionOfMatrix; columnIndex++) {
			// check if queen can be placed on board[row][columnIndex]
			if (isSafe(board, row, columnIndex, dimensionOfMatrix)) {
				board[row][columnIndex] = 1;
				// recursion to place rest of the queens
				if (nQueen(board, row + 1, dimensionOfMatrix) == true) {
					return true;
				}
				/*
				 * if queen at board[row][column] does not lead to solution then
				 * remove the queen from board[row][column]
				 */
				board[row][columnIndex] = 0; // backtrack
			}
		}

		return false;
	}
}

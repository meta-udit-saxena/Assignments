/**
 * Implement Matrix Class as discussed in session. Write proper unit test for
 * addElements, transpose, show, multiplication methods.
 * 
 * @author Udit Saxena
 *
 */
public class Matrix {
	private int data[][]; // 2-D Array
	private int noRows; // no. of rows
	private int noCols; // no. of column

	/**
	 * Default Constructor initializing noRows & noCols
	 * 
	 * @param row
	 *            - total number of rows
	 * @param col
	 *            - total number of columns
	 */

	public Matrix(int row, int col) {
		this.noRows = row;
		this.noCols = col;
		data = new int[row][col];
	}

	/**
	 * Getter method to get private variable data
	 * 
	 * @return data - 2-D integer array
	 */
	public int[][] getData() {
		return data;
	}

	/**
	 * add value to matrix at [row][column]
	 * 
	 * @param row
	 *            - row Number
	 * @param col
	 *            - column Number
	 * @param val
	 *            - value to be added in matrix
	 */
	public void addElements(int row, int col, int val) {
		this.data[row][col] = val;
	}

	/**
	 * Perform Transpose of the matrix
	 * 
	 * @return matrix after performing transpose operation
	 */
	public Matrix transpose() {
		Matrix transposeMatrix = new Matrix(noCols, noRows);
		for (int row = 0; row < noRows; row++) {
			for (int col = 0; col < noCols; col++) {
				// interchange elements at [row][col] with elements
				// at[column][row]
				transposeMatrix.addElements(col, row, this.data[row][col]);
			}
		}

		return transposeMatrix;
	}

	/**
	 * perform matrix multiplication
	 * 
	 * @param secondMatrix
	 * @return resultMatrix
	 */

	public Matrix multiplication(Matrix secondMatrix) {
		/*
		 * number of column of first matrix is not equal to number of rows of
		 * second matrix and return null
		 */
		if (this.noCols != secondMatrix.noRows) {

			return null;
		}
		Matrix resultMatrix = new Matrix(this.noRows, secondMatrix.noCols);
		int sum;
		for (int rowIndex = 0; rowIndex < this.noRows; rowIndex++) {
			for (int columnIndex = 0; columnIndex < secondMatrix.noCols; columnIndex++) {
				sum = 0;
				for (int k = 0; k < this.noCols; k++) {
					/*
					 * first matrix Elements at [i][k] multiply with second
					 * matrix Elements at [k][j] and add the result into result
					 * matrix
					 */
					sum += this.data[rowIndex][k]
							* secondMatrix.data[k][columnIndex];
					resultMatrix.addElements(rowIndex, columnIndex, sum);
				}
			}
		}

		return resultMatrix;
	}

	/**
	 * Return String Containing Matrix
	 * 
	 * @return display - Matrix in the form of String
	 */
	public String show() {
		String display = "";
		for (int row = 0; row < noRows; row++) {
			for (int col = 0; col < noCols; col++) {
				display += data[row][col] + " ";
			}
			display += "\n";
		}
		return display;
	}

}

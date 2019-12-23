package class_03;

import java.util.ArrayList;
import java.util.List;

/**
 * 螺旋矩阵
 * 
 * @author Administrator
 *
 */
public class Code_06_PrintMatrixSpiralOrder {

	public static void spiralOrderPrint(int[][] matrix) {
		int tR = 0;
		int tC = 0;
		int dR = matrix.length - 1;
		int dC = matrix[0].length - 1;
		while (tR <= dR && tC <= dC) {
			printEdge(matrix, tR++, tC++, dR--, dC--);
		}
	}

	public static void printEdge(int[][] m, int tR, int tC, int dR, int dC) {
		if (tR == dR) {
			for (int i = tC; i <= dC; i++) {
				System.out.print(m[tR][i] + " ");
			}
		} else if (tC == dC) {
			for (int i = tR; i <= dR; i++) {
				System.out.print(m[i][tC] + " ");
			}
		} else {
			int curC = tC;
			int curR = tR;
			while (curC != dC) {
				System.out.print(m[tR][curC] + " ");
				curC++;
			}
			while (curR != dR) {
				System.out.print(m[curR][dC] + " ");
				curR++;
			}
			while (curC != tC) {
				System.out.print(m[dR][curC] + " ");
				curC--;
			}
			while (curR != tR) {
				System.out.print(m[curR][tC] + " ");
				curR--;
			}
		}
	}

	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
		spiralOrderPrint(matrix);

	}

	// ===============我的实现=================================

	List<Integer> list = new ArrayList<Integer>();

	/**
	 * 54. 螺旋矩阵 给定一个包含 m x n 个元素的矩阵（m 行, n 列）， 请按照顺时针螺旋顺序，返回矩阵中的所有元素。
	 * 
	 * @param matrix
	 * @return
	 */
	public List<Integer> spiralOrder(int[][] matrix) {
		if (matrix == null || matrix.length == 0) {
			return list;
		}
		// 两个坐标 [a][b], [c][d]
		int a = 0, b = 0;
		int d = matrix[0].length - 1;
		int c = matrix.length - 1;
		while (a <= c && b <= d) {
			order(matrix, a++, b++, c--, d--);
		}
		return list;
	}

	private void order(int[][] matrix, int a, int b, int c, int d) {

		if (a == c) { // 一维数组
			while (b <= d) {
				list.add(matrix[a][b++]);
			}
		} else if (b == d) {
			while (a <= c) {
				list.add(matrix[a++][b]);
			}
		} else {
			int x = a, y = b;
			while (y != d) {
				list.add(matrix[a][y++]);
			}
			while (x != c) {
				list.add(matrix[x++][d]);
			}
			while (y != b) {
				list.add(matrix[c][y--]);
			}
			while (x != a) {
				list.add(matrix[x--][b]);
			}
		}

	}

	/**
	 * 59. 螺旋矩阵 II 给定一个正整数 n，生成一个包含 1 到 n*n所有元素， 且元素按顺时针顺序螺旋排列的正方形矩阵。
	 * 
	 * @param n
	 * @return
	 */
	int index = 1;
	public int[][] generateMatrix(int n) {
		int[][] matrix = new int[n][n];
		// 两个坐标 [a][b], [c][d]
		int a = 0, b = 0;
		int d = n - 1;
		int c = n - 1;
		while (a <= c && b <= d) {
			order(matrix, n, a++, b++, c--, d--);
		}
		return matrix;
	}
	
	private void order(int[][] matrix, int n, int a, int b, int c, int d) {
		if (a == c) { 
			matrix[a][a] = n*n;
		} else {
			int x = a, y = b;
			while (y != d) {
				matrix[a][y++] = index++;
			}
			while (x != c) {
				matrix[x++][d] = index++;
			}
			while (y != b) {
				matrix[c][y--] = index++;
			}
			while (x != a) {
				matrix[x--][b] = index++;
			}
		}
	}

}

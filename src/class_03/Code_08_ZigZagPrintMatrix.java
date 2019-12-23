package class_03;

/**
 * “之”字形打印矩阵
	【题目】 给定一个矩阵matrix，按照“之”字形的方式打印这个矩阵，
	例如： 1  2  3  4 
		 5  6  7  8
		 9  10 11 12
	“之”字形打印的结果为：1，2，5，9，6，3，4，7，10，11，
 * @author Administrator
 *
 */
public class Code_08_ZigZagPrintMatrix {

	public static void printMatrixZigZag(int[][] matrix) {
		int tR = 0;
		int tC = 0;
		int dR = 0;
		int dC = 0;
		int endR = matrix.length - 1;
		int endC = matrix[0].length - 1;
		boolean fromUp = false;
		while (tR != endR + 1) {
			printLevel(matrix, tR, tC, dR, dC, fromUp);
			tR = tC == endC ? tR + 1 : tR;
			tC = tC == endC ? tC : tC + 1;
			dC = dR == endR ? dC + 1 : dC;
			dR = dR == endR ? dR : dR + 1;
			fromUp = !fromUp;
		}
		System.out.println();
	}

	public static void printLevel(int[][] m, int tR, int tC, int dR, int dC,
			boolean f) {
		if (f) {
			while (tR != dR + 1) {
				System.out.print(m[tR++][tC--] + " ");
			}
		} else {
			while (dR != tR - 1) {
				System.out.print(m[dR--][dC++] + " ");
			}
		}
	}

	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
		printMatrixZigZag(matrix);
		String s = "PAYPALISHIRING";
		int n = 3;
		System.out.println(convert(s, n));

	}

	/**
	 * 6. Z 字形变换
	 * @param s
	 * @param numRows
	 * @return
	 */
	public static String convert(String s, int numRows) {
		
		StringBuffer res = new StringBuffer() ;
		if(s.isEmpty() || numRows < 1) return res.toString();
        if(numRows == 1) return s;
		
		int len = Math.min(s.length(), numRows);
		StringBuffer[] temp = new StringBuffer[len];
		for(int i = 0; i < temp.length; i++){
	           temp[i] = new StringBuffer();
	    }
        
        for(int i = 0; i < s.length(); i++){
            int ans = i / (numRows-1);
            int cur = i % (numRows-1);
            if(ans % 2 == 0){  //结果为偶数或0, 从上到下
                temp[cur].append(s.charAt(i)); //按余数正序保存
            }
            if(ans % 2 != 0){  //结果为奇数，从下到上
                temp[numRows-cur-1].append(s.charAt(i)); //按余数倒序保存
            }
        }
	    for(int i = 0; i < temp.length; i++){
	           res.append(temp[i]);
	    }
        return res.toString();
	}
}

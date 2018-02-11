package date0828;

/**
 * ��������ת��
 * 
 * @author CSH
 * @date 2018��6��26������11:37:09
 */
public class Matrix {

	public static void main(String[] args) {
		double[][] TestMatrix = { { 1, 22, 34, 22 }, { 1, 11, 5, 21 }, { 7, 2, 13, 19 } };
		double[][] MatrixC = Transpose(TestMatrix, 3, 4);

		System.out.println("-------ת��ǰ---------");
		myPrint(TestMatrix);
		System.out.println("-------ת�ú�---------");
		myPrint(MatrixC);
	}

	public static double[][] Transpose(double[][] Matrix, int Line, int List) {
		double[][] MatrixC = new double[List][Line];
		for (int i = 0; i < Line; i++) {
			for (int j = 0; j < List; j++) {
				MatrixC[j][i] = Matrix[i][j];
			}
		}
		return MatrixC;
	}

	public static void myPrint(double temp[][]) {
		for (int i = 0; i < temp.length; i++) {
			for (int j = 0; j < temp[i].length; j++) {
				System.out.print(temp[i][j] + "\t");
			}
			System.out.println();
		}
	}
}

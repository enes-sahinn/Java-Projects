package lab10;

public class Main {

	public static void main(String[] args) {
		int[][] matrix1 = {{55,0,0,0,0},{0,55,0,0,0},{0,0,55,0,0},{0,0,0,55,0},{0,0,0,0,55}};
		int[][] matrix2 = {{18,0,0,0},{0,18,0,0},{0,0,18,0},{0,0,0,18}};
		int[][] matrix3 = {{6,0,0,0,0,0},{0,6,0,0,0,0},{0,0,6,0,0,5},{0,0,0,6,0,0},{0,0,0,0,6,0},{0,0,0,0,0,6}};
		int[][] matrix4 = {{6,0,0,0,0,0},{0,6,0,0,0,0},{0,0,6,0,0,0},{0,0,0,6,0,0},{0,0,0,0,7,0},{0,0,0,0,0,6}};

		MultiLinkedList mll1 = new MultiLinkedList();   // Definitions
		mll1 = matrixToMll(matrix1);
		MultiLinkedList mll2 = new MultiLinkedList();
		mll2 = matrixToMll(matrix2);
		MultiLinkedList mll3 = new MultiLinkedList();
		mll3 = matrixToMll(matrix3);
		MultiLinkedList mll4 = new MultiLinkedList();
		mll4 = matrixToMll(matrix4);
		
		System.out.println("----------MATRÝX-1----------\n");   // Printing part
		mll1.display();
		System.out.println("\n" + mll1.isScalarMatrix());
		System.out.println("\n----------MATRÝX-2----------\n");
		mll2.display();
		System.out.println("\n" + mll2.isScalarMatrix());
		System.out.println("\n----------MATRÝX-3----------\n");
		mll3.display();
		System.out.println("\n" + mll3.isScalarMatrix());
		System.out.println("\n----------MATRÝX-4----------\n");
		mll4.display();
		System.out.println("\n" + mll4.isScalarMatrix());
	}
	
	public static MultiLinkedList matrixToMll(int[][] array) {   // Function to construct a MLL from array
		MultiLinkedList mll = new MultiLinkedList();
		for (int i = 0; i < array.length; i++) {
			mll.addRowNumber(i);
			for (int j = 0; j < array[i].length; j++) {
				mll.addRowElement(i, array[i][j]);
			}
		}
		return mll;
	}
}


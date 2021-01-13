package ch.sparse_array;

import lombok.val;

public class Main {

    public static void main(String[] args) {
        Integer[][] chessArray1 = new Integer[11][11];
        chessArray1[1][2] = 1;
        chessArray1[2][3] = 2;
        chessArray1[4][5] = 3;

        val sparseArray = new SparseArray(chessArray1);

        System.out.println();
        sparseArray.print();
        System.out.println();

        Integer[][] chessArray2 = sparseArray.x();

        for (int i = 0; i < chessArray2.length; i++) {
            for (int j = 0; j < chessArray2[i].length; j++) {
                System.out.printf("%d\t", chessArray2[i][j]);
            }
            System.out.println();
        }
    }

}

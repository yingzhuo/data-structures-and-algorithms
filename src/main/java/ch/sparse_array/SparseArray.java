package ch.sparse_array;

import java.util.Objects;

public class SparseArray {

    private final Integer[][] sparseArray;
    private final Integer defaultValue;

    public SparseArray(Integer[][] ordinaryArray) {
        this(ordinaryArray, 0);
    }

    public SparseArray(Integer[][] ordinaryArray, Integer defaultValue) {

        this.defaultValue = defaultValue;

        int row = ordinaryArray.length;

        if (row == 0) {
            throw new IllegalArgumentException();
        }

        int col = ordinaryArray[0].length;
        int sum = 0;

        for (int i = 0; i < ordinaryArray.length; i++) {
            for (int j = 0; j < ordinaryArray[i].length; j++) {
                Integer current = ordinaryArray[i][j];
                if (current == null) {
                    current = defaultValue;
                }
                if (!Objects.equals(current, defaultValue)) {
                    sum++;
                }
            }
        }

        this.sparseArray = new Integer[sum + 1][3];
        this.sparseArray[0][0] = row;
        this.sparseArray[0][1] = col;
        this.sparseArray[0][2] = sum;

        int idx = 1;
        for (int i = 0; i < ordinaryArray.length; i++) {
            for (int j = 0; j < ordinaryArray[i].length; j++) {
                Integer current = ordinaryArray[i][j];
                if (current == null) {
                    current = defaultValue;
                }
                if (!Objects.equals(current, defaultValue)) {
                    this.sparseArray[idx][0] = i;
                    this.sparseArray[idx][1] = j;
                    this.sparseArray[idx][2] = ordinaryArray[i][j];
                    idx++;
                }
            }
        }
    }

    public void print() {
        for (int i = 0; i < this.sparseArray.length; i++) {
            for (int j = 0; j < 3; j++) {
                Integer current = this.sparseArray[i][j];
                if (current == null) {
                    current = defaultValue;
                }
                System.out.printf("%d\t", current);
            }
            System.out.println();
        }
    }

    // 解压缩
    public Integer[][] x() {
        Integer[][] array = new Integer[this.sparseArray[0][0]][this.sparseArray[0][1]];

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = defaultValue;
            }
        }

        for (int i = 1; i < this.sparseArray.length; i++) {
            array[this.sparseArray[i][0]][this.sparseArray[i][1]] = this.sparseArray[i][2];
        }
        return array;
    }

}

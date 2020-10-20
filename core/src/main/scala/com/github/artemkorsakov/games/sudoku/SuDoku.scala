package com.github.artemkorsakov.games.sudoku

class SuDoku {

}

/*
package com.github.artemkorsakov.games.sudoku;

import java.util.Arrays;

public class SuDoku {
    private static final int[] NUMBERS = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
    private int[][][] cells = new int[9][9][9];

    public SuDoku() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                cells[i][j] = NUMBERS;
            }
        }
    }

    public SuDoku(String source) {
        this();
        String[] rows = source.split("\\n");
        for (int i = 0; i < rows.length; i++) {
            for (int j = 0; j < rows[i].length(); j++) {
                int d = Character.getNumericValue(rows[i].charAt(j));
                if (d > 0 && !setValue(i, j, d)) {
                    throw new IllegalArgumentException();
                }
            }
        }

        searchResult();
    }

    public int[][] getResult() {
        if (isFail()) {
            return new int[cells.length][cells[0].length];
        }

        return Arrays.stream(cells).map(row -> Arrays.stream(row).mapToInt(ce -> ce[0]).toArray()).toArray(int[][]::new);
    }

    private void searchResult() {
        boolean hasToRemove = true;
        while (isFail() && hasToRemove) {
            hasToRemove = false;
            for (int i = 0; i < cells.length; i++) {
                for (int j = 0; j < cells[i].length; j++) {
                    if (cells[i][j].length == 1) {
                        continue;
                    }

                    for (int k = 0; k < cells[i][j].length; k++) {
                        if (setValueWithoutChanges(i, j, cells[i][j][k])) {
                            continue;
                        }

                        hasToRemove = true;
                        boolean result = removeValue(i, j, cells[i][j][k]);
                        if (!result) {
                            throw new IllegalArgumentException();
                        }
                    }
                }
            }
        }

        if (isFail()) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isFail() {
        return Arrays.stream(cells).anyMatch(row -> Arrays.stream(row).anyMatch(r -> r.length != 1));
    }

    /**
     * Set the specified value in the specified field.
     */
    private boolean setValue(int i, int j, int value) {
        int[][][] tempRows = saveCell();
        cells[i][j] = new int[]{value};
        boolean result = removeValueFromRowColSqr(i, j, value);
        if (result) {
            return true;
        }
        cells = tempRows;
        return false;
    }

    /**
     * Set the specified value in the specified field but then return to the previous state of the cells regardless of the result.
     */
    private boolean setValueWithoutChanges(int i, int j, int value) {
        int[][][] tempRows = saveCell();
        cells[i][j] = new int[]{value};
        boolean result = removeValueFromRowColSqr(i, j, value) && isValid();
        cells = tempRows;
        return result;
    }

    private boolean isValid() {
        // Check that each row contains digits from 1 to 9 at least once
        for (int[][] row : cells) {
            if (Arrays.stream(NUMBERS).anyMatch(n -> Arrays.stream(row).allMatch(c -> Arrays.stream(c).allMatch(v -> v != n)))) {
                return false;
            }
        }

        // Check that each column contains digits from 1 to 9 at least once
        for (int i = 0; i < cells[0].length; i++) {
            int finalI = i;
            if (Arrays.stream(NUMBERS).anyMatch(n -> Arrays.stream(cells).map(col -> col[finalI]).allMatch(c -> Arrays.stream(c).allMatch(v -> v != n)))) {
                return false;
            }
        }

        return true;
    }

    /**
     * Removes a given value from the row, column, and square to which the point belongs.
     */
    private boolean removeValueFromRowColSqr(int i, int j, int value) {
        // Removes a given value from the row
        for (int c = 0; c < 9; c++) {
            if (c != j && !removeValue(i, c, value)) {
                return false;
            }
        }

        // Removes a given value from the column
        for (int r = 0; r < 9; r++) {
            if (r != i && !removeValue(r, j, value)) {
                return false;
            }
        }

        // Removes a given value from the square
        for (int k = 0; k < 3; k++) {
            for (int l = 0; l < 3; l++) {
                int r = (i / 3) * 3 + k;
                int c = (j / 3) * 3 + l;
                if ((r != i || c != j) && !removeValue(r, c, value)) {
                    return false;
                }
            }
        }

        return true;
    }

    /**
     * Removes a given value from the cell
     */
    private boolean removeValue(int i, int j, int value) {
        if (cells[i][j].length == 1) {
            return cells[i][j][0] != value;
        }

        cells[i][j] = Arrays.stream(cells[i][j]).filter(value1 -> value1 != value).toArray();
        return cells[i][j].length != 1 || setValue(i, j, cells[i][j][0]);
    }

    private int[][][] saveCell() {
        int[][][] tempRows = new int[cells.length][][];
        for (int k = 0; k < cells.length; k++) {
            int[][] tempColumn = new int[cells[k].length][];
            for (int l = 0; l < cells[k].length; l++) {
                int[] temp = new int[cells[k][l].length];
                System.arraycopy(cells[k][l], 0, temp, 0, cells[k][l].length);
                tempColumn[l] = temp;
            }
            tempRows[k] = tempColumn;
        }
        return tempRows;
    }
}

 */

import java.util.*;

public class sudoku {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter sudoku values: ");
        int[][] sudoku = new int[9][9];
        for (int i = 0; i < sudoku.length; i++) {
            for (int j = 0; j < sudoku.length; j++) {
                sudoku[i][j] = in.nextInt();
            }
        }
        System.out.println();
        if (solvethesudoku(sudoku, 0, 0)) {
            System.out.println("SOLVED!!");
            for (int i = 0; i < sudoku.length; i++) {
                for (int j = 0; j < sudoku.length; j++) {
                    System.out.print(sudoku[i][j] + ", ");
                }
                System.out.println();
            }
        } else {
            System.out.println("NO SOLUTION");
        }

    }

    private static boolean 
    solvethesudoku(int[][] sudoku, int row, int col) {
        if (row == 8 && col == 9)
            return true;

        if (col == 9) {
            row = row + 1;
            col = 0;
        }
        if (sudoku[row][col] > 0)
            return solvethesudoku(sudoku, row, col + 1);

        for (int i = 1; i <= 9; i++) {

            if (safetoproceed(sudoku, row, col, i)) {
                sudoku[row][col] = i;

                if (solvethesudoku(sudoku, row, col + 1)) {
                    return true;
                }
            }
            sudoku[row][col] = 0;
        }
        return false;
    }

    private static boolean safetoproceed(int[][] sudoku, int row, int col, int num) {
        if (checkrow(sudoku, row, num) && checkcol(sudoku, col, num) && checkthatgrid(sudoku, row, col, num))
            return true;
        else
            return false;
    }

    private static boolean checkthatgrid(int[][] sudoku, int row, int col, int num) {
        int srow = row - row % 3;
        int scol = col - col % 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (sudoku[i + srow][j + scol] == num) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean checkcol(int[][] sudoku, int col, int num) {
        for (int i = 0; i < sudoku.length; i++) {
            if (sudoku[i][col] == num)
                return false;
        }
        return true;
    }

    private static boolean checkrow(int[][] sudoku, int row, int num) {
        for (int i = 0; i < sudoku.length; i++) {
            if (sudoku[row][i] == num)
                return false;
        }
        return true;
    }
}

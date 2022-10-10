import java.util.Scanner;

public class nqueens {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter size of board: ");
        int size = in.nextInt();
        int board[][] =  new int[size][size];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                board[i][j] = 0;
            }
        }
        //printboard(board);
        int ans = solvenqueen(board,0);
        if(ans==1){
            printboard(board);
        }
        else{
            System.out.println("Solution do not exist.");
        }
    }

    private static int solvenqueen(int[][] mat, int column) {
        int n = mat.length;
        if(column >= n){
            return 1;
        }
        for (int i = 0; i < n; i++) {

            if(checkpositionleft(mat, i, column) && checkpositiondll(mat, i, column) && checkpositiondlu(mat, i, column)){
                mat[i][column] = 1;
                if(solvenqueen(mat,column+1)==1)
                return 1;
                mat[i][column] = 0;
            }
        }
        return 0;
    }
    private static boolean checkpositionleft(int[][] mat, int row, int column){
        for (int i = 0; i < column; i++){
            if (mat[row][i] == 1){
                return false;
            }
        }
        return true;
    }

    private static boolean checkpositiondlu(int[][] mat, int row, int column) { 
        int i = row, j = column;
        while ( i >= 0 && j >= 0){
            if (mat[i][j] == 1)
                return false;
            i--;
            j--;
        }
            
        return true;        
    }
    private static boolean checkpositiondll(int[][] mat, int row, int column){
        int i = row, j = column;
        while( j >= 0 && i < mat.length){
            if (mat[i][j] == 1)
                return false;
            i++; j--;
        }
        return true;
    }
    private static void printboard(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }
}

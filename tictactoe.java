import java.util.Scanner;

public class tictactoe {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        char[][] TicTacToe = new char[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                TicTacToe[i][j] = '-';
            }
        }

        System.out.println("Let's play Tic Tac Toe!");
        System.out.print("Player 1, Name Please!: ");
        String p1 = in.nextLine();
        System.out.print("Player 2, Name Please!: ");
        String p2 = in.nextLine();
        boolean player1 = true;
        char c1 = '-';
        char c2 = '-';
        System.out.println(p1 + ", Choose X or O");
        c1 = in.next().charAt(0);
        if (c1 == 'X') {
            c2 = 'O';
        } else {
            c2 = 'X';
        }
        boolean Overnow = false;
        while (!Overnow) {
            printBoard(TicTacToe);
            if (player1) {
                System.out.println(p1 + "'s turn(" + c1 + ") ");
            } else {
                System.out.println(p2 + "'s turn(" + c2 + ") ");
            }

            int row = 0;
            int col = 0;
            while (true) {

                System.out.print("Enter a row number from 0 to 2: ");
                row = in.nextInt();
                System.out.print("Enter a column number from 0 to 2: ");
                col = in.nextInt();
                if (row < 0 || col < 0 || row > 2 || col > 2) {
                    System.out.println("This position is not available. Try again!!.");
                } else if (TicTacToe[row][col] != '-') {
                    System.out.println("Position filled! Try again.");
                } else {
                    break;
                }

            }
            if(player1)
            TicTacToe[row][col] = c1;
            else
            TicTacToe[row][col] = c2;
            if (Winner(TicTacToe) == c1) {
                System.out.println(p1 + " has won!");
                Overnow = true;
            } else if (Winner(TicTacToe) == c2) {
                System.out.println(p2 + " has won!");
                Overnow = true;
            } else {
                if (ItsaTie(TicTacToe)) {
                    System.out.println("It's a tie!");
                    Overnow = true;
                } else {
                    player1 = !player1;
                }

            }

        }
        printBoard(TicTacToe);

    }

    public static void printBoard(char[][] TicTacToe) {
        System.out.println("TicTacToe:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(TicTacToe[i][j]);
            }
            System.out.println();
        }
    }
    public static char Winner(char[][] TicTacToe) {

        for (int i = 0; i < 3; i++) {
            if (TicTacToe[i][0] == TicTacToe[i][1] && TicTacToe[i][1] == TicTacToe[i][2] && TicTacToe[i][0] != '-') {
                return TicTacToe[i][0];
            }
        }
        for (int j = 0; j < 3; j++) {
            if (TicTacToe[0][j] == TicTacToe[1][j] && TicTacToe[1][j] == TicTacToe[2][j] && TicTacToe[0][j] != '-') {
                return TicTacToe[0][j];
            }
        }
        if (TicTacToe[0][0] == TicTacToe[1][1] && TicTacToe[1][1] == TicTacToe[2][2] && TicTacToe[0][0] != '-') {
            return TicTacToe[0][0];
        }
        if (TicTacToe[2][0] == TicTacToe[1][1] && TicTacToe[1][1] == TicTacToe[0][2] && TicTacToe[2][0] != '-') {
            return TicTacToe[2][0];
        }
        return ' ';

    }
    public static boolean ItsaTie(char[][] TicTacToe) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (TicTacToe[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }
}

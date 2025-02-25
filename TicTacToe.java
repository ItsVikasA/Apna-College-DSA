import java.util.Scanner;
public class TicTacToe{
    static char[][] board =  {
        {'1', '2', '3'},
        {'4', '5', '6'},
        {'7', '8', '9'}
    };
    
    static char currentPlayer = 'X';

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int move;
        
        System.out.println("Welcome to Tic-Tac-Toe!");
        printBoard();
        
        while (true) {
            System.out.print("Player " + currentPlayer + ", enter your move (1-9): ");
            move = scanner.nextInt();
            
            if (!isValidMove(move)) {
                System.out.println("Invalid move! Try again.");
                continue;
            }

            makeMove(move);
            printBoard();
            
            if (checkWin()) {
                System.out.println("Player " + currentPlayer + " wins!");
                break;
            }
            
            if (isBoardFull()) {
                System.out.println("It's a tie!");
                break;
            }
            
            switchPlayer();
        }
        scanner.close();
    }

    // Print the Tic-Tac-Toe board
    static void printBoard() {
        System.out.println("-------------");
        for (char[] row : board) {
            System.out.print("| ");
            for (char cell : row) {
                System.out.print(cell + " | ");
            }
            System.out.println("\n-------------");
        }
    }

    // Check if the move is valid
    static boolean isValidMove(int move) {
        if (move < 1 || move > 9) return false;
        
        int row = (move - 1) / 3;
        int col = (move - 1) % 3;

        return board[row][col] != 'X' && board[row][col] != 'O';
    }

    // Make a move on the board
    static void makeMove(int move) {
        int row = (move - 1) / 3;
        int col = (move - 1) % 3;
        board[row][col] = currentPlayer;
    }

    // Switch players
    static void switchPlayer() {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }

    // Check for a winning condition
    static boolean checkWin() {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2] == currentPlayer) return true;
            if (board[0][i] == currentPlayer && board[1][i] == currentPlayer && board[2][i] == currentPlayer) return true;
        }
        return (board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer) ||
               (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer);
    }

    // Check if the board is full (tie game)
    static boolean isBoardFull() {
        for (char[] row : board) {
            for (char cell : row) {
                if (cell != 'X' && cell != 'O') return false;
            }
        }
        return true;
    }
}
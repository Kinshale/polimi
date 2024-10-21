import java.util.Scanner;
import java.util.Random;

public class TicTacToe {
    private static char[] board = {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '};
    private static int movesMade = 0;
    private static Scanner sn = new Scanner(System.in);

    public static void main(String[] args) {
        
        System.out.println("Game started. Good luck!");        
        printBoard();
        
        while (true){
            
            userTurn();
            if (movesMade >= 5 && isWinner()){
                System.out.println("You won. Congratulation!");
                break;
            }

            if(movesMade == 9){
                System.out.println("It's a draw!");
                break;
            }

            computerTurn();
            if (movesMade >= 6 && isWinner()){
                System.out.println("You lost.");
                break;
            }
        }

        printBoard();
        sn.close();
    }

    public static void userTurn(){
        int cell = -1;
        
        while (cell < 0 || cell > 8 || board[cell] != ' ') {
            System.out.println("Where do you want to play? (1-9):");
            while (!sn.hasNextInt()) {  
                System.out.println("Invalid input. Please enter a number between 1 and 9.");
                sn.next();  
            }
            cell = sn.nextInt() - 1; 
            if (cell < 0 || cell > 8) {
                System.out.println("Invalid input. Please enter a number between 1 and 9.");
            } else if (board[cell] != ' ') {
                System.out.println("Cell not empty. Choose another cell.");
            }
        }

        board[cell] = 'X';
        movesMade++;
    }

    public static void computerTurn(){
        int cell = -1;
        Random random = new Random(); 
        while (cell == -1 || board[cell] != ' ')
            cell = random.nextInt(9);
        board[cell] = 'O';

        movesMade++;
        printBoard();
    }

    public static boolean isWinner() {
        int[][] winningCombos = {
            {0, 1, 2}, {3, 4, 5}, {6, 7, 8},  
            {0, 3, 6}, {1, 4, 7}, {2, 5, 8},  
            {0, 4, 8}, {2, 4, 6}              
        };
        
        for (int[] combo : winningCombos) {
            if (board[combo[0]] == board[combo[1]] && 
                board[combo[1]] == board[combo[2]] && 
                board[combo[0]] != ' ') {
                return true;
            }
        }
        return false;
    }

    public static void printBoard() {
        System.out.println();
        System.out.println(" " + board[0] + " | " + board[1] + " | " + board[2]);
        System.out.println("---+---+---");
        System.out.println(" " + board[3] + " | " + board[4] + " | " + board[5]);
        System.out.println("---+---+---");
        System.out.println(" " + board[6] + " | " + board[7] + " | " + board[8]);
        System.out.println();
    }
}



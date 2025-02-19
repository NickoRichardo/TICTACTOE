package TicTacToeGame;
import java.util.*;

class TicTacToeGames {
    private Board board;
    private Player player1, player2;
    private Scanner scanner;
    
    public TicTacToeGames() {
        scanner = new Scanner(System.in);
        board = new Board();
        player1 = new Player("Player 1", 'O');
        player2 = new Player("Player 2", 'X');
        playGame();
    }
    
    private void playGame() {
        Player currentPlayer = player1;
        
        while (true) {
            board.printBoard();
            System.out.println(currentPlayer.getName() + " [" + currentPlayer.getSymbol() + "]");
            
            int row, col;
            while (true) {
                System.out.print("Input Koordinat 1 [1-3]: ");
                row = scanner.nextInt() - 1;
                System.out.print("Input Koordinat 2 [1-3]: ");
                col = scanner.nextInt() - 1;
                
                if (board.placeMove(row, col, currentPlayer.getSymbol())) {
                    break;
                } else {
                    System.out.println("Koordinat tidak valid atau sudah terisi! Coba lagi.");
                }
            }
            
            if (board.checkWin(currentPlayer.getSymbol())) {
                board.printBoard();
                System.out.println(currentPlayer.getName() + " menang!");
                return;
            }
            
            if (board.isBoardFull()) {
                board.printBoard();
                System.out.println("Permainan seri!");
                return;
            }
            
            currentPlayer = (currentPlayer == player1) ? player2 : player1;
        }
    }
}
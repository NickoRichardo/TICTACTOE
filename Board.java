package TicTacToeGame;

class Board {
    private char[][] kor;
    
    public Board() {
        kor = new char[3][3];
        initializeBoard();
    }
    
    public void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                kor[i][j] = ' ';
            }
        }
    }
    
    public void printBoard() {
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print("| " + kor[i][j] + " ");
            }
            System.out.println("|");
            System.out.println("-------------");
        }
    }
    
    public boolean placeMove(int row, int col, char player) {
        if (row >= 0 && row < 3 && col >= 0 && col < 3 && kor[row][col] == ' ') {
            kor[row][col] = player;
            return true;
        }
        return false;
    }
    
    public boolean checkWin(char player) {
        for (int i = 0; i < 3; i++) {
            if ((kor[i][0] == player && kor[i][1] == player && kor[i][2] == player) ||
                (kor[0][i] == player && kor[1][i] == player && kor[2][i] == player)) {
                return true;
            }
        }
        return (kor[0][0] == player && kor[1][1] == player && kor[2][2] == player) ||
               (kor[2][0] == player && kor[1][1] == player && kor[0][2] == player);
    }
    
    public boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (kor[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
}
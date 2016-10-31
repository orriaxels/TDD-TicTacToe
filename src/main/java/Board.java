package ttt;

public class Board {
    public char[][] board;

    Board() {
        board = new char[3][3];
        initializeBoard();
    }

    public void initializeBoard() {
        for(int row = 0; row < 3; row++) {
            for(int col = 0; col < 3; col++)
                board[row][col] = '*';
        }
    }

    //1,4,7 return 1
    //2,5,8 return 2
    //3,6,9 return 3
    public int getCol(int pos) {
        return pos % 3;
    }

    //1,2,3 return 1
    //4,5,6 return 2
    //7,8,9 return 3
    public int getRow(int pos) {
        return pos / 3;
    }



    public static void main(String[] args) {

    }
}

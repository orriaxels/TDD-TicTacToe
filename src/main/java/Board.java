package ttt;

public class Board {
    public char[][] cells;
    public Character mark;

    Board() {
        cells = new char[3][3];
        initializeBoard();
        mark = new Character('X');
    }

    public void initializeBoard() {
        for(int row = 0; row < 3; row++) {
            for(int col = 0; col < 3; col++)
                cells[row][col] = '*';
        }
    }

    //0,3,6 return 0
    //1,4,7 return 1
    //2,5,8 return 2
    public int getCol(int pos) {
        return pos % 3;
    }

    //0,1,2 return 0
    //3,4,5 return 1
    //6,7,8 return 2
    public int getRow(int pos) {
        return pos / 3;
    }

    //Checks if the cell contains
    public boolean isEmpty(int pos) {
        return cells[getRow(pos)][getCol(pos)] == '*';
    }

    //Prints the board contents out as a string, appends isOver value.
    public String stringifyBoard() {
        String boardString = "";

        for(int row = 0; row < 3; row++) {
            for(int col = 0; col < 3; col++)
                boardString += String.valueOf(cells[row][col]);
        }

        if(boardString.length() != 9)
            boardString = boardString.substring(0, 9);

        boardString += isOver();

        return boardString;
    }

    //Puts the players mark in the cell, if the cell was empty
    public void MOCKupdateCell(int pos, char mark) {
        if(isEmpty(pos))
            cells[getRow(pos)][getCol(pos)] = mark;

        stringifyBoard();
    }

    //Puts the players mark in the cell, if the cell was empty
    public void updateCell(int pos) {
        if(isEmpty(pos) && isOver() == 0) {
            cells[getRow(pos)][getCol(pos)] = mark;

        if(mark == 'X')
            mark = 'O';
        else
            mark = 'X';
        }

        stringifyBoard();
    }

    //Checks if there are no free cells available.
    public boolean isDraw() {
		for(int pos = 0; pos < 9; pos++)
			if(isEmpty(pos))
				return false;

		return true;
    }

    //Checks if there is a horizontalWin.
    public int horizontalWin() {
        for(int row = 0; row < 3; row++) {
            if(cells[row][0] != '*' && cells[row][0] == cells[row][1] && cells[row][1] == cells[row][2]) {
                if(cells[row][0] == 'X')
                    return 1;
                else
                    return 2;
            }
        }
        return 0;
    }

    //Checks if there is a verticalWin.
    public int verticalWin() {
        for(int col = 0; col < 3; col++) {
            if(cells[0][col] != '*' && cells[0][col] == cells[1][col] && cells[1][col] == cells[2][col]) {
                if(cells[0][col] == 'X')
                    return 1;
                else
                    return 2;
            }
        }
        return 0;
    }

    //Checks if there is a crossWin.
    public int crossWin() {
        if(cells[1][1] != '*' && cells[0][0] == cells[1][1] && cells[1][1] == cells[2][2]) {
            if(cells[1][1] == 'X')
                return 1;
            else
                return 2;
        }

        if(cells[1][1] != '*' && cells[0][2] == cells[1][1] && cells[1][1] == cells[2][0]) {
            if(cells[1][1] == 'X')
                return 1;
            else
                return 2;
        }
        return 0;
    }

    //Checks if the game is over.
    public int isOver() {
        int hor = horizontalWin();
        if(hor != 0)
            return hor;

        int ver = verticalWin();
        if(ver!= 0)
            return ver;

        int cross = crossWin();
        if(cross != 0)
            return cross;

        if(isDraw())
            return 3;

        return 0;
    }

    public static void main(String[] args) {

    }
}

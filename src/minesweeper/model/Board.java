package minesweeper.model;

import java.util.Random;

public class Board {
    private Tile[][] board;
    private int rows, cols;
    private int mineCount;
    private int chosenMineCount;

    public Board(int x, int y, int mineCount) {
        board = new Tile[x][y];
        this.rows = x;
        this.cols = y;
        this.mineCount = mineCount;
        this.chosenMineCount = mineCount;
        initializeBoard();
    }

    private void initializeBoard() {
        //Flip board with empty tiles
        for(int i=0; i<rows; i++) {
            for(int j=0; j<cols; j++) {
                board[i][j] = new Tile(Status.EMPTY);
            }
        }
        
        //add -mineCount- random bombs
        Random r = new Random();
        int row = r.nextInt(rows);
        int col = r.nextInt(cols);
        for(int i=0; i<mineCount; i++) {
            while(board[row][col].getStatus() == Status.BOMB) {
                row = r.nextInt(rows);
                col = r.nextInt(cols);
            }
            board[row][col].setStatus(Status.BOMB);
            System.err.println("Bomb added on Coordinates ("+row+","+col+")");
        }
        
        //increment the bombcount of surrounding Tiles
        if(col < cols-1) {                      //niet tegen rechterkant
            board[row][col+1].incBombCount();
        }
        if(col > 0) {                           //niet tegen linkerkant
            board[row][col-1].incBombCount();
        }
        if(row < rows-1) {                      //niet tegen onderkant
            board[row+1][col].incBombCount();
        }
        if(row > 0) {                           //niet tegen bovenkant
            board[row-1][col].incBombCount();
        }
        if(row > 0 && col > 0) {                //niet in linkerbovenhoek
            board[row-1][col-1].incBombCount();
        }
        if(row > 0 && col < cols-1) {           //niet in rechterbovenhoek
            board[row-1][col+1].incBombCount();
        }
        if(row < rows-1 && col > 0) {           //niet in linkeronderhoek
            board[row+1][col-1].incBombCount();
        }
        if(row < rows-1 && col < cols-1) {      //niet in rechteronderhoek
            board[row+1][col+1].incBombCount();
        }
    }
    
    private Status getTileStatus(int x, int y) {
        return board[x][y].getStatus();
    }
    
    private void setTileStatus(int x, int y, Status status) {
        board[x][y].setStatus(status);
    }
    
    private int getBombCount(int x, int y) {
        return board[x][y].getBombCount();
    }
}
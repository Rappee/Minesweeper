package minesweeper.model;

public class Tile {
    private Status status;
    private boolean marked;
    private int bombCount;

    public Tile(Status status) {
        this.status = status;
        this.marked = false;
        this.bombCount = 0;
    }
    
    // Getters and Setters

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public boolean isMarked() {
        return marked;
    }

    public void setMarked(boolean marked) {
        this.marked = marked;
    }

    public int getBombCount() {
        return bombCount;
    }

    public void setBombCount(int bombCount) {
        this.bombCount = bombCount;
    }
    
    public void incBombCount() {
        this.bombCount++;
    }
    
}

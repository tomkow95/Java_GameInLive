package sample.domain;

public class Board {

    private int width;
    private int height;
    private Cell[][] cells;

    public Board(int width, int height) {
        this.width = width;
        this.height = height;
        cells = new Cell[this.width][this.height];
        resetBoard();
    }

    private void resetBoard() {
        for (int i = 0; i < this.width; i++)
            for (int j = 0; j < this.height; j++){
                cells[i][j] = new Cell(false);
            }
    }

    public void setCellValue(int x, int y, Boolean value){
        if(x > 0 && x < this.width && y > 0 && x < this.height){
            cells[x][y].setLive(value);
        }else {
            throw new IndexOutOfBoundsException();
        }
    }

    public boolean getCellValue(int x, int y){
        if(x > 0 && x < this.width && y > 0 && x < this.height){
            return cells[x][y].isLive();
        }else{
            throw new IndexOutOfBoundsException();
        }
    }

    public void nextCycle() {
        Cell newBoard[][] = new Cell[this.width][this.height];
        for (int i = 0; i < this.width; i++)
            for (int j = 0; j < this.height; j++) {
                newBoard[i][j] = cells[i][j].clone();
            }

        for (int i = 0; i < this.width; i++)
            for (int j = 0; j < this.height; j++) {
                newBoard[i][j].changeState(countAliveNeighbours(i,j));
            }

        cells = newBoard;
    }

    public int countAliveNeighbours(int x, int y){
        int startX = Math.min(x, 0);
        int startY = Math.min(y, 0);
        int endX = Math.max(x, this.width - 1);
        int endY = Math.max(y, this.height - 1);

        int numberOfNeighbours = 0;
        for(int i = startX; i < endX; i++)
            for(int j = startY; j < endY; j++){
                numberOfNeighbours++;
            }

        if(cells[x][y].isLive())
            numberOfNeighbours--;

        return numberOfNeighbours;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}

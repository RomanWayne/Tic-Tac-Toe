package tictactoe;

public class Cell {
    private String state;
    private int rowNumber;
    private int columnNumber;

    public Cell(int rowNumber, int columnNumber, String state) {
        this.rowNumber = rowNumber;
        this.columnNumber = columnNumber;
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}

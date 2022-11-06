public class Knight extends ChessPiece {

    private final int row;
    private final int col;
    
    public Knight(String color, int row, int col) {
    super(color);
    this.row = row;
    this.col = col;
    }
    
    @Override
    public int getRow() {
    return row;
    }
    
    @Override
    public int getCol() {
    return col;
    }
    
    @Override
    public boolean isValidMove(int row, int col) {
    ChessPiece occupiedPiece = ChessPiece.isOccupied(row, col);
    if (occupiedPiece != null && occupiedPiece.getColor().equals(getColor())) {
    return false;
    }
    int[][] possibleMoveDirections = {{-2, -1}, {-2, 1}, {2, -1}, {2, 1},
    {1, -2}, {1, 2}, {-1, -2}, {-1, 2}};
    for (int[] direction : possibleMoveDirections) {
    int xDiff = direction[0];
    int yDiff = direction[1];
    if (this.row + xDiff == row && this.col + yDiff == col) {
    return true;
    }
    }
    return false;
    }
    }
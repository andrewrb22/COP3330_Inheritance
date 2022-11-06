public class Rook extends ChessPiece {

    private final int row;
    private final int col;
    
    public Rook(String color, int row, int col) {
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
    // for the move to be a valid move either the row should be same
    // or the col should be same
    if (this.row != row && this.col != col) {
    return false;
    }
    // case when the rows are same
    if (row == this.row) {
    // if the target column less than this.col
    if (col < this.col) {
    // iterating from this.col-1 to col-1
    for (int i = this.col - 1; i > col; i--) {
    // if the chesspiece is occupied in any of the square
    // then return false, no need to check for the color
    if (ChessPiece.isOccupied(row, i) != null) {
    return false;
    }
    }
    } else {
    // iterating from this.col+1 to col-1
    for (int i = this.col + 1; i < col; i++) {
    // if the chesspiece is occupied in any of the square
    // then return false, no need to check for the color
    if (ChessPiece.isOccupied(row, i) != null) {
    return false;
    }
    }
    }
    } else {
    if (row < this.row) {
    // iterating from this.row-1 to row-1
    for (int i = this.row - 1; i > row; i--) {
    // if the chesspiece is occupied in any of the square
    // then return false, no need to check for the color
    if (ChessPiece.isOccupied(i, col) != null) {
    return false;
    }
    }
    } else {
    // iterating from this.row+1 to row-1
    for (int i = this.row + 1; i < row; i++) {
    // if the chesspiece is occupied in any of the square
    // then return false, no need to check for the color
    if (ChessPiece.isOccupied(i, col) != null) {
    return false;
    }
    }
    }
    }
    // if till this code runs, then check if there are any piece
    // in the target location.
    ChessPiece targetPiece = ChessPiece.isOccupied(row, col);
    if (targetPiece != null) {
    // If there is any, then check whether the color are different or not
    // if they are different then the rook can occupy that square by
    // capturing the piece
    return !targetPiece.getColor().equals(getColor());
    }
    // else return true
    return true;
    }
    }
    
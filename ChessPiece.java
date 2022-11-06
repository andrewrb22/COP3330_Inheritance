import java.util.ArrayList;
public abstract class ChessPiece {
/**
 * masterList stores all the chess pieces in the game.
 * color stores the color of the chess piece.
 */
public static ArrayList<ChessPiece> masterList = new ArrayList<ChessPiece>();
private String color;
public ChessPiece(String color) {
this.color = color;
masterList.add(this);
}
public String getColor() {
return this.color;
}
/**
 * @param row - The row of the space we are checking
 * @param col - The column of the space we are checking
 * @return return the chess piece that is currently in this space.  
 * If there is none return null.
 */
public static ChessPiece isOccupied(int row, int col) {
    //Loop through masterList and determine
    for (ChessPiece piece : masterList) {
       //If any pieces are in the row
        //And column given from the parameters
    if (piece.getRow() == row && piece.getCol() == col) {
    return piece;
    }
    }
    //No chessPiece return Null
    return null;
    }

public abstract int getRow();
public abstract int getCol();
public abstract boolean isValidMove(int row, int col);
}
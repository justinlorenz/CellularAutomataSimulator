package cellsociety.Model.GameCells;

import java.util.List;

public class SquareNeighbors extends Neighbor {
  List<Integer> possibleRowMoves;
  List<Integer> possibleColMoves;

  public SquareNeighbors(String edgeType) {
    super(edgeType);
  }

  /**
   * Establishes the neighbor indices as all neighbors in square around cell
   */
  @Override
  public void setNeighborIndices() {
    possibleRowMoves = List.of(ROW_UP,ROW_UP,ROW_UP,NO_MOVE,NO_MOVE,ROW_DOWN,ROW_DOWN,ROW_DOWN);
    possibleColMoves = List.of(COL_LEFT,NO_MOVE,COL_RIGHT,COL_LEFT,COL_RIGHT,COL_LEFT,NO_MOVE,COL_RIGHT);
  }

  /**
   * Checks if the current row, col move is going to be in the allowed neighbor indices for a cross
   * @param rowMove
   * @param colMove
   * @return
   */
  @Override
  public boolean checkIfValidIndices(int rowMove, int colMove) {
    for (int i = 0; i < possibleRowMoves.size(); i++) {
      if (possibleRowMoves.get(i) == rowMove && possibleColMoves.get(i) == colMove)
        return true;
    }
    return false;
  }


}

package cellsociety.Model.GameCells;

import java.util.List;

public class TriangleNeighbors extends Neighbor {
  List<Integer> possibleRowMoves;
  List<Integer> possibleColMoves;

  public TriangleNeighbors(String edgeType) {
    super(edgeType);
  }

  /**
   * Establishes the neighbor indices for only above and below diagonals
   */
  @Override
  public void setNeighborIndices() {
    possibleRowMoves = List.of(ROW_UP,ROW_DOWN,ROW_DOWN);
    possibleColMoves = List.of(NO_MOVE,COL_LEFT,COL_RIGHT);
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

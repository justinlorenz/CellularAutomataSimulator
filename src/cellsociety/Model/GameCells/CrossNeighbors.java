package cellsociety.Model.GameCells;

import java.util.List;

public class CrossNeighbors extends Neighbor {
  List<Integer> possibleRowMoves;
  List<Integer> possibleColMoves;

  public CrossNeighbors(String edgeType) {
    super(edgeType);
  }

  /**
   * Establishes the neighbor indices for only N,E,S,W
   */
  @Override
  public void setNeighborIndices() {
    possibleRowMoves = List.of(ROW_UP,NO_MOVE,NO_MOVE,ROW_DOWN);
    possibleColMoves = List.of(NO_MOVE,COL_LEFT,COL_RIGHT,NO_MOVE);
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

package cellsociety.Model.GameCells;

import cellsociety.Model.BoardStructure;

public class Finite extends Edge {

  /**
   * Finite board does nothing if the i + rowMove is out of bounds
   */
  @Override
  public int checkEdgePolicyRow(int i, int rowMove,BoardStructure oldBoard) {
    return i + rowMove;
  }

  /**
   * Finite board does nothing if the j + colMove is out of bounds
   */
  @Override
  public int checkEdgePolicyCol(int j, int colMove,BoardStructure oldBoard) {
    return j + colMove;
  }
}

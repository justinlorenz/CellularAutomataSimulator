package cellsociety.Model.GameCells;

import cellsociety.Model.BoardStructure;

public abstract class Edge {

  /**
   * Checks if the current row is within the board's bounds
   * @param i
   * @param oldBoard
   * @return
   */
  public boolean checkRowWithinBoundaries(int i,BoardStructure oldBoard) {
    return (i >= 0 && i < oldBoard.getRows());
  }

  /**
   * Checks if the current col is within the board's bounds
   * @param j
   * @param oldBoard
   * @return
   */
  public boolean checkColWithinBoundaries(int j,BoardStructure oldBoard) {
    return  (j >= 0 && j < oldBoard.getCols());
  }

  /**
   * Method in subclasses the determines what should happen if the i + rowMove requested is outside the bounds
   * @param i
   * @param rowMove
   * @param oldBoard
   * @return
   */
  public abstract int checkEdgePolicyRow(int i, int rowMove, BoardStructure oldBoard);

  /**
   * Method in subclasses the determines what should happen if the j + colMove requested is outside the bounds
   */
  public abstract int checkEdgePolicyCol(int j, int colMove, BoardStructure oldBoard);

}

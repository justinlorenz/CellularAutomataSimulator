package cellsociety.Model.GameCells;

import cellsociety.Model.BoardStructure;

public class PercolationCell extends Cell {
  public static final int STATE_BLOCKED_INDEX = 0;
  public static final int STATE_OPEN_INDEX = 1;
  public static final int STATE_FULL_INDEX = 2;
  public static final int CELL_IS_FULL = 1;
  private int openState;
  private int fullState;
  private final int[] thisGameStates;

  /**
   * Cell Constructor for all cell classes that supers info and gets what current states are available for this game
   */
  public PercolationCell(int i, int j, int numberOfStates,String neighborType,String edgeType) {
    super(i, j,numberOfStates,neighborType,edgeType);
    thisGameStates = getThisGamesStates();
    setThisGamesStates();
  }


  /**
   * Implements the percolation rules
   */
  @Override
  public void nextGenerationRules(int i, int j, BoardStructure oldBoard,
      BoardStructure currBoard) {
    if (getState() == openState) {
      setStateIfOpen(i, j,ROW_UP,NO_MOVE, oldBoard);
      setStateIfOpen(i, j,NO_MOVE,COL_LEFT, oldBoard);
      setStateIfOpen(i, j,NO_MOVE,COL_RIGHT, oldBoard);
    }
  }

  //Helper method that sets state to full if there is an full state as neighbor
  private void setStateIfOpen(int i, int j, int rowMove, int colMove, BoardStructure oldBoard) {
    if (findSingularCellNeighbor(i,j,rowMove,colMove,oldBoard,fullState) == CELL_IS_FULL)
      setState(fullState);
  }

  /**
   * Sets this game's states based on the given state int[]
   */
  @Override
  public void setThisGamesStates() {
    openState = thisGameStates[STATE_OPEN_INDEX];
    fullState = thisGameStates[STATE_FULL_INDEX];
  }

  /**
   * Changes the state of the current cell if clicked
   */
  @Override
  public void changeStateWhenClicked() {
    changeStateOfClickedCell(thisGameStates.length);
  }

}

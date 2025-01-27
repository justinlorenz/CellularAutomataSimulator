package cellsociety.Model.GameCells;

import cellsociety.Model.BoardStructure;
import java.util.Random;

public class SpreadingFireCell extends Cell {
  public static final int STATE_EMPTY_INDEX = 0;
  public static final int STATE_TREE_INDEX = 1;
  public static final int STATE_BURNING_INDEX = 2;

  private int emptyState;
  private int treeState;
  private int burningState;
  private final int[] thisGameStates;
  private final double probCatch;
  private final Random randomFire;

  /**
   * Cell Constructor for all cell classes that supers info and gets what current states are available for this game
   */
  public SpreadingFireCell(int i, int j, double gameThreshold, int numberOfStates,String neighborType,String edgeType) {
    super(i, j,numberOfStates,neighborType,edgeType);
    thisGameStates = super.getThisGamesStates();
    setThisGamesStates();
    randomFire = new Random();
    probCatch = gameThreshold;
  }

  /**
   * Implements the spreadingfire rules
   */
  @Override
  public void nextGenerationRules(int i, int j, BoardStructure oldBoard, BoardStructure currBoard) {
      if (getState() == burningState)
        currBoard.getCurrCell(i,j).setState(emptyState);
      else if (getState() == treeState) {
        checkIfTreeCaughtFire(i,j,oldBoard);
      }
  }

  //Helper method that checks if tree caught fire
  private void checkIfTreeCaughtFire(int i, int j, BoardStructure oldBoard) {
    int totalBurningNeighbors = 0;
    totalBurningNeighbors += findSingularCellNeighbor(i,j,ROW_UP,NO_MOVE, oldBoard,burningState);
    totalBurningNeighbors += findSingularCellNeighbor(i,j,ROW_DOWN,NO_MOVE, oldBoard,burningState);
    totalBurningNeighbors += findSingularCellNeighbor(i,j,NO_MOVE,COL_LEFT, oldBoard,burningState);
    totalBurningNeighbors += findSingularCellNeighbor(i,j,NO_MOVE,COL_RIGHT, oldBoard,burningState);
    if (totalBurningNeighbors > 0) {
      double fireChance = randomFire.nextFloat();
      if (fireChance < probCatch)
        setState(burningState);
    }
  }

  /**
   * Sets this game's states based on the given state int[]
   */
  @Override
  public void setThisGamesStates() {
    emptyState = thisGameStates[STATE_EMPTY_INDEX];
    treeState = thisGameStates[STATE_TREE_INDEX];
    burningState = thisGameStates[STATE_BURNING_INDEX];
  }

  /**
   * Changes the state of the current cell if clicked
   */
  @Override
  public void changeStateWhenClicked() {
    changeStateOfClickedCell(thisGameStates.length);
  }

}

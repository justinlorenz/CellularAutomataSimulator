package cellsociety.Model.GameCells;

import cellsociety.Model.BoardStructure;
import java.util.Random;

/**
 * Abstract cell superclass
 */
public abstract class Cell {
  public static final int ROW_UP = -1;
  public static final int ROW_DOWN = 1;
  public static final int COL_LEFT = -1;
  public static final int COL_RIGHT = 1;
  public static final int NO_MOVE = 0;

  private int state;
  private int[] simulationStates;
  private final Random randomGenerator;
  private final Neighbor currNeighbors;

  /**
   * @param i - row number
   * @param j - column number
   * @param numberOfStates - number of states of simulation
   * @param neighborType - type of neighbor
   * @param edgeType - type of cell edge
   */
  public Cell(int i, int j, int numberOfStates, String neighborType,String edgeType) {
    NeighborFactory neighborFactory = new NeighborFactory();
    currNeighbors = neighborFactory.getTheCurrentNeighborType(neighborType,edgeType);
    setSimulationStates(numberOfStates);
    randomGenerator = new Random();
  }

  /**
   * Unique method for each simulation where the rules of each simulation are coded in this method and the current cell's
   * state updates based on these rules
   * @param i - row number
   * @param j - column number
   * @param oldBoard - prev Board
   * @param currBoard - current Board
   */
  public abstract void nextGenerationRules(int i, int j, BoardStructure oldBoard,
      BoardStructure currBoard);

  /**
   * set game state to specified simulation  states
   */
  public abstract void setThisGamesStates();

  /**
   * change game state of cell when clicked depending on available states for that simulation
   */
  public abstract void changeStateWhenClicked();

  /**
   * Allows subclass cells to easily find the specific state of a singular neighbor
   * @param i - row
   * @param j - col
   * @param rowMove - rowmove to neighbor
   * @param colMove - colmove to neighbor
   * @param oldBoard - model data
   * @param state - checking if neighbor is this state
   * @return
   */
  public int findSingularCellNeighbor(int i, int j, int rowMove, int colMove,BoardStructure oldBoard,int state) {
    return currNeighbors.findSingularCellNeighbor(i,j,rowMove,colMove,oldBoard,state);
  }

  /**
   * Allows subclass cells to easily find all 8 neighbors (uses findSingularCell)
   * @param i
   * @param j
   * @param oldBoard
   * @param state
   * @return
   */
  public int findAllCellNeighbors(int i, int j, BoardStructure oldBoard,int state) {
    return currNeighbors.findAllCellNeighbors(i,j,oldBoard,state);
  }

  /**
   * Allows subclass cells to easily find the neighbors in N,E,S,W (uses findSingularCell)
   * @param i
   * @param j
   * @param oldBoard
   * @param state
   * @return
   */
  public int findCrossCellNeighbors(int i, int j, BoardStructure oldBoard,int state) {
    return currNeighbors.findCrossCellNeighbors(i,j,oldBoard,state);
  }

  /**
   * Cycles the cell state of a cell, this method is called when cell is clicked
   * @param numStates
   */
  public void changeStateOfClickedCell(int numStates) {
    state++;
    if (state >= numStates)
      state = 0;
  }

  /**
   * Sets the int[] array that holds the states of the current game
   * @param numberOfStates
   */
  public void setSimulationStates(int numberOfStates) {
    simulationStates = new int[numberOfStates];
    for (int i = 0; i < numberOfStates; i++) {
      simulationStates[i] = i;
    }
  }

  /**
   * Generates a random number (used by classes that use random generation for moves)
   * @param upperbound - random will generate new int from [0,upperbound)
   * @return
   */
  public int generateRandomNumber(int upperbound) {
    return randomGenerator.nextInt(upperbound);
  }

  public void setState(int newState) {
    state = newState;
  }

  /**
   * Returns the current state in int form
   * @return
   */
  public int getState() {
    return state;
  }

  /**
   * Returns the int[] state array that holds all the possible positions for the current game's states
   * @return
   */
  public int[] getThisGamesStates() {
    return simulationStates;
  }

}


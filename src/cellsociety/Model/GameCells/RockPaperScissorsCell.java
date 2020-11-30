package cellsociety.Model.GameCells;

import cellsociety.Model.BoardStructure;

public class RockPaperScissorsCell extends Cell {
  public static final int STATE_ROCK_INDEX = 0;
  public static final int STATE_PAPER_INDEX = 1;
  public static final int STATE_SCISSORS_INDEX = 2;
  private int rockState;
  private int paperState;
  private int scissorsState;
  private final double threshold;
  private final int[] thisGameStates;

  /**
   * Cell Constructor for all cell classes that supers info and gets what current states are available for this game
   */
  public RockPaperScissorsCell(int i, int j, double gameThreshold, int numberOfStates,String neighborType,String edgeType) {
    super(i, j,numberOfStates,neighborType,edgeType);
    thisGameStates = getThisGamesStates();
    setThisGamesStates();
    threshold = gameThreshold;
  }

  /**
   * Implements the RPS rules
   */
  @Override
  public void nextGenerationRules(int i, int j, BoardStructure oldBoard, BoardStructure currBoard) {
    if (getState() == rockState)
      playRockPaperScissors(i,j, oldBoard,paperState);
    else if (getState() == paperState)
      playRockPaperScissors(i,j,oldBoard,scissorsState);
    else
      playRockPaperScissors(i,j,oldBoard,rockState);
  }

  //Helper method that finds neighbors and checks against threshold
  private void playRockPaperScissors(int i, int j, BoardStructure oldBoard, int beatingState) {
    int beatingStateNeighbors = findAllCellNeighbors(i,j,oldBoard,beatingState);
    if (beatingStateNeighbors > threshold)
      setState(beatingState);
  }

  /**
   * Sets this game's states based on the given state int[]
   */
  @Override
  public void setThisGamesStates() {
    rockState = thisGameStates[STATE_ROCK_INDEX];
    paperState = thisGameStates[STATE_PAPER_INDEX];
    scissorsState = thisGameStates[STATE_SCISSORS_INDEX];
  }

  /**
   * Changes the state of the current cell if clicked
   */
  @Override
  public void changeStateWhenClicked() {
    changeStateOfClickedCell(thisGameStates.length);
  }

}

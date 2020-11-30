package cellsociety.Model.GameCells;

import cellsociety.Model.Exceptions.ModelException;
import java.lang.reflect.InvocationTargetException;

/*
 * Threshold has been set to negative if it is not needed
 */
public class GameCellFactory {

  /**
   * Returns a new instance of a specific gamecell based on the gameType inputted. Also establishes two different constructors
   * for whether threshold was present or not in the .sim file
   * @param gameType
   * @param i
   * @param j
   * @param threshold
   * @param numberOfStates
   * @param neighborType
   * @param edgeType
   * @return
   */
  public Cell getTheCurrentGameType(String gameType, int i, int j,double threshold,
      int numberOfStates,String neighborType,String edgeType)
  {
    try {
      Class currentGameTypeClass = Class.forName("cellsociety.Model.GameCells."+gameType+"Cell");
      if (threshold < 0)
        return (Cell)currentGameTypeClass.getDeclaredConstructor(int.class,int.class,int.class,
            String.class,String.class).newInstance(i,j,numberOfStates,neighborType,edgeType);
      return (Cell)currentGameTypeClass.getDeclaredConstructor(int.class,int.class,double.class,
          int.class,String.class,String.class).newInstance(i,j,threshold,numberOfStates,neighborType,edgeType);
    }
    catch (NoSuchMethodException | IllegalAccessException | InstantiationException |
        IllegalStateException | InvocationTargetException | ClassNotFoundException e) {
      throw new ModelException("getTheCurrentGameTypeException",e);
    }
  }

}

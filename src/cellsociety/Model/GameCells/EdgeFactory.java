package cellsociety.Model.GameCells;

import cellsociety.Model.Exceptions.InvalidPropertyException;
import cellsociety.Model.Exceptions.ModelException;
import java.lang.reflect.InvocationTargetException;

public class EdgeFactory {

  /**
   * Returns the specific edge class type based on the edgeType string passed in using reflection. Defaults to
   * finite if no edgeType requested in .sim
   * @param edgeType
   * @return
   */
  public Edge getTheCurrentEdgeType(String edgeType)
  {
    try {
      if (edgeType == null)
        return new Finite();
      Class currentGameTypeClass = Class.forName("cellsociety.Model.GameCells."+edgeType);
      return (Edge)currentGameTypeClass.getDeclaredConstructor().newInstance();
    }
    catch (NoSuchMethodException | IllegalAccessException | InstantiationException | IllegalStateException | InvocationTargetException | ClassNotFoundException e) {
      throw new InvalidPropertyException("EdgeType",e);
    }
  }
}

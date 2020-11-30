package cellsociety.Model.GameCells;

import cellsociety.Model.Exceptions.InvalidPropertyException;
import java.lang.reflect.InvocationTargetException;

public class NeighborFactory {

  /**
   * Returns the correct type of neighbor class depending on the neighborType included, defaults to square if no neighbor
   * requested in .sim
   * @param neighborType
   * @param edgeType
   * @return
   */
  public Neighbor getTheCurrentNeighborType(String neighborType,String edgeType)
  {
    try {
      if (neighborType == null) {
        return new SquareNeighbors(edgeType);
      }
      Class currentGameTypeClass = Class.forName("cellsociety.Model.GameCells."+neighborType+"Neighbors");
      return (Neighbor)currentGameTypeClass.getDeclaredConstructor(String.class).newInstance(edgeType);

    }
    catch (NoSuchMethodException | IllegalAccessException | InstantiationException | IllegalStateException | InvocationTargetException | ClassNotFoundException e) {
      throw new InvalidPropertyException("NeighborType",e);
    }
  }
}

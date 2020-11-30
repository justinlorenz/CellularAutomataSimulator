package cellsociety;

import cellsociety.Controller.Controller;
import cellsociety.Model.DataReader;
import javafx.stage.Stage;
//import org.junit.Rule;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import util.DukeApplicationTest;
//import org.junit.rules.ExpectedException;


public class ModelExceptionsTests extends DukeApplicationTest {
  private Controller controller;
  DataReader dT = new DataReader();
  private Main main = new Main();

  @Override
  public void start(Stage stage) {
    javafxRun(()->main.start(new Stage()));
    controller = main.getGameController();
  }


  //Test exception for csv that does not match rows and columns specified
  @Test
  public void getUnmatchedRowTest() {
    Assertions.assertThrows(NullPointerException.class,
        () -> dT.placeBoard("data/TestingCSV/unmatchedRow_test.csv",controller.getNumberOfStates()));
  }

}

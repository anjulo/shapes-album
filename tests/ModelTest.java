import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import model.*;
import model.shapes.*;

public class ModelTest {

  private IModel model1;

  @Before
  public void setUp() throws Exception {
    model1 = new Model();
    model1.addShape("Oval", "O1", 0, 0, 10, 10, 0, 0, 0);
  }

  @After
  public void tearDown() throws Exception {
    model1 = null;
  }

  @Test
  public void getCanvas() {
    assertEquals(1, model1.getCanvas().size());
    IShape o1 = model1.getCanvas().get("O1");
    assertEquals(o1.getType(), "oval");
    assertEquals(o1.getColor(), new Color(0, 0, 0));
    assertEquals(o1.getCoordinates(), new Coordinates(0, 0));
    assertEquals(o1.getDimensions(), new Dimensions(10, 10));
  }

  @Test
  public void addShape() {
    model1.addShape("rectangle", "R1", 0, 0, 10, 10, 0, 0, 0);
    assertEquals(1, model1.getCanvas().size());
    IShape r1 = model1.getCanvas().get("R1");
    assertEquals(r1.getType(), "rectangle");
    assertEquals(r1.getColor(), new Color(0, 0, 0));
    assertEquals(r1.getCoordinates(), new Coordinates(0, 0));
    assertEquals(r1.getDimensions(), new Dimensions(10, 10));
  }

  @Test
  public void resizeShape() {
    model1.resizeShape("O1", 20, 20);
    IShape o1 = model1.getCanvas().get("O1");
    assertEquals(o1.getDimensions(), new Dimensions(20, 20));
  }

  @Test
  public void moveShape() {
    model1.moveShape("O1", 20, 20);
    IShape o1 = model1.getCanvas().get("O1");
    assertEquals(o1.getCoordinates(), new Coordinates(20, 20));
  }

  @Test
  public void changeColor() {
    model1.changeColor("O1", 255, 255, 255);
    IShape o1 = model1.getCanvas().get("O1");
    assertEquals(o1.getColor(), new Color(255, 255, 255));
  }

  @Test
  public void removeShape() {
    model1.removeShape("O1");
    assertEquals(0, model1.getCanvas().size());
  }

  @Test
  public void takeSnapshot() {
    model1.takeSnapshot("Snapshot 1");
    assertEquals(1, model1.getSnapshots().size());
  }

  @Test
  public void getSnapshots() {
    model1.takeSnapshot("Snapshot 1");
    assertEquals(1, model1.getSnapshots().size());
    ISnapshot snapshot1 = model1.getSnapshots().get(0);
    assertEquals(snapshot1.getDescription(), "Snapshot 1");
    assertEquals(snapshot1.getImage().size(), 1);
    IShape o1 = snapshot1.getImage().get("O1");
    assertEquals(o1.getType(), "oval");
    assertEquals(o1.getColor(), new Color(0, 0, 0));
    assertEquals(o1.getCoordinates(), new Coordinates(0, 0));
    assertEquals(o1.getDimensions(), new Dimensions(10, 10));
  }
}
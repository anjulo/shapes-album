import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import model.shapes.*;

public class AbstractShapeTest {

  private IShape rect1;
  private IShape oval1;

  @Before
  public void setUp() throws Exception {
    rect1 = new Rectangle("rect1", new Coordinates(50, 50), new Dimensions(100, 100),
        new Color(0, 0, 0));
    oval1 = new Oval("oval1", new Coordinates(50, 50), new Dimensions(100, 100),
        new Color(0, 0, 0));

  }

  @After
  public void tearDown() throws Exception {
//    rect1 = null;
//    oval1 = null;
  }

  @Test
  public void setColor() {
    rect1.setColor(255, 255, 255);
    assertEquals(new Color(255, 255, 255), rect1.getColor());
    oval1.setColor(255, 255, 255);
    assertEquals(new Color(255, 255, 255), oval1.getColor());
  }

  @Test
  public void move() {
    rect1.move(100, 100);
    assertEquals(new Coordinates(100, 100), rect1.getCoordinates());
    oval1.move(100, 100);
    assertEquals(new Coordinates(100, 100), oval1.getCoordinates());
  }

  @Test
  public void resize() {
    rect1.resize(200, 200);
    assertEquals(new Dimensions(200, 200), rect1.getDimensions());
    oval1.resize(200, 200);
    assertEquals(new Dimensions(200, 200), oval1.getDimensions());
  }

  @Test
  public void getColor() {
    assertEquals(new Color(0, 0, 0), rect1.getColor());
    assertEquals(new Color(0, 0, 0), oval1.getColor());
  }

  @Test
  public void getCoordinates() {
    assertEquals(new Coordinates(50, 50), rect1.getCoordinates());
    assertEquals(new Coordinates(50, 50), oval1.getCoordinates());
  }

  @Test
  public void getDimensions() {
    assertEquals(new Dimensions(100, 100), rect1.getDimensions());
    assertEquals(new Dimensions(100, 100), oval1.getDimensions());
  }
}
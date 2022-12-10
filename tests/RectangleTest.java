import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import model.shapes.*;

public class RectangleTest {

  private IShape rect1;

  @Before
  public void setUp() throws Exception {
    rect1 = new Rectangle("rect1", new Coordinates(50, 50), new Dimensions(100, 100),
        new Color(0, 0, 0));
  }

  @After
  public void tearDown() throws Exception {
    rect1 = null;
  }

  @Test
  public void getType() {
    assertEquals("rectangle", rect1.getType());
  }

  @Test
  public void testToString() {
    assertEquals("Type: rectangle\n"
        + "Min corner: (50.0, 50.0), Width: 100.0, Height: 100.0, Color: (0, 0, 0)\n", rect1.toString());
  }
}
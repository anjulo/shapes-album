import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import model.shapes.*;

public class OvalTest {

  private IShape oval1;

  @Before
  public void setUp() throws Exception {
    oval1 = new Oval("oval1", new Coordinates(50, 50), new Dimensions(100, 100),
        new Color(0, 0, 0));
  }

  @After
  public void tearDown() throws Exception {
    oval1 = null;
  }

  @Test
  public void getType() {
    assertEquals("oval", oval1.getType());
  }

  @Test
  public void testToString() {
    assertEquals("Type: oval\nCenter: (50.0, 50.0), X radius: 100.0, Y radius: 100.0, Color: (0, 0, 0)\n",
        oval1.toString());
  }
}
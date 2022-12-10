import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import model.shapes.Coordinates;

/**
 * This class represents a test for the Coordinates class.
 */
public class TestCoordinates {

  private Coordinates c1;
  private Coordinates c2;

  /**
   * Sets up the test.
   */
  @Before
  public void setUp() {
    c1 = new Coordinates(0, 0);
    c2 = new Coordinates(1, 1);
  }

  /**
   * Test the coordinates record.
   */
  @Test
  public void testRecord() {
    assertEquals(0, c1.x(), 0.001);
    assertEquals(1, c2.x(), 0.001);
    assertEquals(0, c1.y(), 0.001);
    assertEquals(1, c2.y(), 0.001);
  }


  /**
   * Tests toString method.
   */
  @Test
  public void testToString() {
    assertEquals("(0.0, 0.0)", c1.toString());
    assertEquals("(1.0, 1.0)", c2.toString());
  }
}

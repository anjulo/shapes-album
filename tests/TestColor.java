import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import model.shapes.Color;

/**
 * This class represents a test for the Color class.
 */
public class TestColor {

  private Color color1;
  private Color color2;

  /**
   * Sets up the test.
   */
  @Before
  public void setUp() {
    color1 = new Color(0, 0, 0);
    color2 = new Color(255, 255, 255);
  }

  /**
   * Tests the constructor.
   */
  @Test
  public void testRecord() {
    assertEquals(0, color1.red());
    assertEquals(0, color1.green());
    assertEquals(0, color1.blue());
    assertEquals(255, color2.red());
    assertEquals(255, color2.green());
    assertEquals(255, color2.blue());
  }

  /**
   * Tests the constructor with invalid values.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testRecordInvalidValues() {
    new Color(256, 0, 0);
    new Color(0, 256, 0);
    new Color(0, 0, 256);
    new Color(-1, 0, 0);
    new Color(0, -1, 0);
    new Color(0, 0, -1);
  }

  /**
   * Tests the toString method.
   */
  @Test
  public void testToString() {
    assertEquals("Color: (0, 0, 0)", color1.toString());
    assertEquals("Color: (255, 255, 255)", color2.toString());
  }
}

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import model.shapes.Dimensions;

public class TestDimensions {

  private Dimensions d1;
  private Dimensions d2;
  private Dimensions d3;

  /**
   * Sets up the test.
   */
  @Before
  public void setUp() {
    d1 = new Dimensions(0, 0);
    d2 = new Dimensions(1, 1);
    d3 = new Dimensions(1, 0);
  }

  /**
   * Tests the constructor.
   */
  @Test
  public void testConstructor() {
    assertEquals(0, d1.x(), 0.001);
    assertEquals(0, d1.y(), 0.001);

    assertEquals(1, d2.x(), 0.001);
    assertEquals(1, d2.y(), 0.001);

    assertEquals(1, d3.x(), 0.001);
    assertEquals(0, d3.y(), 0.001);

  }

  /**
   * Tests the constructor with negative values.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testConstructorInvalidValues() {
    new Dimensions(-1, 0);
    new Dimensions(0, -1);
    new Dimensions(-1, -1);
  }
}


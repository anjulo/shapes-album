package model.shapes;

import java.awt.Graphics;

/**
 * Oval class represents an oval shape.
 */
public class Oval extends AbstractShape {

  private final String TYPE = "oval";

  /**
   * Constructs an Oval object.
   *
   * @param name       the name of the oval
   * @param position   the position of the oval
   * @param dimensions the dimensions of the oval
   * @param color      the color of the oval
   */
  public Oval(String name, Coordinates position, Dimensions dimensions, Color color) {
    super(name, position, dimensions, color);
  }

  /**
   * Returns the type of the oval.
   *
   * @return the type of the oval
   */
  @Override
  public String getType() {
    return TYPE;
  }

  /**
   * Returns a string representation of the oval.
   *
   * @return a string representation of the oval
   */
  @Override
  public String toString() {
    return "Type: " + getType() + "\n"
      + "Center: " + getCoordinates() + ", X radius: " + getDimensions().x()
      + ", Y radius: " + getDimensions().y() + ", " + getColor() + "\n";
  }
}

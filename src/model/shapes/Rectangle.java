package model.shapes;

import java.awt.Graphics;

/**
 * Rectangle represents a rectangle shape.
 */
public class Rectangle extends AbstractShape {

  private final String TYPE = "rectangle";

  /**
   * Constructs a Rectangle object.
   *
   * @param name      the name of the rectangle
   * @param position  the position of the rectangle
   * @param dimensions the dimensions of the rectangle
   * @param color     the color of the rectangle
   */
  public Rectangle(String name, Coordinates position, Dimensions dimensions, Color color) {
    super(name, position, dimensions, color);
  }

  /**
   * Returns the type of the rectangle.
   *
   * @return the type of the rectangle
   */
  @Override
  public String getType() {
    return TYPE;
  }

  /**
   * Returns a string representation of the rectangle.
   *
   * @return a string representation of the rectangle
   */
  @Override
  public String toString() {
    return String.format("Type: %s\nMin corner: %s, Width: %.1f, Height: %.1f, %s\n",
        getType(), getCoordinates(), getDimensions().x(), getDimensions().y(), getColor());
  }
}

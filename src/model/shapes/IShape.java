package model.shapes;

import java.awt.Graphics;

/**
 * This interface represents a shape that can be drawn on a canvas.
 */
public interface IShape {

  /**
   * Returns the type of the shape.
   */
  public String getType();

  /**
   * Returns the color of the shape.
   */
  public Color getColor();

  /**
   * Returns the coordinates of the shape.
   */
  public Coordinates getCoordinates();

  /**
   * Returns the dimensions of the shape.
   */
  public Dimensions getDimensions();

  /**
   * Changes the color of the shape.
   */
  public void setColor(int red, int green, int blue) throws IllegalArgumentException;

  /**
   * Moves the shape to a new location.
   */
  public void move(double x, double y);

  /**
   * Resizes the shape.
   * @param x
   * @param y
   */
  public void resize(double x, double y);

  /**
   * Returns a string representation of the shape.
   */
  public String toString();
}

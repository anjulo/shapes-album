package model.shapes;

/**
 * This abstract class represents a shape that can be drawn on a canvas.
 */
public abstract class AbstractShape implements IShape {

  private String name;
  private Color color;
  private Coordinates coordinates;
  private Dimensions dimensions;

  /**
   * Constructs a shape with the given name, position, dimensions, and color.
   *
   * @param name        the name of the shape
   * @param coordinates the position of the shape
   * @param dimensions  the dimensions of the shape
   * @param color       the color of the shape
   */
  public AbstractShape(String name, Coordinates coordinates, Dimensions dimensions, Color color)
      throws IllegalArgumentException {
    if (name == null || coordinates == null || dimensions == null || color == null) {
      throw new IllegalArgumentException("Arguments cannot be null.");
    }
    if (name.equals("")) {
      throw new IllegalArgumentException("Name cannot be empty.");
    }
    this.name = name;
    this.color = color;
    this.coordinates = coordinates;
    this.dimensions = dimensions;
  }

  /**
   * Changes the color of the shape.
   *
   * @param red   the red value of the new color
   * @param green the green value of the new color
   * @param blue  the blue value of the new color
   * @throws IllegalArgumentException if the red, green, or blue values are not between 0 and 255
   */
  @Override
  public void setColor(int red, int green, int blue) {
    color = new Color(red, green, blue);
  }

  /**
   * Moves the shape to a new location.
   *
   * @param x the new x coordinate
   * @param y the new y coordinate
   */
  @Override
  public void move(double x, double y) {
    coordinates = new Coordinates(x, y);
  }

  /**
   * Resizes the shape.
   *
   * @param x the new x dimension
   * @param y the new y dimension
   */
  @Override
  public void resize(double x, double y) {
    dimensions = new Dimensions(x, y);
  }

  /**
   * Returns the color of the shape.
   */
  @Override
  public Color getColor() {
    return color;
  }

  /**
   * Returns the coordinates of the shape.
   */
  @Override
  public Coordinates getCoordinates() {
    return coordinates;
  }

  /**
   * Returns the dimensions of the shape.
   */
  @Override
  public Dimensions getDimensions() {
    return dimensions;
  }
}

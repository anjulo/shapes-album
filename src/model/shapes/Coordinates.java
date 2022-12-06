package model.shapes;

/**
 * This record class represents a coordinate.
 */
public record Coordinates(double x, double y) {

  /**
   * Returns a string representation of the coordinate.
   *
   * @return a string representation of the coordinate
   */
  @Override
  public String toString() {
    return "(" + x + ", " + y + ")";
  }
}

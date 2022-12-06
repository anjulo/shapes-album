package model.shapes;

/**
 * This record class represents the dimensions of a shape.
 */
public record Dimensions(double x, double y) {

  public Dimensions {
    if (x < 0 || y < 0) {
      throw new IllegalArgumentException("Invalid dimension values");
    }
  }
}

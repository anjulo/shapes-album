package model.shapes;

/**
 * This record class represents a color.
 */
public record Color(int red, int green, int blue) {

  public Color {
    if (red < 0 || red > 255 || green < 0 || green > 255 || blue < 0 || blue > 255) {
      throw new IllegalArgumentException("Invalid color values");
    }
  }

  @Override
  public String toString() {
    return "Color: (" + red + ", " + green + ", " + blue + ')';
  }
}

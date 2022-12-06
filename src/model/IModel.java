package model;

import model.shapes.IShape;

import java.util.List;
import java.util.Map;


/**
 * An interface that defines the operations of a model in the shape-drawing application. A model
 * contains a list of shapes and provides methods to add, remove, and retrieve shapes from the list.
 * It also provides a method to create a snapshot of the current state of the model.
 */
public interface IModel {

  /**
   * Returns a list of all shapes in the model.
   *
   * @return a list of all shapes in the model
   */
  public Map<String, IShape> getCanvas();

  /**
   * Adds a shape to the model.
   *
   * @param shapeName the name of the shape to add
   * @param shapeType the type of the shape to add
   * @param X         the x-coordinate of the shape
   * @param Y         the y-coordinate of the shape
   * @param X2        the first dimension of the shape
   * @param Y2        the second dimension of the shape
   * @param red       the red component of the shape's color
   * @param green     the green component of the shape's color
   * @param blue      the blue component of the shape's color
   * @throws IllegalArgumentException if the shape type is not "rectangle" or "oval"
   */
  void addShape(String shapeType, String shapeName, double X, double Y, double X2, double Y2,
      int red, int green, int blue) throws IllegalArgumentException;

  /**
   * Resizes the shape with the given name to the given dimensions.
   *
   * @param shapeName the name of the shape to resize
   * @param newX      the new width of the shape
   * @param newY      the new height of the shape
   * @throws IllegalArgumentException if the shape with the given name does not exist
   */
  void resizeShape(String shapeName, double newX, double newY)
      throws IllegalArgumentException;

  /**
   * Moves the shape with the given name to the given coordinates.
   *
   * @param shapeName the name of the shape to move
   * @param newX      the new x-coordinate of the shape
   * @param newY      the new y-coordinate of the shape
   * @throws IllegalArgumentException if the shape with the given name does not exist
   */
  void moveShape(String shapeName, double newX, double newY) throws IllegalArgumentException;

  /**
   * Changes the color of the shape with the given name to the given color.
   *
   * @param shapeName the name of the shape to change the color of
   * @param newRed    the new red component of the shape's color
   * @param newGreen  the new green component of the shape's color
   * @param newBlue   the new blue component of the shape's color
   * @throws IllegalArgumentException if the shape with the given name does not exist
   */
  void changeColor(String shapeName, int newRed, int newGreen, int newBlue)
      throws IllegalArgumentException;

  /**
   * Removes the shape with the given name from the model.
   *
   * @param shapeName the name of the shape to remove
   * @throws IllegalArgumentException if the shape with the given name does not exist
   */
  void removeShape(String shapeName) throws IllegalArgumentException;

  /**
   * Creates a snapshot of the current state of the model.
   *
   * @param description a description of the snapshot
   */
  void takeSnapshot(String description) throws IllegalArgumentException;


  /**
   * Returns a list of all snapshots taken.
   *
   * @return a list of all snapshots taken
   */
  List<ISnapshot> getSnapshots();

}

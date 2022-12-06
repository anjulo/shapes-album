package model;

import model.shapes.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * A class that represents a model in the shape-drawing application. A model is a mutable object
 * that stores the state of the application.
 */
public class Model implements IModel {

  private Map<String, IShape> canvas;
  private List<ISnapshot> snapshots;

  /**
   * Constructs a model with an empty list of shapes and snapshots.
   */
  public Model() {
    canvas = new LinkedHashMap<>();
    snapshots = new ArrayList<>();
  }


  @Override
  public Map<String, IShape> getCanvas() {
    return canvas;
  }

  @Override
  public void addShape(String shapeType, String shapeName, double x, double y, double xDim,
      double yDim, int red, int green, int blue) throws IllegalArgumentException {
    // Check if the shape type or name is null
    if (shapeType == null || shapeName == null) {
      throw new IllegalArgumentException("Shape type or name cannot be null");
    }

    if (canvas.containsKey(shapeName)) {
      throw new IllegalArgumentException("Shape with name \"" + shapeName + "\" already exists");
    }


    // Create the shape and add it to the list of shapes
    if (shapeType.equalsIgnoreCase("rectangle")) {
      canvas.put(shapeName, new Rectangle(shapeName, new Coordinates(x, y), new Dimensions(xDim, yDim),
          new Color(red, green, blue)));
    } else if (shapeType.equalsIgnoreCase("oval")) {
      canvas.put(shapeName, new Oval(shapeName, new Coordinates(x, y), new Dimensions(xDim, yDim),
          new Color(red, green, blue)));
    } else {
      throw new IllegalArgumentException("Invalid shape type");
    }
  }

  @Override
  public void resizeShape(String shapeName, double newX, double newY) {
    if (shapeName == null) {
      throw new IllegalArgumentException("Shape name cannot be null");
    }
    if (!canvas.containsKey(shapeName)) {
      throw new IllegalArgumentException("Shape not found");
    }
    canvas.get(shapeName).resize(newX, newY);
  }

  @Override
  public void moveShape(String shapeName, double newX, double newY) {
    if (shapeName == null) {
      throw new IllegalArgumentException("Shape name cannot be null");
    }
    if (!canvas.containsKey(shapeName)) {
      throw new IllegalArgumentException("Shape not found");
    }
    canvas.get(shapeName).move(newX, newY);
  }

  @Override
  public void changeColor(String shapeName, int newRed, int newGreen, int newBlue) {
    if (shapeName == null) {
      throw new IllegalArgumentException("Shape name cannot be null");
    }
    if (!canvas.containsKey(shapeName)) {
      throw new IllegalArgumentException("Shape not found");
    }
    canvas.get(shapeName).setColor(newRed, newGreen, newBlue);
  }

  @Override
  public void removeShape(String shapeName) {
    if (shapeName == null) {
      throw new IllegalArgumentException("Shape name cannot be null");
    }
    if (!canvas.containsKey(shapeName)) {
      throw new IllegalArgumentException("Shape not found");
    }
    canvas.remove(shapeName);
  }

  @Override
  public void takeSnapshot(String description) {
    if (description == null) {
      throw new IllegalArgumentException("Description cannot be null");
    }
    ISnapshot snapshot = new Snapshot(description, canvas);
    snapshots.add(snapshot);
  }

  @Override
  public List<ISnapshot> getSnapshots() {
    return snapshots;
  }
}


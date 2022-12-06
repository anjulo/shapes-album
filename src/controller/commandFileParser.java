package controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import model.IModel;

public class commandFileParser {

  private final IModel model;
  private static final String SHAPE_COMMAND = "shape";
  private static final String MOVE_COMMAND = "move";
  private static final String RESIZE_COMMAND = "resize";
  private static final String COLOR_COMMAND = "color";
  private static final String REMOVE_COMMAND = "remove";
  private static final String SNAPSHOT_COMMAND = "snapshot";

  public commandFileParser(IModel model) {
    this.model = model;
  }

  public void parse(String fileName) throws IOException, IllegalArgumentException {
    try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
      String line;
      while ((line = reader.readLine()) != null) {
        if (line.trim().startsWith("#")) {
          continue;
        }
        String[] tokens = line.trim().split("\\s+");
        if (tokens.length == 0 || tokens[0].isEmpty()) {
          continue;
        }
        String command = tokens[0].toLowerCase();
        switch (command) {
          case SHAPE_COMMAND -> parseShapeCommand(tokens);
          case MOVE_COMMAND -> parseMoveCommand(tokens);
          case RESIZE_COMMAND -> parseResizeCommand(tokens);
          case COLOR_COMMAND -> parseColorCommand(tokens);
          case REMOVE_COMMAND -> parseRemoveCommand(tokens);
          case SNAPSHOT_COMMAND -> parseSnapshotCommand(tokens);
          default -> throw new IllegalArgumentException("Unknown command: " + command);
        }
      }
    } catch (Exception e) {
      throw new IOException("Error reading file: " + fileName);
    }
  }

  private void parseShapeCommand(String[] tokens) {
    if (tokens.length == 10) {
      String shapeName = tokens[1];
      String shapeType = tokens[2];
      int x = Integer.parseInt(tokens[3]);
      int y = Integer.parseInt(tokens[4]);
      int xDim = Integer.parseInt(tokens[5]);
      int yDim = Integer.parseInt(tokens[6]);
      int red = Integer.parseInt(tokens[7]);
      int green = Integer.parseInt(tokens[8]);
      int blue = Integer.parseInt(tokens[9]);
      model.addShape(shapeType, shapeName, x, y, xDim, yDim, red, green, blue);
    } else {
      throw new IllegalArgumentException("Invalid shape command: " + Arrays.toString(tokens));
    }
  }

  private void parseMoveCommand(String[] tokens) {
    if (tokens.length == 4) {
      String shapeName = tokens[1];
      int x = Integer.parseInt(tokens[2]);
      int y = Integer.parseInt(tokens[3]);
      model.moveShape(shapeName, x, y);
    } else {
      throw new IllegalArgumentException("Invalid move command: " + Arrays.toString(tokens));
    }
  }

  private void parseResizeCommand(String[] tokens) {
    if (tokens.length == 4) {
      String shapeName = tokens[1];
      int width = Integer.parseInt(tokens[2]);
      int height = Integer.parseInt(tokens[3]);
      model.resizeShape(shapeName, width, height);
    } else {
      throw new IllegalArgumentException("Invalid resize command: " + Arrays.toString(tokens));
    }
  }

  private void parseColorCommand(String[] tokens) {
    if (tokens.length == 5) {
      String shapeName = tokens[1];
      int red = Integer.parseInt(tokens[2]);
      int green = Integer.parseInt(tokens[3]);
      int blue = Integer.parseInt(tokens[4]);
      model.changeColor(shapeName, red, green, blue);
    } else {
      throw new IllegalArgumentException("Invalid color command: " + Arrays.toString(tokens));
    }
  }

  private void parseRemoveCommand(String[] tokens) {
    if (tokens.length == 2) {
      String shapeName = tokens[1];
      model.removeShape(shapeName);
    } else {
      throw new IllegalArgumentException("Invalid remove command: " + Arrays.toString(tokens));
    }
  }

  private void parseSnapshotCommand(String[] tokens) {
    String description = "";
    if (tokens.length > 1 && !tokens[1].matches("\\d+")) {
      description = String.join(" ", Arrays.copyOfRange(tokens, 1, tokens.length));
    }
    model.takeSnapshot(description);
  }
}

package controller;

import java.io.IOException;
import model.IModel;
import model.Model;
import util.CommandLineOptions;
import view.*;

/**
 * The controller for the PhotoAlbum.
 */
public class Controller implements IController {

  private final String inputFile;

  private final IModel model;
  private final IView view;

  /**
   * Constructor for the controller.
   * @param options the command-line options
   */
  public Controller(CommandLineOptions options) {

    inputFile = options.inputFile();
    model = new Model();

    view = switch (options.viewType()) {
      case "graphical", "g" -> new GUIView(options.width(), options.height());
//      case "web", "w -> new WebView(options.outputFile());
      default -> throw new IllegalArgumentException("Invalid view type");
    };
  }

  public void go() throws IOException, IllegalArgumentException {
    commandFileParser fp = new commandFileParser(model);
    fp.parse(inputFile);
    view.display(model.getSnapshots());
  }

}

import controller.Controller;
import util.CommandLineOptions;
import util.CommandLineParser;

import java.io.IOException;

/**
 * The main class for the PhotoAlbum.
 */
public class PhotoAlbumMain {

  /**
   * The main method for the PhotoAlbum.
   * @param args the command-line arguments
   * @throws IOException if the file cannot be read
   */
  public static void main(String[] args) throws IOException {

    CommandLineOptions options = CommandLineParser.parse(args);

    Controller controller = new Controller(options);
    controller.go();

  }
}
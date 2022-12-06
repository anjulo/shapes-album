package view;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import model.ISnapshot;
import model.shapes.IShape;
import model.shapes.Oval;
import model.shapes.Rectangle;

public class WebView implements IView {

  private final String fileOutput;
  StringBuilder htmlBuilder;

  /**
   * Constructs a WebView with the given file output.
   *
   * @param fileOutput the file to write to
   */
  public WebView(String fileOutput) throws IllegalArgumentException {
    this.fileOutput = fileOutput;
    htmlBuilder = new StringBuilder();
  }

  @Override
  public void display(List<ISnapshot> snapshots) {

    // HTML metadata
    htmlBuilder.append("""
            <!DOCTYPE html>
            <html>
            <head>
            <title>Snapshots</title>
            </head>
            <body>
            """);
    addSnapshots(snapshots);

    htmlBuilder.append("""
              </body>
              </html>
              """);

    writeToFile();

  }
  private void addSnapshots(List<ISnapshot> snapshots){
    for (ISnapshot snapshot : snapshots) {
      htmlBuilder.append("<div>\n");
      htmlBuilder.append(String.format("<h3>%s</h3>\n", snapshot.getDescription()));
      htmlBuilder.append("""
              <ul>
              <svg width='100%' height='100%' viewBox='0 0 1000 1000'>
              """);
      for (IShape shape : snapshot.getImage().values()) {
        String shapeHtml = "";
        if (shape instanceof Rectangle) {
          shapeHtml = String.format(
                  "<rect x='%f' y='%f' width='%f' height='%f' fill='rgb(%d,%d,%d)' />%n",
                  shape.getCoordinates().x(),
                  shape.getCoordinates().y(),
                  shape.getDimensions().x(),
                  shape.getDimensions().y(),
                  shape.getColor().red(),
                  shape.getColor().green(),
                  shape.getColor().blue()
          );
        } else if (shape instanceof Oval) {
          shapeHtml = String.format(
                  "<ellipse cx='%f' cy='%f' rx='%f' ry='%f' fill='rgb(%d,%d,%d)' />%n",
                  shape.getCoordinates().x(),
                  shape.getCoordinates().y(),
                  shape.getDimensions().x(),
                  shape.getDimensions().y(),
                  shape.getColor().red(),
                  shape.getColor().green(),
                  shape.getColor().blue()
          );
        }
        htmlBuilder.append(shapeHtml);
      }

      htmlBuilder.append("""
              </svg>
              </ul>
              """);
    }
    htmlBuilder.append("</div>\n");
  }
  private void writeToFile() {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileOutput))){
      writer.write(htmlBuilder.toString());
    } catch (IOException e) {
      System.out.println("Error writing to file: " + e.getMessage());
    }
  }

  @Override
  public String toString() {
    return htmlBuilder.toString();
  }
}

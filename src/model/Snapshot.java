package model;

import model.shapes.*;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;


public class Snapshot implements ISnapshot {


  private final String id;
  private final String description;
  private final Map<String, IShape> image;


  public Snapshot(String description, Map<String, IShape> canvas) {
    this.id = LocalDateTime.now().toString();
    this.description = description;
//    this.canvas = new ArrayList<>(canvas.size());
    this.image = new LinkedHashMap<>();
    for (Map.Entry<String, IShape> entry : canvas.entrySet()) {
      String name = entry.getKey();
      IShape shape = entry.getValue();
      if (shape instanceof Rectangle r) {
        Coordinates coords = new Coordinates(r.getCoordinates().x(), r.getCoordinates().y());
        Dimensions dims = new Dimensions(r.getDimensions().x(),
            r.getDimensions().y());
        Color color = new Color(r.getColor().red(), r.getColor().green(),
            r.getColor().blue());
        this.image.put(name, new Rectangle(name, coords, dims, color));
      } else if (shape instanceof Oval o) {
        Coordinates coords = new Coordinates(o.getCoordinates().x(), o.getCoordinates().y());
        Dimensions dims = new Dimensions(o.getDimensions().x(),
            o.getDimensions().y());
        Color color = new Color(o.getColor().red(), o.getColor().green(),
            o.getColor().blue());
        this.image.put(name, new Oval(name, coords, dims, color));
      }
    }
  }

  @Override
  public String getId() {
    return id;
  }

  @Override
  public String getDescription() {
    return description;
  }

  @Override
  public Map<String, IShape> getImage() {
    return image;
  }
}

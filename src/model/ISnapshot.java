package model;

import model.shapes.IShape;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;


/**
 * An interface that defines the operations of a snapshot in the shape-drawing application.
 * A snapshot is a read-only copy of a model's state at a specific point in time.
 */
public interface ISnapshot {

  /**
   * Returns the unique identifier of the snapshot.
   *
   * @return the unique identifier of the snapshot
   */
  String getId();

  /**
   * Returns a description of the snapshot.
   *
   * @return a description of the snapshot
   */
  String getDescription();

  /**
   * Returns the list of shapes in the snapshot.
   *
   * @return the list of shapes in the snapshot
   */
  Map<String, IShape> getImage();

}
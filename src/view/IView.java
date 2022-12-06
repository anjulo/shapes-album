package view;

import java.util.List;

import model.ISnapshot;

/**
 * The interface for the view.
 */
public interface IView {

  /**
   * Generate the output for the given snapshots.
   *
   */
  void display(List<ISnapshot> snapshots);
}

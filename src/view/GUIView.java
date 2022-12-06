package view;

import model.ISnapshot;
import model.shapes.IShape;
import model.shapes.Oval;
import model.shapes.Rectangle;

import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 * GUIView displays the snapshots via Java Swing.
 */
public class GUIView implements IView {

  private final JFrame frame;
  private JLabel label;
  private int currentSnapshotIndex;


  /**
   * Constructs a GUIView with the given width and height.
   *
   * @param width  the width of the frame
   * @param height the height of the frame
//   * @param snapshots the list of snapshots to display
   */
  public GUIView(int width, int height) {
    currentSnapshotIndex = 0;

    // Create the frame
    frame = new JFrame();
    frame.setTitle("Snapshot Viewer");
    frame.setPreferredSize(new Dimension(width, height));
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }

  @Override
  public void display(List<ISnapshot> snapshots) {
    addLabelPanel();
    addCanvasPanel(snapshots);
    addControlPanel(snapshots);

    frame.pack();
    frame.setVisible(true);
  }

  // Create the label panel with default text and add it to the frame
  private void addLabelPanel() {
    JPanel labelPanel = new JPanel();
    label = new JLabel();
    label.setFont(new Font("Arial", Font.ITALIC, 14));

    labelPanel.add(label);
    labelPanel.setBackground(new Color(128, 128, 128));
    frame.getContentPane().add(labelPanel, BorderLayout.NORTH);
  }

  // Create the canvas panel to display shapes
  private void addCanvasPanel(List<ISnapshot> snapshots) {
    JPanel canvasPanel = new JPanel() {
      @Override
      public void paintComponent(Graphics g) {
        super.paintComponent(g);
        ISnapshot snapshot = snapshots.get(currentSnapshotIndex);
//        for (IShape shape : snapshot.getImage()) {
        for (IShape shape : snapshot.getImage().values()) {
          Color shapeColor = new Color(shape.getColor().red(), shape.getColor().green(), shape.getColor().blue());
          g.setColor(shapeColor);

          if (shape instanceof Rectangle) {
            g.fillRect((int) shape.getCoordinates().x(), (int) shape.getCoordinates().y(),
                    (int) shape.getDimensions().x(), (int) shape.getDimensions().y());
          } else if (shape instanceof Oval) {
            g.fillOval((int) shape.getCoordinates().x(), (int) shape.getCoordinates().y(),
                    (int) shape.getDimensions().x(), (int) shape.getDimensions().y());
          }
        }

        // Update the label
        String labelText = "<html><div>" + snapshot.getDescription() + "</div></html>";
        label.setText(labelText);
      }
    };

    frame.getContentPane().add(canvasPanel, BorderLayout.CENTER);
  }

  // Create and add the control panel with buttons and combo box
  private void addControlPanel(List<ISnapshot> snapshots) {
    JPanel controlPanel = new JPanel();

    JComboBox<String> snapshotComboBox = new JComboBox<>();
    for (ISnapshot snapshot : snapshots) {
      snapshotComboBox.addItem(snapshot.getId());
    }

    snapshotComboBox.addActionListener(e -> {
      currentSnapshotIndex = snapshotComboBox.getSelectedIndex();
      frame.repaint();

    });

    JButton prevButton = new JButton("Previous");
    prevButton.addActionListener(e -> {
      if (currentSnapshotIndex > 0) {
        currentSnapshotIndex--;
        snapshotComboBox.setSelectedItem(snapshots.get(currentSnapshotIndex).getId());
        frame.repaint();
      } else {
        JOptionPane.showMessageDialog(frame, "This is the first snapshot");
      }
    });

    JButton nextButton = new JButton("Next");
    nextButton.addActionListener(e -> {
      if (currentSnapshotIndex < snapshots.size() - 1) {
        currentSnapshotIndex++;
        snapshotComboBox.setSelectedItem(snapshots.get(currentSnapshotIndex).getId());
        frame.repaint();
      } else {
        JOptionPane.showMessageDialog(frame, "This is the last snapshot");
      }
    });

    controlPanel.add(prevButton);
    controlPanel.add(snapshotComboBox);
    controlPanel.add(nextButton);
    frame.getContentPane().add(controlPanel, BorderLayout.SOUTH);
  }
}

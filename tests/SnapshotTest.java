import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedHashMap;

import model.*;
import model.shapes.*;

import static org.junit.Assert.*;

public class SnapshotTest {

  private ISnapshot snapshot1;

  @Before
  public void setUp() throws Exception {
    snapshot1 = new Snapshot("Snapshot 1", new LinkedHashMap<>());
    snapshot1.getImage().put("O1", new Oval("O1", new Coordinates(0, 0), new Dimensions(10, 10),
        new Color(0, 0, 0)));
  }

  @After
  public void tearDown() throws Exception {
    snapshot1 = null;
  }

  @Test
  public void getId() {
    // id is based on the current time, so we can't test for a specific value
    assertNotNull(snapshot1.getId());
  }

  @Test
  public void getDescription() {
    assertEquals("Snapshot 1", snapshot1.getDescription());
  }

  @Test
  public void getImage() {
    assertEquals(1, snapshot1.getImage().size());
    assertEquals("oval", snapshot1.getImage().get("O1").getType());
    assertEquals(new Color(0, 0, 0), snapshot1.getImage().get("O1").getColor());
    assertEquals(new Coordinates(0, 0), snapshot1.getImage().get("O1").getCoordinates());
    assertEquals(new Dimensions(10, 10), snapshot1.getImage().get("O1").getDimensions());
  }
}
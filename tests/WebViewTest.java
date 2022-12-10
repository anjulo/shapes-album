import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import model.IModel;
import model.Model;
import view.WebView;

public class WebViewTest {

  private WebView webView;


  @Before
  public void setUp() throws Exception {
    webView = new WebView("test.html");
    IModel model1 = new Model();
    model1.addShape("rectangle", "rect", 200, 200, 50, 100, 255, 0, 0);
    model1.takeSnapshot("snapshot1");
    model1.addShape("oval", "oval", 500, 100, 60, 30, 0, 0, 255);
    model1.takeSnapshot("snapshot2");

    webView.display(model1.getSnapshots());
  }

  @After
  public void tearDown() throws Exception {
  }

  @Test
  public void display() {
  }

  @Test
  public void testToString() {
    String expectedString = """
            <!DOCTYPE html>
            <html>
            <head>
            <title>Snapshots</title>
            </head>
            <body>
            <div>
            <h3>snapshot1</h3>
            <ul>
            <svg width='100%' height='100%' viewBox='0 0 1000 1000'>
            <rect x='200' y='200' width='50' height='100' fill='rgb(255,0,0)' visibility='visible' >
            </rect>
            </svg>
            </ul>
            </div>
            <div>
            <h3>snapshot2</h3>
            <ul>
            <svg width='100%' height='100%' viewBox='0 0 1000 1000'>
            <rect x='200' y='200' width='50' height='100' fill='rgb(255,0,0)' visibility='visible' >
            </rect>
            <ellipse cx='500' cy='100' rx='30' ry='15' fill='rgb(0,0,255)' visibility='visible' >
            </ellipse>
            </svg>
            </ul>
            </div>
            </body>
            </html>
            """;
    assertEquals(expectedString, webView.toString());
  }
}
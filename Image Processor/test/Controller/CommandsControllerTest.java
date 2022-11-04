package Controller;

import org.junit.Before;

import java.io.File;

import Controller.Commands.Blue;
import Controller.Commands.Green;
import Controller.Commands.Intensity;
import Controller.Commands.Load;
import Controller.Commands.Luma;
import Controller.Commands.Red;
import Controller.Commands.Save;
import Controller.Commands.Value;
import Model.ImageModel;

import static Model.ImageUtil.readPPM;
import static org.junit.Assert.assertEquals;

class CommandsControllerTest {

  ImageModel m;
  ImageModel m2;
  File file;
  Controller load;
  Controller save;
  Controller blue;
  Controller red;
  Controller green;
  Controller luma;
  Controller intensity;
  Controller value;



  @Before
  public void setup() {
    this.m = new ImageModel("2x2test", readPPM("images/2x2test.ppm"));
    this.m2 = new ImageModel("2x2test", readPPM("images/2x2test.ppm"));
    this.file = new File("images/2x2test.ppm");
    this.save = new Save("images/2x2test.ppm");
    this.load = new Load("images/2x2test.ppm", "2x2test");
    this.blue = new Blue();
    this.red = new Red();
    this.green = new Green();
    this.luma = new Luma();
    this.intensity = new Intensity();
    this.value = new Value();
  }


  public void testLoad() {
    load.go(m);
    save.go(m);
    assertEquals(m.getPixelAt(0, 0), m2.getPixelAt(0,0));
    assertEquals(m.getPixelAt(1, 0), m2.getPixelAt(1,0));
    assertEquals(m.getPixelAt(0, 1), m2.getPixelAt(0,1));
    assertEquals(m.getPixelAt(1, 1), m2.getPixelAt(1,1));

  }


  public void testSave() {
    load.go(m);
    save.go(m);
    assertEquals(m.getPixelAt(0, 0), m2.getPixelAt(0,0));
    assertEquals(m.getPixelAt(1, 0), m2.getPixelAt(1,0));
    assertEquals(m.getPixelAt(0, 1), m2.getPixelAt(0,1));
    assertEquals(m.getPixelAt(1, 1), m2.getPixelAt(1,1));
  }

  public void testBlue() {
    load.go(m);
    save.go(m);
    assertEquals(m.getPixelAt(0, 0), m2.getPixelAt(0, 0));
    assertEquals(m.getPixelAt(1, 0), m2.getPixelAt(1, 0));
    assertEquals(m.getPixelAt(0, 1), m2.getPixelAt(0, 1));
    assertEquals(m.getPixelAt(1, 1), m2.getPixelAt(1, 1));


  }

  // if the pixels match up after an operation


}
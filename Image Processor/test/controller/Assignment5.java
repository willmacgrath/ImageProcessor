package controller;

import org.junit.Before;
import org.junit.Test;

import controller.commands.Blur;
import controller.commands.Greyscale;
import controller.commands.Load;
import controller.commands.SavePPM;
import controller.commands.Sepia;
import controller.commands.Sharpen;
import model.ImageModel;

import static Utils.ImageUtil.pixelToString;
import static Utils.ImageUtil.readPPMAsString;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Assignment5 {

  private ImageModel m;
  private ImageModel m2;
  Controller sepia;
  Controller save;
  Controller load;
  Controller greyscale;
  Controller blur;
  Controller sharpen;


  @Before
  public void setup() {
    this.m = new ImageModel();
    this.m2 = new ImageModel();
    this.save = new SavePPM("Images/slash.ppm", "slash");
    this.load = new Load("Images/slash.ppm", "slash");
    this.sepia = new Sepia("slash", "sepia-slash");
    this.greyscale = new Greyscale("slash", "grey-slash");
    this.blur = new Blur("slash", "blur-slash");
    this.sharpen = new Sharpen("slash", "sharp-slash");
  }


  @Test
  public void testLoad() {
    load.operateOn(m);
    assertTrue(m.inLibrary("test"));
  }

  @Test
  public void testSave() {
    load.operateOn(m);
    load.operateOn(m2);
    save.operateOn(m2);
  }

  // I want to create a method to turn the pixel values into a string so we can compare images based off that
  @Test
  public void testSepia() {
    load.operateOn(m);
    sepia.operateOn(m);
    Controller save = new SavePPM("Images/sepiaslash.ppm", "slash");
    save.operateOn(m);
    assertEquals(readPPMAsString("Images/sepiaslash.ppm"),
            pixelToString(m.getLibraryImagePixels("sepia-slash")));
  }

}

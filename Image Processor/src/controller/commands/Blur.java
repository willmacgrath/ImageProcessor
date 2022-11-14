package controller.commands;

import java.awt.image.BufferedImage;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;
import controller.Controller;
import model.Model;
import model.Pixel;

import static utils.ImageUtil.readImage;
import static utils.ImageUtil.writeBuffered;


/**
 * The BLur class represents the function object for the Blur command and applies
 * the blur filter to the desired image.
 */
public class Blur extends AbstractCommand implements Controller {

  String refName;
  String newName;


  public Blur(String refName, String newName) {
    this.refName = refName;
    this.newName = newName;
  }

  @Override
  public void operateOn(Model image) {
    BufferedImage bufferedImage = writeBuffered(image.getLibraryImagePixels(refName));
    Kernel blurFilter = new Kernel(3, 3,
            new float[]{0.0625f, 0.125f, 0.0625f, 0.125f, 0.25f,
                        0.125f, 0.0625f, 0.125f, 0.0625f});
    ConvolveOp cop =
            new ConvolveOp(blurFilter, ConvolveOp.EDGE_NO_OP, null);
    BufferedImage newBufferedImage = cop.filter(bufferedImage, null);
    Pixel[][] pixels = readImage(newBufferedImage);
    image.insert(newName, pixels);

  }
}
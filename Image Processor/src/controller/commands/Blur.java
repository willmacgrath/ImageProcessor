package controller.commands;

import java.awt.image.BufferedImage;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;
import controller.Controller;
import model.Model;
import model.Pixel;

import static Utils.ImageUtil.readImage;
import static Utils.ImageUtil.writeBuffered;
import static javax.imageio.ImageIO.read;

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
            new float[]{0.0625f, 0.125f, 0.0625f, 0.125f,
                    0.25f, 0.125f, 0.0625f, 0.125f, 0.0625f});
    ConvolveOp cop =
            new ConvolveOp(blurFilter, ConvolveOp.EDGE_NO_OP, null);
    BufferedImage newBufferedImage = cop.filter(bufferedImage, null);
    Pixel[][] pixels = readImage(newBufferedImage);
    image.insert(newName, pixels);

  }
}
package Controller.Commands;

import java.io.File;

import Controller.Controller;
import Model.ImageModel;
import Model.ImageUtil;
import Model.Pixel;

/**
 * Class contains the command object Brighten that takes the image and loads a brighter
 * copy image of the original into our Image Library.
 */
public class Brighten extends ImageModel implements Controller {

  private int percent;

  public Brighten(int percent) {
    if (percent > 0) {
      this.percent = percent;
    }
  }

  @Override
  public Pixel colorSetter(Pixel pixel){
    int redVal = pixel.getRed() * (1 + percent/100);
    int blueVal = pixel.getBlue() * (1 + percent/100);
    int greenVal = pixel.getGreen() * (1 + percent/100);
    return new Pixel(redVal, greenVal, blueVal);
  }

  @Override
  public void go(ImageModel image) {
    componentChanger(image);
  }
}

package Controller.Commands;

import java.io.File;

import Controller.Controller;
import Model.ImageModel;
import Model.ImageUtil;
import Model.Pixel;

/**
 * Class contains the command object Blue that takes the image and loads a new
 * greyscale image set to the blue value into our Image Library.
 */
public class Blue extends ImageModel implements Controller {

  @Override
  public Pixel colorSetter(Pixel pixel){
    int blueVal = pixel.getBlue();
    return new Pixel(blueVal, blueVal, blueVal);
  }

  @Override
  public void go(ImageModel image) {
    componentChanger(image);
  }
}

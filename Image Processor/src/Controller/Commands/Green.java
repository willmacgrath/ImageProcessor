package Controller.Commands;

import Controller.Controller;
import Model.ImageModel;
import Model.ImageUtil;
import Model.Pixel;

/**
 * Class contains the command object Green that takes the image and loads a new
 * greyscale image set to the green value into our Image Library.
 */
public class Green extends ImageModel implements Controller {

  @Override
  public Pixel colorSetter(Pixel pixel){
    int greenVal = pixel.getGreen();
    return new Pixel(greenVal, greenVal, greenVal);
  }

  @Override
  public void go(ImageModel image) {
    componentChanger(image);
  }
}

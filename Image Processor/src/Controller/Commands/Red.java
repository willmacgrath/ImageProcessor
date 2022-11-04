package Controller.Commands;

import Controller.Controller;
import Model.ImageModel;
import Model.ImageUtil;
import Model.Pixel;


/**
 * Class contains the command object Red that takes the image and loads a new
 * greyscale image set to the red value into our Image Library.
 */
public class Red extends ImageModel implements Controller {

  @Override
  public Pixel colorSetter(Pixel pixel){
    int redVal = pixel.getRed();
    return new Pixel(redVal, redVal, redVal);
  }

  @Override
  public void go(ImageModel image) {
    componentChanger(image);
  }
}
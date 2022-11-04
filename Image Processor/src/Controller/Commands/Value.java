package Controller.Commands;

import Controller.Controller;
import Model.ImageModel;
import Model.ImageUtil;
import Model.Pixel;


/**
 * Class contains the command object Value that takes the image and loads a new
 * greyscale image set to the value into our Image Library.
 */
public class Value extends ImageModel implements Controller {

  @Override
  public Pixel colorSetter(Pixel pixel){
    int value = pixel.getValue();
    return new Pixel(value, value, value);
  }

  @Override
  public void go(ImageModel image) {
    componentChanger(image);
  }
}
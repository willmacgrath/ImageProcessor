package Controller.Commands;

import Controller.Controller;
import Model.ImageModel;
import Model.ImageUtil;
import Model.Pixel;

/**
 * Class contains the command object Intensity that takes the image and loads a new
 * greyscale image set to the intensity value into our Image Library.
 */
public class Intensity extends ImageModel implements Controller {

  @Override
  public Pixel colorSetter(Pixel pixel){
    int intenseVal = pixel.intensity();
    return new Pixel(intenseVal, intenseVal, intenseVal);
  }

  @Override
  public void go(ImageModel image) {
    componentChanger(image);
  }
}
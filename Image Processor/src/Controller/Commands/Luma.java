package Controller.Commands;

import Controller.Controller;
import Model.ImageModel;
import Model.ImageUtil;
import Model.Pixel;


/**
 * Class contains the command object Luma that takes the image and loads a new
 * greyscale image set to the luma value into our Image Library.
 */
public class Luma extends ImageModel implements Controller {

  @Override
  public Pixel colorSetter(Pixel pixel){
    int lumaVal = pixel.luma();
    return new Pixel(lumaVal, lumaVal, lumaVal);
  }

  @Override
  public void go(ImageModel image) {
    componentChanger(image);
  }
}
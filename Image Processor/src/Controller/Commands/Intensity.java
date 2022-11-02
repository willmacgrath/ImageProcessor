package Controller.Commands;

import Controller.Controller;
import Model.ImageModel;
import Model.ImageUtil;
import Model.Pixel;

public class Intensity extends ImageUtil implements Controller {

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
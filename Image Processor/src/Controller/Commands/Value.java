package Controller.Commands;

import Controller.Controller;
import Model.ImageModel;
import Model.ImageUtil;
import Model.Pixel;

public class Value extends ImageUtil implements Controller {

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
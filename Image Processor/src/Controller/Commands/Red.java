package Controller.Commands;

import Controller.Controller;
import Model.ImageModel;
import Model.ImageUtil;
import Model.Pixel;

public class Red extends ImageUtil implements Controller {

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
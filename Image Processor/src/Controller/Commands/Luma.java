package Controller.Commands;

import Controller.Controller;
import Model.ImageModel;
import Model.ImageUtil;
import Model.Pixel;

public class Luma extends ImageUtil implements Controller {

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
package Controller.Commands;

import Controller.Controller;
import Model.ImageModel;
import Model.ImageUtil;
import Model.Pixel;

public class Green extends ImageUtil implements Controller {


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

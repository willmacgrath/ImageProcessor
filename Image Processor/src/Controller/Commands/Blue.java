package Controller.Commands;

import java.io.File;

import Controller.Controller;
import Model.ImageModel;
import Model.ImageUtil;
import Model.Pixel;

public class Blue extends ImageUtil implements Controller {

  @Override
  public Pixel colorSetter(Pixel pixel){
    int blueVal = pixel.getBlue();
    return new Pixel(blueVal, blueVal, blueVal);
  }

  @Override
  public void go(ImageModel image) {
    componentChanger(image);
  }
}

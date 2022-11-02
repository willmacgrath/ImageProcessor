package Controller.Commands;

import java.io.File;

import Controller.Controller;
import Model.ImageModel;
import Model.ImageUtil;
import Model.Pixel;

public class Brighten extends ImageUtil implements Controller {

  private int percent;
  private File imagePath;
  private String imageName;

  public Brighten(int percent, File imagePath, String imageName) {
    this.percent = percent;
    this.imagePath = imagePath;
    this.imageName = imageName;
  }

  @Override
  public Pixel colorSetter(Pixel pixel){
    int redVal = pixel.getRed() * (1 + percent/100);
    int blueVal = pixel.getBlue() * (1 + percent/100);
    int greenVal = pixel.getGreen() * (1 + percent/100);
    return new Pixel(redVal, blueVal, greenVal);
  }

  @Override
  public void go(ImageModel image) {
    componentChanger(image);
  }
}

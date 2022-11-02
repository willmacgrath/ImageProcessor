package Controller.Commands;

import java.io.File;

import javax.swing.*;

import Controller.Controller;
import Model.ImageModel;
import Model.ImageUtil;
import Model.Pixel;

public class Red extends ImageUtil implements Controller {

  String imageName;
  String destImageName;

  @Override
  public void go(ImageModel image) {
    Pixel[][] old = readPPM(imageName);
    Pixel[][] redImageArray = new Pixel[image.height()][image.width()];
    ImageModel redImage = new ImageModel(destImageName,
            redImageArray);
    for (int y = 0; y < image.height(); y++) {
      for (int x = 0; x < image.width(); x++) {
        redImageArray[x][y] = redSetter(old[x][y]);
          }
      }
    redImage.insert(destImageName, redImageArray);
    }

  private Pixel redSetter(Pixel pixel){
    int redVal = pixel.getRed();
    return new Pixel(redVal, redVal, redVal);
  }
}

package Controller.Commands;

import Controller.Controller;
import Model.ImageModel;
import Model.ImageUtil;
import Model.Pixel;

public class Blue extends ImageUtil implements Controller {

  String imageName;
  String destImageName;

  @Override
  public void go(ImageModel image) {
    Pixel[][] old = readPPM(imageName);
    Pixel[][] blueImageArray = new Pixel[image.height()][image.width()];
    ImageModel blueImage = new ImageModel(destImageName,
            blueImageArray);
    for (int y = 0; y < image.height(); y++) {
      for (int x = 0; x < image.width(); x++) {
        blueImageArray[x][y] = blueSetter(old[x][y]);
      }
    }
    blueImage.insert(destImageName, blueImageArray);
  }

  private Pixel blueSetter(Pixel pixel) {
    int blueVal = pixel.getBlue();
    return new Pixel(blueVal, blueVal, blueVal);
  }
}

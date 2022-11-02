package Controller.Commands;

import Controller.Controller;
import Model.ImageModel;
import Model.ImageUtil;
import Model.Pixel;

public class Intensity extends ImageUtil implements Controller {

  String imageName;
  String destImageName;

  @Override
  public void go(ImageModel image) {
    Pixel[][] old = readPPM(imageName);
    Pixel[][] intenseImageArray = new Pixel[image.height()][image.width()];
    ImageModel intenseImage = new ImageModel(destImageName,
            intenseImageArray);
    for (int y = 0; y < image.height(); y++) {
      for (int x = 0; x < image.width(); x++) {
        intenseImageArray[x][y] = intensitySetter(old[x][y]);
      }
    }
    intenseImage.insert(destImageName, intenseImageArray);
  }

  private Pixel intensitySetter(Pixel pixel) {
    int intenseVal = pixel.intensity();
    return new Pixel(intenseVal, intenseVal, intenseVal);
  }
}

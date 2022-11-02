package Controller.Commands;

import Controller.Controller;
import Model.ImageModel;
import Model.ImageUtil;
import Model.Pixel;

public class Value extends ImageUtil implements Controller {

  String imageName;
  String destImageName;

  @Override
  public void go(ImageModel image) {
    Pixel[][] old = readPPM(imageName);
    Pixel[][] valueImageArray = new Pixel[image.height()][image.width()];
    ImageModel valueImage = new ImageModel(destImageName,
            valueImageArray);
    for (int y = 0; y < image.height(); y++) {
      for (int x = 0; x < image.width(); x++) {
        valueImageArray[x][y] = valueSetter(old[x][y]);
      }
    }
    valueImage.insert(destImageName, valueImageArray);
  }

  private Pixel valueSetter(Pixel pixel){
    int value = pixel.getValue();
    return new Pixel(value, value, value);
  }
}


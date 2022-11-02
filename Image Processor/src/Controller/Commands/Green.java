package Controller.Commands;

import Controller.Controller;
import Model.ImageModel;
import Model.ImageUtil;
import Model.Pixel;

public class Green extends ImageUtil implements Controller {

  String imageName;
  String destImageName;

  @Override
  public void go(ImageModel image) {
    Pixel[][] old = readPPM(imageName);
    Pixel[][] greenImageArray = new Pixel[image.height()][image.width()];
    ImageModel greenImage = new ImageModel(destImageName,
            greenImageArray);
    for (int y = 0; y < image.height(); y++) {
      for (int x = 0; x < image.width(); x++) {
        greenImageArray[x][y] = greenSetter(old[x][y]);
      }
    }
    greenImage.insert(destImageName, greenImageArray);
  }

  private Pixel greenSetter(Pixel pixel){
    int greenVal = pixel.getGreen();
    return new Pixel(greenVal, greenVal, greenVal);
  }
}

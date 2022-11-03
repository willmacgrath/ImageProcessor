package Controller.Commands;

import java.io.File;
import Controller.Controller;
import Model.ImageModel;
import Model.ImageUtil;

public class Load extends ImageUtil implements Controller {

  private String imagePath;
  private String imageName;

  public Load(String imagePath, String imageName) {
    this.imagePath = imagePath;
    this.imageName = imageName;
  }

  @Override
  public void go(ImageModel image) {
    image.insert(imageName, readPPM(imagePath));
  }
}

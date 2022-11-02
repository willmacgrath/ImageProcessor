package Controller.Commands;

import java.io.File;

import Controller.Controller;
import Model.ImageModel;

public class Save implements Controller {

  private File imagePath;
  private String imageName;

  public Save(File imagePath, String imageName) {
    this.imagePath = imagePath;
    this.imageName = imageName;
  }

  @Override
  public void go(ImageModel image) {
    File file = new File("Files/" + imageName);
  }
}



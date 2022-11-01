package Controller.Commands;

import java.io.File;

import Controller.Controller;
import Model.ImageModel;

public class Save implements Controller {

  private File imagePath;

  private File imageName;

  public Save(File imagePath, File imageName) {
    this.imagePath = imagePath;
    this.imageName = imageName;
  }

  @Override
  public void go(ImageModel image) {
    imageName.renameTo(imagePath);
  }
}



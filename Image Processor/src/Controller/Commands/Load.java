package Controller.Commands;

import java.io.File;
import Controller.Controller;
import Model.ImageModel;

public class Load implements Controller {

  private File imagePath;

  private File imageName;

  public Load(File imagePath, File imageName) {
    this.imagePath = imagePath;
    this.imageName = imageName;
  }

  @Override
  public void go(ImageModel image) {
    imagePath.renameTo(imageName);
  }



}

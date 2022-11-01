package Controller.Commands;

import java.io.File;
import Controller.Controller;
import Model.ImageModel;

public class Load implements Controller {

  private File imagePath;

  private File fileName;

  public Load(File imagePath, String fileName) {
    this.imagePath = imagePath;
    this.fileName = fileName;
  }

  //changes from a file to an image
  //need pixel information
  @Override
  public void go(ImageModel image) {
    imagePath.renameTo(fileName);
    image.readPPM(String.valueOf(fileName));
  }



}

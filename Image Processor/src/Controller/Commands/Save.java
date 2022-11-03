package Controller.Commands;

import java.io.File;
import java.io.IOException;

import Controller.Controller;
import Model.ImageModel;

public class Save implements Controller {

  private String imagePath;
  private String imageName;

  public Save(String imagePath, String imageName) {
    this.imagePath = imagePath;
    this.imageName = imageName;
  }

  @Override
  public void go(ImageModel image) {
    try {
      File file = new File(imagePath);
      if (file.createNewFile()) {
        System.out.println("File created: " + file.getName());
      } else {
        System.out.println("File already exists.");
      }
    } catch (IOException e) {
      System.out.println("An error occurred.");
    }
  }
}



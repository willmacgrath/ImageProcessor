package Controller.Commands;

import java.io.File;
import java.io.IOException;

import Controller.Controller;
import Model.ImageModel;


/**
 * Class contains the command object Save that takes the image and
 * saves it to a user specified location.
 */
public class Save implements Controller {

  private String imagePath;

  /**
   * This constructor is used so that we can allow the user to choose where the image is saved to.
   * @param imagePath where the user wants the image saved
   */
  public Save(String imagePath) {
    this.imagePath = imagePath;
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



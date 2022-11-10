package controller.commands;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import controller.Controller;
import model.Model;
import model.Pixel;


/**
 * Class contains the command object SavePPM that takes the image and
 * saves it to a user specified location.
 */
public class SavePPM implements Controller {

  private String imagePath;
  private String fileName;

  /**
   * This constructor is used so that we can allow the user to choose where the image is saved to.
   *
   * @param imagePath where the user wants the image saved
   */
  public SavePPM(String imagePath, String fileName) {
    this.imagePath = imagePath;
    this.fileName = fileName;
  }

  @Override
  public void operateOn(Model image) {
    Appendable builder = new StringBuilder();
    int width = image.width(fileName);
    int height = image.height(fileName);
    try {
      builder.append("P3\n" + width + " " + height + "\n255\n");
    } catch (IOException e) {
      throw new RuntimeException(e);
    }

    for (int y = 0; y < image.height(fileName); y++) {
      for (int x = 0; x < image.width(fileName); x++) {
        Pixel p = image.getPixelAt(fileName, x, y);
        int r = p.getRed();
        int g = p.getGreen();
        int b = p.getBlue();
        try {
          builder.append(r + " \n" + g + " \n" + b + " \n");
        } catch (IOException e) {
          throw new RuntimeException(e);
        }
      }
    }
    try {
      Files.writeString(Path.of(imagePath), builder.toString());
      System.out.println("Image Saved");
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
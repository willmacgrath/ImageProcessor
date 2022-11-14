package controller.commands;

import utils.MathUtils;
import model.Model;
import model.Pixel;

/**
 * This Abstract class contains the logic for most methods that involve creating a new image
 * based on another's pixels.
 */
public abstract class AbstractCommand {

  protected double[][] matrix;

  /**
   * This is a helper method that runs in go() statements that creates a new image pixel
   * by pixel. Individual pixels are set by the colorSetter() method below.
   *
   * @param image The image model that the user want to edit
   */
  public void componentChanger(Model image, String oldName, String newName) {
    Pixel[][] imageArray = new Pixel[image.height(oldName)][image.width(oldName)];
    for (int y = 0; y < image.height(oldName); y++) {
      for (int x = 0; x < image.width(oldName); x++) {
        imageArray[x][y] = colorSetter(image.getPixelAt(oldName, x,y));
        // may cause issues when images get too large
      }
    }
    image.insert(newName, imageArray);
  }

  /**
   * Helper for componentChanger that performs an takes in the original pixel, does an
   * action to it, and then returns the new edited pixel. This colorSetter should be
   * overwritten for each Command's usage.
   *
   * @param pixel The pixel that you want to get the values from.
   * @return the edited pixel.
   */
  public Pixel colorSetter(Pixel pixel) {
    double[][] rgb = {{pixel.getRed()},{pixel.getGreen()},{pixel.getBlue()}};
    double[][] newRGB = MathUtils.matrixMulti(this.matrix, rgb);
    int red = (int)(newRGB[0][0]);
    int green = (int)(newRGB[1][0]);
    int blue = (int)(newRGB[2][0]);
    Pixel newPixel = new Pixel(red, green, blue);
    return newPixel;
  }

  /**
   * This method is used to vertically flip an image.
   * @param image represents the image being flipped.
   */
  public void vertical(Model image, String oldName, String newName) {
    Pixel[][] imageArray = new Pixel[image.height(oldName)][image.width(oldName)];
    for (int y = 0; y < image.height(oldName); y++) {
      for (int x = 0; x < image.width(oldName); x++) {
        imageArray[image.height(oldName) - x][y] =
                colorSetter(image.getPixelAt(oldName, x,y));
      }
    }
    image.insert(newName, imageArray);
  }

  /**
   * This method is used to horizontally flip an image.
   * @param image represents the image being flipped.
   */
  public void horizontal(Model image, String oldName, String newName) {
    Pixel[][] imageArray = new Pixel[image.height(oldName)][image.width(oldName)];
    for (int y = 0; y < image.height(oldName); y++) {
      for (int x = 0; x < image.width(oldName); x++) {
        imageArray[x][image.width(oldName) - y] =
                colorSetter(image.getPixelAt(oldName, x,y));
      }
    }
    image.insert(newName, imageArray);
  }
}

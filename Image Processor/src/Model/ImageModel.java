package Model;

import java.util.HashMap;
import java.util.Map;

import static Model.ImageUtil.readPPM;

/**
 * This class contains the ImageModel which is used as our Model in the MVC format.
 */
public class ImageModel implements Model {

  private Pixel[][] pixelArray;
  private String fileName;
  private Map<String, Pixel[][]> imageLibrary; // consider if we need to make a class
  private int width;
  private int height;
  private int maxValue;

  public ImageModel(){};

  public ImageModel(String fileName, Pixel[][] pixelArray) {
    this.fileName = fileName;
    this.pixelArray = pixelArray;
    this.imageLibrary = new HashMap<String, Pixel[][]>();
  }

  @Override
  public void insert(String name, Pixel[][] image) {
    imageLibrary.put(name, image);
  }

  @Override
  public int width() {
    return this.width;
  }

  @Override
  public int height() {
    return this.height;
  }

  @Override
  public int maxValue() {
    return this.maxValue;
  }


  /**
   * This is a helper method that runs in go() statements that creates a new image pixel
   * by pixel. Individual pixels are set by the colorSetter() method below.
   * @param image The image model that the user want to edit
   */
  public void componentChanger(ImageModel image) {
    Pixel[][] old = image.pixelArray;
    Pixel[][] imageArray = new Pixel[image.height()][image.width()];
    ImageModel imageModel = new ImageModel(this.fileName,
            imageArray);
    for (int y = 0; y < image.height(); y++) {
      for (int x = 0; x < image.width(); x++) {
        imageArray[x][y] = colorSetter(old[x][y]);
      }
    }
    imageModel.insert(this.fileName, imageArray);
  }

  /**
   * Helper for componentChanger that performs an takes in the original pixel, does an
   * action to it, and then returns the new edited pixel. This colorSetter should be
   * overwritten for each Command's usage.
   * @param pixel The pixel that you want to get the values from.
   * @return the edited pixel.
   */
  public Pixel colorSetter(Pixel pixel) {
    return null;
  }


  public void vertical(ImageModel image) {
    Pixel[][] old = readPPM(image.fileName);
    Pixel[][] imageArray = new Pixel[image.height()][image.width()];
    ImageModel imageModel = new ImageModel(this.fileName,
            imageArray);
    for (int y = 0; y < image.height(); y++) {
      for (int x = 0; x < image.width(); x++) {
        imageArray[x][image.height() - y] = colorSetter(old[x][y]);
      }
    }
    imageModel.insert(this.fileName, imageArray);
  }

  public void horizontal(ImageModel image) {
    Pixel[][] old = readPPM(image.fileName);
    Pixel[][] imageArray = new Pixel[image.height()][image.width()];
    ImageModel imageModel = new ImageModel(this.fileName,
            imageArray);
    for (int y = 0; y < image.height(); y++) {
      for (int x = 0; x < image.width(); x++) {
        imageArray[image.height() - x][y] = colorSetter(old[x][y]);
      }
    }
    imageModel.insert(this.fileName, imageArray);
  }

  public Pixel getPixelAt(int row, int col) {
    return pixelArray[row][col];
  }

  public boolean inLibrary(String imageName) {
    return imageLibrary.containsValue(imageName);
  }
}
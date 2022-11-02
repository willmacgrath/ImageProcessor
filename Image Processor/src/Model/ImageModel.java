package Model;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class ImageModel implements Model {


  private int pixel;
  private Pixel[][] pixelArray;
  private String fileName;
  private Map<String, Pixel[][]> imageLibrary;
  private int width;
  private int height;
  private int maxValue;

  public ImageModel(String fileName, Pixel[][] pixelArray) {
    this.pixelArray = pixelArray;
    this.imageLibrary = new HashMap<String, Pixel[][]>();
  }

  public void insert(String name, Pixel[][] image) {
    imageLibrary.put(name, image);
  }

  public int width() {
    return this.width;
  }

  public int height() {
    return this.height;
  }

  public int maxValue() {
    return this.maxValue;
  }

}
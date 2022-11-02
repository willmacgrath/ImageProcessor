package Model;

import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.FileInputStream;


/**
 * This class contains utility methods to read a PPM image from file and simply print its contents. Feel free to change this method
 *  as required.
 */
public class ImageUtil {

  String imageName;
  String destImageName;

  /**
   * Read an image file in the PPM format and print the colors.
   *
   * @param filename the path of the file.
   */
  public static Pixel[][] readPPM(String filename) {
    Scanner sc;

    try {
      sc = new Scanner(new FileInputStream(filename));
    } catch (FileNotFoundException e) {
      System.out.println("File " + filename + " not found!");
      return null;
    }
    StringBuilder builder = new StringBuilder();
    //read the file line by line, and populate a string. This will throw away any comment lines
    while (sc.hasNextLine()) {
      String s = sc.nextLine();
      if (s.charAt(0) != '#') {
        builder.append(s + System.lineSeparator());
      }
    }

    //now set up the scanner to read from the string we just built
    sc = new Scanner(builder.toString());

    String token;

    token = sc.next();
    if (!token.equals("P3")) {
      System.out.println("Invalid PPM file: plain RAW file should begin with P3");
    }
    int width = sc.nextInt();
    int height = sc.nextInt();
    int maxValue = sc.nextInt();
    Pixel[][] array = new Pixel[width][height];

    for (int y = 0; y < height; y++) {
      for (int x = 0; x < width; x++) {
        int r = sc.nextInt();
        int g = sc.nextInt();
        int b = sc.nextInt();
        array[x][y] = new Pixel(r, g, b);

      }
    }
    return array;
  }

  public void componentChanger(ImageModel image) {
    Pixel[][] old = readPPM(imageName);
    Pixel[][] imageArray = new Pixel[image.height()][image.width()];
    ImageModel imageModel = new ImageModel(destImageName,
            imageArray);
    for (int y = 0; y < image.height(); y++) {
      for (int x = 0; x < image.width(); x++) {
        imageArray[x][y] = colorSetter(old[x][y]);
      }
    }
    imageModel.insert(destImageName, imageArray);
  }

  public Pixel colorSetter(Pixel pixel) {
    return null;
  }
}



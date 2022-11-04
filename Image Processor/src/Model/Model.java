package Model;

/**
 * The Model interface contains all classes and methods related to using Images as models.
 */
public interface Model {

  /**
   * The insert method places an ImageModel into our ImageLibrary.
   * @param name the name of the image
   * @param image the pixel map that makes up the image
   */
  void insert(String name, Pixel[][] image);

  /**
   * Gets the width of an image.
   * @return the width as an int.
   */
  int width();

  /**
   * Gets the height of an image.
   * @return the height as an int.
   */
  int height();

  /**
   * Gets the Maximum Value of an image.
   * @return the maxValue as an int.
   */
  int maxValue();
}
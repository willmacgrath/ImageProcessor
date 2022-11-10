package model;


/**
 * Pixels are individual units that contain an rbg.
 */
public class Pixel {
  private int red;
  private int blue;
  private int green;


  /**
   * This constructor represents the rgb values of the pixel.
   * @param red   represents the red value of the pixel.
   * @param green represents the green value.
   * @param blue  represents the blue value.
   */
  public Pixel(int red, int green, int blue) { // cap values somehow
    if (red <= 255) {
      if (red >= 0) {
        this.red = red;
      } else {
        this.red = 255;
      }
    } else {
      this.red = 0;
    }
    if (green <= 255) {
      if (green >= 0) {
        this.green = green;
      } else {
        this.green = 255;
      }
    } else {
      this.green = 0;
    }
    if (blue <= 255) {
      if (blue >= 0) {
        this.blue = blue;
      } else {
        this.blue = 255;
      }
    } else {
      this.blue = 0;
    }
  }

  public int getRed() {
    return this.red;
  }

  public int getBlue() {
    return this.blue;
  }

  public int getGreen() {
    return this.green;
  }

  public int getValue() {
    return Math.max(Math.max(this.red, this.blue), this.green);
  }

  public int intensity() {
    return ((this.red + this.blue + this.green) / 3);
  }

  public int getLuma() { // typecasting is used to turn luna double to a usable int
    return (int)((0.2126 * this.red) + (0.7152 * this.green) + (0.0722 * this.blue));
  }

  public int getPixelValAvg() {
    return (this.red + this.green + this.blue) / 3;
  }
}

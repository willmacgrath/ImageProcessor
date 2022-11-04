package Model;


/**
 * Pixels are individual units that contain an rbg
 */
public class Pixel {
  private int red;
  private int blue;
  private int green;


  public Pixel(int red, int green, int blue) { // THIS ISNT CORRECT, FIX ALL PIXEL USAGES TO RGB
    this.red = red;
    this.green = green;
    this.blue = blue;
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
    return Integer.MAX_VALUE;
  }

  public int intensity() {
    return ((this.red + this.blue + this.green) / 3);
  }

  public int luma() { // typecasting is used to turn luna double to a usable int
    return (int)((0.2126 * this.red) + (0.7152 * this.green) + (0.0722 * this.blue));
  }
}

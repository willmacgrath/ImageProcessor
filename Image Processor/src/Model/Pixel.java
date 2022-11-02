package Model;


public class Pixel {
  private int red;
  private int blue;
  private int green;

  private int luma;

  public Pixel(int red, int blue, int green) {
    this.red = red;
    this.blue = blue;
    this.green = green;
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
  public int getValue(Pixel pixel) {
    return Integer.MAX_VALUE;
  }

  public int intensity(Pixel pixel) {
    return ((this.red + this.blue + this.green) / 3);
  }

  public double luma(Pixel pixel) {
    return ((0.2126 * this.red) + (0.7152 * this.green) + (0.0722 * this.blue));
  }


}

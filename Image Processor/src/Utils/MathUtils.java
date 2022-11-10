package Utils;

import model.Pixel;

public class MathUtils {

  public static double[][] matrixMulti(double[][] matrix, double[][] rgb) {
    double[][] newRGBArray = new double[0][];
    for (int y = 0; y < matrix[0].length; y++) {
      for (int x = 0; x < matrix.length; x++) {
        double red = matrix[0][0]*rgb[0][0] +  matrix[0][1]*rgb[1][0] + matrix[0][2]*rgb[2][0];
        double green = matrix[1][0]*rgb[0][0] +  matrix[1][1]*rgb[1][0] + matrix[1][2]*rgb[2][0];
        double blue = matrix[2][0]*rgb[0][0] +  matrix[2][1]*rgb[1][0] + matrix[2][2]*rgb[2][0];
        newRGBArray = new double[][]{ {red}, {green}, {blue}};
      }
    }
    return newRGBArray;
  }
}

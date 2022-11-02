//package Controller.Commands;
//
//import Controller.Controller;
//import Model.ImageModel;
//import Model.ImageUtil;
//import Model.Pixel;
//
//public class Luma extends ImageUtil implements Controller {
//
//  String imageName;
//  String destImageName;
//
//  @Override
//  public void go(ImageModel image) {
//    Pixel[][] old = readPPM(imageName);
//    Pixel[][] lumaImageArray = new Pixel[image.height()][image.width()];
//    ImageModel lumaImage = new ImageModel(destImageName,
//            lumaImageArray);
//    for (int y = 0; y < image.height(); y++) {
//      for (int x = 0; x < image.width(); x++) {
//        lumaImageArray[x][y] = lumaSetter(old[x][y]);
//      }
//    }
//    lumaImage.insert(destImageName, lumaImageArray);
//  }
//
//  private Pixel lumaSetter(Pixel pixel) {
//    int lumaVal = pixel.luma();
//    return new Pixel(lumaVal, lumaVal, lumaVal);
//  }
//}

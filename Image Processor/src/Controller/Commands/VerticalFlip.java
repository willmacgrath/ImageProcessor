package Controller.Commands;

import Controller.Controller;
import Model.ImageModel;
import Model.ImageUtil;
import Model.Pixel;

import static Model.ImageUtil.readPPM;

/**
 * Class contains the command object HorizontalFlip that takes the image and loads a new
 * copy of the image that has been flipped horizontally into our Image Library.
 */
public class VerticalFlip extends ImageModel implements Controller {


  public void go(ImageModel image) {
    vertical(image);
  }
}

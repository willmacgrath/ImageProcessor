package Model;

public class ImageModel extends ImageUtil {

  private int[] pixel;
  private Pixel[][] picture;

  public ImageModel(Pixel[][] picture) {
    this.picture = picture;
  }

}
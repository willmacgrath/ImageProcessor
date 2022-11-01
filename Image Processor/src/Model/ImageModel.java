package Model;

public class ImageModel implements Model {

  private int[] pixel;
  private Pixel[][] picture;

  public ImageModel(Pixel[][] picture) {
    this.picture = picture;
  }

}
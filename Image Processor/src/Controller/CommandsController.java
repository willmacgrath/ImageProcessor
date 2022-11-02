package Controller;

import java.util.Scanner;
import Controller.Commands.Blue;
import Controller.Commands.Brighten;
import Controller.Commands.Green;
import Controller.Commands.HorizontalFlip;
import Controller.Commands.Intensity;
import Controller.Commands.Load;
import Controller.Commands.Luma;
import Controller.Commands.Red;
import Controller.Commands.Save;
import Controller.Commands.Value;
import Controller.Commands.VerticalFlip;
import Model.ImageModel;
import Model.ImageUtil;
import Model.Pixel;

public class CommandsController extends ImageUtil {
  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    String fileName;
    Controller cmd = null;
    Pixel[][] array = readPPM(fileName);
    ImageModel m = new ImageModel(fileName, array);
    while (s.hasNext()) {
      String in = s.next();
      try {
        switch (in) {
          case "q":
          case "quit":
            return;
          case "load":
            cmd = new Load(args[1], args[2]);
            break;
          case "save":
            cmd = new Save(args[1], args[2]);
            break;
          case "red-component":
            cmd = new Red();
            break;
          case "blue-component":
            cmd = new Blue();
            break;
          case "green-component":
            cmd = new Green();
            break;
          case "value-component":
            cmd = new Value();
            break;
          case "luma-component":
            cmd = new Luma();
            break;
          case "intensity-component":
            cmd = new Intensity();
            break;
          case "brighten":
            cmd = new Brighten(args[1],args[2], args[3]);
          case "horizontal-flip":
            cmd = new HorizontalFlip(args[1], args[2]);
            break;
          case "vertical-flip":
            cmd = new VerticalFlip(args[1], args[2]);
            break;
          default:
            System.out.println(String.format("Unknown command %s", in));
            cmd = null;
            break;
        }
        if (cmd != null) {
          cmd.go(m);
        }
      }
      catch (IllegalArgumentException ime) { // make sure we need this
        System.out.println("Illegal" + in);
    }
  }
}

  }
}

package Controller;

import java.util.InputMismatchException;
import java.util.Scanner;

import Controller.Commands.Blue;
import Controller.Commands.Brighten;
import Controller.Commands.Green;
import Controller.Commands.HorizontalFlip;
import Controller.Commands.Intensity;
import Controller.Commands.Load;
import Controller.Commands.Red;
import Controller.Commands.Save;
import Controller.Commands.Value;
import Controller.Commands.VerticalFlip;
import Model.ImageModel;

public class CommandsController {
  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    ImageModel m = new ImageModel( , );
    Controller cmd = null;
    while (s.hasNext()) {
      String in = s.next();
      try {
        switch (in) {
          case "q":
          case "quit":
            return;
          case "load":
            cmd = new Load(fileName, array);
            break;
          case "save":
            cmd = new Save(fileName, array);
            break;
          case "red-component":
            cmd = new Red(fileName, array);
            break;
          case "blue-component":
            cmd = new Blue(fileName, array);
            break;
          case "green-component":
            cmd = new Green(fileName, array);
            break;
          case "value-component":
            cmd = new Value(fileName, array);
            break;
          case "luma-component":
            cmd = new Luma(fileName, array);
            break;
          case "intensity-component":
            cmd = new Intensity(fileName, array);
            break;
          case "horizontal-flip":
            cmd = new HorizontalFlip(fileName, array);
            break;
          case "vertical-flip":
            cmd = new VerticalFlip(fileName, array);
            break;
          case "brighten":
            cmd = new Brighten(fileName, array);
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

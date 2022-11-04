import java.io.File;

import javax.naming.ldap.Control;

import Controller.Commands.Load;
import Controller.Commands.Save;
import Controller.Controller;
import Model.ImageModel;

import static org.junit.Assert.assertEquals;

import static Model.ImageUtil.readPPM;

public class testLoad {

//  File file = new File("images/2x2test.ppm");
//  ImageModel m = new ImageModel("2x2test", readPPM("images/2x2test.ppm"));
//  Controller cm = new Load("images/2x2test.ppm", "2x2test");
//  cm.go(m);

  public void testGO() {
    File file = new File("images/2x2test.ppm");
    ImageModel m = new ImageModel("2x2test", readPPM("images/2x2test.ppm"));
    Controller cm = new Load("images/2x2test.ppm", "2x2test");
    Controller cm2 = new Save("images/2x2test.ppm", "2x2test");
    cm2.go(m);

    assertEquals();
  }

}

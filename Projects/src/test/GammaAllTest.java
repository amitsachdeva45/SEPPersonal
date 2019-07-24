/**
 * 
 */

package test;

import static org.junit.Assert.assertEquals;

import code.GammaController;
import code.GammaModel;
import code.GammaView;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;


/**
 * This class is testing working of gamma functionality.
 * @author Amit Sachdeva
 *
 */
public class GammaAllTest {
  static GammaController gammaController;
  static GammaModel gammaModel;
  static GammaView gammaView;
  
  /**
  * In this method initializing of controller, view, model is done for testing.
  */
  @BeforeClass public static void beforeClass() {
    gammaModel = new GammaModel();
    gammaView = new GammaView("Gamma Function");
    gammaView.setBasicLayout(0);
    gammaController = new GammaController(gammaModel, gammaView);
    gammaController.startController();
  }

  @Test
  public void testLargePositiveNumber1() {
    assertEquals("infinity", gammaModel.startGamma("110.0"));
  }
  
  @Test
  public void testLargePositiveNumber2() {
    assertEquals("infinity", gammaModel.startGamma("130.0"));
  }
  
  
  @Test
  public void testNegativeNumber1() {
    assertEquals("negative", gammaModel.startGamma("-2.0"));
  }
  
  
  @Test
  public void testNegativeNumber2() {
    assertEquals("1.0", gammaModel.startGamma("-0.0"));
  }
  
  
  @Test
  public void testZeroValue() {
    assertEquals("1.0", gammaModel.startGamma("0.0"));
  }
  
  @Test
  public void testNormalPositiveNumber1() {
    assertEquals("479001600.000", gammaModel.startGamma("13.0"));
  }
  
  @Test
  public void testNormalPositiveNumber2() {
    assertEquals("120.000", gammaModel.startGamma("6.0"));
  }
  
  @Test
  public void testKnownConstant() {
    assertEquals("1.710", gammaModel.startGamma("0.5"));
  }  
  

}

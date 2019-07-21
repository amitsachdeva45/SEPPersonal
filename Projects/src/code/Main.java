/**
 * 
 */
package code;

/**
 * @author Amit Sachdeva
 *
 */

//https://www.youtube.com/watch?v=w8cDDcTD9WY
public class Main {

	public Main() {
		GammaModel tempModel = new GammaModel();
		GammaView tempView = new GammaView("Gamma Calculator");
		tempView.setBasicLayout();
		GammaController tempController = new GammaController(tempModel, tempView);
		tempController.startController();
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Main main = new Main();	

	}

}


package code;

import java.util.ArrayList;

/**
 * This class act as a model which is responsible for data storage.
 * @author Amit Sachdeva
 *
 */
public class GammaModel {
  private ArrayList<String[]> historyData;
  private static final double CONSTANT_HEIGHT = 1E-3;
  private static final int UPPER_BOUND = 201;
  private static final double EXPONENT = 2.71828182846;
  
  GammaModel() {
    this.historyData = new ArrayList<String[]>();
  }
  
  private double integration(double value, double lowerLimit, 
      double upperLimit) {
    double summation = 0.0;
    for (double index = lowerLimit + CONSTANT_HEIGHT; 
        index < upperLimit; index += CONSTANT_HEIGHT) {
      double differnce = index - lowerLimit;
      if (lowerLimit + differnce  != 0 && lowerLimit + differnce  - CONSTANT_HEIGHT != 0) {
        summation += (mainOperation(value, lowerLimit + differnce) 
           + mainOperation(value, lowerLimit + differnce - CONSTANT_HEIGHT));
      }
    }
    summation = (CONSTANT_HEIGHT / 2) * summation;
    if (value < 19) {
      return (Math.round(summation * 1000.0) / 1000.0);
    } else {
      return summation;
    }
  }
  
  private double mainOperation(double value, double x) {
    return Math.pow(x, value) * Math.pow(EXPONENT, -x);
  }
  
  private double gammaCalculation(double value) {
    return integration(value, 0, UPPER_BOUND);
  }
  /**
   * This function is responsible for handling errors and performing gamma function.
   * @param input Input by user
   * @return Result after applying gamma function operation.
   */
  
  public String startGamma(String input) {
    String[] storageData = new String[2];
    storageData[0] = input;
    storageData[1] = "Wrong Input Type";
    String output = "error";
    try {
      String[] temp = input.split("\\+");
      double value = Double.valueOf(temp[0].trim());
      if (value < 0) {
        storageData[1] = "Negative Input Error";
        output = "negative";
      } else if (value == 0 || value == 1) {
        storageData[1] = "1.0";
        output = "1.0";
      } else if (value > 60) {
        storageData[1] = "Infinity";
        output = "infinity";
      } else {
        value = value - 1;
        String result = String.valueOf(this.gammaCalculation(value));
        storageData[1] = result;
        output = result;
      }
    } catch (Exception e) {
      storageData[1] = "Wrong Input Type";
      output = "error";
    }
    this.historyData.add(storageData);
    return output;
  }
  
  public ArrayList<String[]> getHistoryData() {
    return this.historyData;
  }

  public void setHistoryData() {
    this.historyData = new ArrayList<String[]>();
  }
}



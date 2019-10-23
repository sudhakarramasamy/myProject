package dataProvider;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

public class dataProvider {
  @Test(dataProvider = "dp")
  public void f(Integer n, String s) {
  }

  @DataProvider
  public Object[][] dp() {
    return new Object[][] {
      new Object[] { 1, "a" },
      new Object[] { 2, "b" },
    };
  }
}


// It's always advisable to store the data provider in a separate class and call the class whenever required. Declare methods as static.
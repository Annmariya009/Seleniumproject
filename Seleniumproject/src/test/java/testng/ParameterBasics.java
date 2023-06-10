package testng;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterBasics {
  @Test
  @Parameters({"para1","para2"})
  public void parametersTest(int a,String b) {
	  System.out.println(a);
	  System.out.println(b);
  }
  
}

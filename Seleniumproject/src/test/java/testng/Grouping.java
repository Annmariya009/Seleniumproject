package testng;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Grouping {
 
	 @Test(groups = {"Critical"})
	  public void testcase1() {
		  System.out.println("test case1 is executed");
	  }
	 @Test(groups = {"High"})
	  public void testcase2() {
		  System.out.println("test case2 is executed");
	  }
	 @Test(groups = {"Critical"})
	  public void testcase3() {
		  System.out.println("test case3 is executed");
	  }
	 @Test
	  public void testcase4() {
		  System.out.println("test case4 is executed");
	  }
	 @Test
	  public void testcase5() {
		  System.out.println("test case5 is executed");
	  }
	 @BeforeMethod(alwaysRun = true)
	 public void beforeMethod()
	 {
		 System.out.println("beforeMethod");
	 }
	 @AfterMethod(alwaysRun = true)
	 public void afterMethod()
	 {
		 System.out.println("afterMethod");

	 }
	 
	 
}

package testng;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

public class AnnotationBasics {
  @Test
  public void testcase01() {
	  System.out.println("Testcase hi is executed");
  }
  @Test
  public void testcase02() {
	  System.out.println("Testcase 2 is executed");
  }
  @Test
    public void testcase03() {
	  System.out.println("Testcase 3 is executed");
  }
  
//  @BeforeMethod
//  public void beforeMethod() {
//	  System.out.println("Before method is executed");
//  }
//
//  @AfterMethod
//  public void afterMethod() {
//	  System.out.println("After method is executed");
//  }
//  @BeforeClass
//  public void beforeClass() {
//	  System.out.println("Before class is executed");
//  }
//
//  @AfterClass
//  public void afterClass() {
//	  System.out.println("After class is executed");
//  }
  @BeforeTest
  public void beforeTest() {
	  System.out.println("Before test is executed");
  }

  @AfterTest
  public void afterTest() {
	  System.out.println("After test is executed");
  }
  
//  @BeforeSuite
//  public void beforeSuite() {
//	  System.out.println("Before test is executed");
//  }
//
//  @AfterSuite
//  public void afterSuite() {
//	  System.out.println("After test is executed");
//  }
}

package testng;

import org.testng.annotations.Test;

public class SampleClass {
	@Test(priority = 2)
	public void testcase01() {
		System.out.println("Testcase 01 is executed");
	}

	@Test(enabled = false)
	public void testcase02() {
		System.out.println("Testcase 02 is executed");
	}

	@Test
	public void testcase03() {
		System.out.println("Testcase 03 is executed");
	}

	@Test(priority = 1)
	public void testcase04() {
		System.out.println("Testcase 04 is executed");
	}

}

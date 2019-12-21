package bpb.assertions;

import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class Assertions {
	public Assertions() {
		SoftAssert softAssert = new SoftAssert();
	}
	
	public void assertEquals(String actual,String expected) {
		Assert.assertEquals(actual, expected);
	}

}

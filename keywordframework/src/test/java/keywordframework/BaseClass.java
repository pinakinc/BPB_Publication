package keywordframework;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import bpb.Singleton.SingletonDriver;

public class BaseClass {
	@Parameters({"browser","platform","environment"})
	@BeforeSuite(alwaysRun=true, enabled=true)
	protected void suiteSetup(@Optional(Default_Values.BROWSER) String browser,
	                          @Optional(Default_Values.ENVIRONMENT) String environment,
	                          @Optional(Default_Values.PLATFORM) String
	platform)
	                          throws Exception {

		Default_Values.DEFT_BROWSER = System.getProperty("browser", browser);
		Default_Values.DEFT_PLATFORM = System.getProperty("platform", 
	    platform);
		Default_Values.DEFT_ENVIRONMENT = System.getProperty("environment",
	                                                      environment);

		System.out.println(Default_Values.DEFT_PLATFORM);
	    SingletonDriver.getInstance().setDriver(Default_Values.DEFT_BROWSER,
	    		Default_Values.DEFT_ENVIRONMENT,Default_Values.DEFT_PLATFORM
	    		);
	}	

}

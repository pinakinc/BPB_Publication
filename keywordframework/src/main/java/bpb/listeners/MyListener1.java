package bpb.listeners;

import org.testng.ISuite;
import org.testng.ISuiteListener;

public class MyListener1 implements ISuiteListener{
	public void onStart(ISuite suite) {
		System.out.println("TestNG default output directory = "+suite.getOutputDirectory());
		}

	public void onFinish(ISuite suite) {
		System.out.println("TestNG has invoked methods = " +suite.getAllInvokedMethods());
	}
}

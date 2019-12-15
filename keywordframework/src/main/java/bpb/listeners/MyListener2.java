package bpb.listeners;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class MyListener2 implements ITestListener{

		public void onTestStart(ITestResult result) {
			System.out.println("Test Started. "+result.getStartMillis());
		}

		public void onTestSuccess(ITestResult result) {
			System.out.println("Test Success. "+result.getEndMillis());
		}

		public void onTestFailure(ITestResult result) {
			System.out.println("Test Failed. "+result.getTestName());
		}

		public void onTestSkipped(ITestResult result) {
			System.out.println("Test Skipped. "+result.getTestName());
		}

		public void onTestFailedButWithinSuccessPercentage(ITestResult result) {		
		}

		public void onStart(ITestContext context) {
			System.out.println("Context Name = "+context.getName());
		}

		public void onFinish(ITestContext context) {
			System.out.println(context.getPassedTests());
		}
	}

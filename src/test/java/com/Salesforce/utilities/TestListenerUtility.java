package com.Salesforce.utilities;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListenerUtility implements ITestListener{

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println(result.getName()+" started------");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println(result.getName()+" ended with success------------");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println(result.getName()+" ended with failure------------");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println(context.getName()+ "Test has started------------------");
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println(context.getName()+"Test has ended-------------");
	}
	
	
	

}
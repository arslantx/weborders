package com.weborders.reporters;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class WebOrdersTestListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        ExtentTestReporter.report(result);
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ExtentTestReporter.report(result);
    }

    
    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentTestReporter.report(result);
    }
    
    @Override
    public void onTestStart(ITestResult result) {
        ITestListener.super.onTestStart(result);
    }
    
    @Override
    public void onFinish(ITestContext context) {
        ITestListener.super.onFinish(context);
    }

    @Override
    public void onStart(ITestContext context) {
        ITestListener.super.onStart(context);
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        ITestListener.super.onTestFailedWithTimeout(result);
    }
}
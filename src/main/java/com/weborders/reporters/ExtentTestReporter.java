package com.weborders.reporters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.ITestResult;
import freemarker.template.utility.HtmlEscape;

public class ExtentTestReporter {

   private static final String REPORT_FILE_PATH = System.getProperty("user.dir") + "\\test-output\\ExtentReportResults.html";
   
   private static ExtentReports extentReport;
   private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();
   
   public static synchronized ExtentReports createReport() {
       if (extentReport == null) {
           ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(REPORT_FILE_PATH);
           htmlReporter.config().setTheme(Theme.STANDARD);
           htmlReporter.config().setDocumentTitle("WebOrders - Automated Test Results");
           htmlReporter.config().setReportName("WebOrders - Automated Test Results");
           htmlReporter.config().setEncoding("utf-8");
           extentReport = new ExtentReports();
           extentReport.attachReporter(htmlReporter);
           extentReport.setSystemInfo("Project : ", "WebOrders");
           extentReport.setSystemInfo("System OS : ", System.getProperty("os.name"));
       }
       return extentReport;
   }

   public synchronized static ExtentTest createTest(String testName) {
       ExtentTest test = extentReport.createTest(testName);
       extentTest.set(test);
       return extentTest.get();
   }

   public synchronized static void endTest() {
       extentReport.flush();
   }

   public synchronized static void logInfo(String message) {
       if (extentTest != null) {
           extentTest.get().info(message);
       }
   }

   public synchronized static void report(ITestResult iTestResult) {
       if (iTestResult.getStatus() == 1) {
           // Test passed
           extentTest.get().pass("Test Result: PASS");
       } else if (iTestResult.getStatus() == 2) {
           extentTest.get().fail("Test Result: FAIL");
           extentTest.get().error(iTestResult.getThrowable());
       } else if (iTestResult.getStatus() == 3) {
           extentTest.get().skip("Test Result: SKIP");
           extentTest.get().error(iTestResult.getThrowable());
       }
   }
}
package com.crm.GenericLibrary;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerImplementation  implements ITestListener{
	ExtentReports reports;
	ExtentTest test;
	public void onTestStart(ITestResult result) {
      String methodname = result.getMethod().getMethodName();
      test = reports.createTest(methodname);
      
	}

	public void onTestSuccess(ITestResult result) {
		 String methodname = result.getMethod().getMethodName();
test.log(Status.PASS, methodname+"--------->passed");	}

	public void onTestFailure(ITestResult result) {
		String path = null;
		String methodname = result.getMethod().getMethodName();
	      Reporter.log(methodname+" test script failed");
	      JavaUtility jlib=new JavaUtility();
		String screenshotname = methodname+jlib.getSystemDateInFormat();
		System.out.println(screenshotname);
	      WebDriverUtility wlib=new WebDriverUtility();
	      
	      try {
			wlib.getScreenShot(BaseClass.sdriver, screenshotname);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			test.log(Status.FAIL, methodname+"-------->failed");
			//it will capture the exception  and log in to the report
			test.log(Status.FAIL, result.getThrowable());
			test.addScreenCaptureFromPath(path);
		}
	}

	public void onTestSkipped(ITestResult result) {
		String methodname = result.getMethod().getMethodName();
		test.log(Status.SKIP,methodname+"------->SKIPPED");
	      test.log(Status.SKIP, result.getThrowable());
	      
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
	}

	public void onStart(ITestContext context) {
		//execute will starts here
		/*configure  the report*/
	ExtentSparkReporter htmlreport=new ExtentSparkReporter("./ExtentReports/Report"+new JavaUtility().getSystemDateInFormat()+".html");
	htmlreport.config().setDocumentTitle("SDET-30 EXECUTION REPORT");
	htmlreport.config().setTheme(Theme.DARK);
	htmlreport.config().setReportName("Selenium execution report");
	
 reports=new ExtentReports();
	reports.attachReporter(htmlreport);
	reports.setSystemInfo("Base-Browser", "chrome");
	reports.setSystemInfo("OS", "windows");
	reports.setSystemInfo("Base-URL", "http://localhost:8888");
	reports.setSystemInfo("Reporter-Name", "Rafeek");
	
	}

	public void onFinish(ITestContext context) {
		//consolidate all the parameters and generate the reports
	reports.flush();	
	}

}

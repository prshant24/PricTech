package com.crm.listeners;

import java.time.LocalDateTime;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Create_Locked_Mesg implements ITestListener{
	
	public static ExtentReports report;
	public static ExtentSparkReporter spark;
	public static ExtentTest test;

	@Override
	public void onTestStart(ITestResult result) {
		String t_name = result.getMethod().getMethodName();
		Reporter.log(t_name+" is executed");
		test=report.createTest(t_name);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String t_name = result.getMethod().getMethodName();
		test.log(Status.PASS, t_name+"is success");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		test.log(Status.FAIL,"");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String t_name = result.getMethod().getMethodName();
		test.log(Status.SKIP, t_name+"is Skipped");
	}

	@Override
	public void onStart(ITestContext context) {
		//create spark reporter
		LocalDateTime Date = LocalDateTime.now();
		String time = Date.toString().replace(":", "-");
		 spark=new ExtentSparkReporter("./Reports/LockedMessegeReport.html");
		//configure the spark reporter
		spark.config().setDocumentTitle("SampleReport");
		spark.config().setReportName("Prashant");
		spark.config().setTheme(Theme.DARK);
		//create the extent report
		 report = new ExtentReports();
		//configure extent report
		report.setSystemInfo("Os","Window-10");
		report.setSystemInfo("Browser", "Chrome-100");
		//attach the spark reporter to the extent report
		report.attachReporter(spark);
	}

	@Override
	public void onFinish(ITestContext context) {
		report.flush();
	}
	
	
	

}

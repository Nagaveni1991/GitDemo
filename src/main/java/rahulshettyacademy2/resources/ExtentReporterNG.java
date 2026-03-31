package rahulshettyacademy2.resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {
	
	public static ExtentReports getReportObject()
	{
		//ExtentReports, ExtentSparkReporter
				String path = System.getProperty("user.dir")+"\\reports\\index.html";
				ExtentSparkReporter reporter = new ExtentSparkReporter(path);
				reporter.config().setReportName("Web Automation Result");    //here we are setting name of the Report
				reporter.config().setDocumentTitle("Test Results");      //here we are setting title of the document
				
				ExtentReports extent = new ExtentReports();
				extent.attachReporter(reporter);
				extent.setSystemInfo("Tester", "Rahul Shetty");  // here we are adding Tester name to the reporter
				return extent;
	}

}

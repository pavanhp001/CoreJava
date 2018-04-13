package com.OpenClosePrinciple1;

public class ReportingService {

	public void generateReportBasedOnType(ReportingType reportingType)
	{
		System.out.println("===================================");
		System.out.println("Generating report based on Type");
		System.out.println("===================================");
		
		if("CSV".equalsIgnoreCase(reportingType.toString()))
		{
			generateCSVReport();
		}
		else if("XML".equalsIgnoreCase(reportingType.toString()))
		{
			generateXMLReport();
		}
		else if("Excel".equalsIgnoreCase(reportingType.toString()))
		{
			generateExcelReport();
		}
	}
	
	private void generateCSVReport()
	{
		System.out.println("Generate CSV Report");
	}
	
	private void generateXMLReport()
	{
		System.out.println("Generate XML Report");
	}
	
	private void generateExcelReport() {
		System.out.println("Generate Excel Report");
	}
}

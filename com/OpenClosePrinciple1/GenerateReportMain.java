package com.OpenClosePrinciple1;

public class GenerateReportMain {

	public static void main(String[] args) {
		ReportingService rs=new ReportingService();
		
		// Generate CSV file
		rs.generateReportBasedOnType(ReportingType.CSV);
		
		System.out.println();
		
		// Generate XML file
		rs.generateReportBasedOnType(ReportingType.XML);
		
		System.out.println();
		
		// Generate Excel file
		rs.generateReportBasedOnType(ReportingType.EXCEL);		
	}
}

package com.OpenClosePrinciple.solution;

public class GenerateReportMain {

	public static void main(String[] args) {
		ReportingService rs=new ReportingService();
 
		//Generate CSV report
		ReportingStrategy csvReportingStrategy=new CSVReportingStrategy();
		rs.generateReportBasedOnStrategy(csvReportingStrategy);
 
		//Generate XML report
		ReportingStrategy xmlReportingStrategy=new XMLReportingStrategy();
		rs.generateReportBasedOnStrategy(xmlReportingStrategy);
		
		ReportingStrategy excelReportingStrategy=new ExcelReportingStrategy();
		rs.generateReportBasedOnStrategy(excelReportingStrategy);
	}
}

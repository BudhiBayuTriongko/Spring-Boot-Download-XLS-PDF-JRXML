package com.jrxml.pdf.report;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRXlsExporter;

/* Read these point first

- get path and name file (jrxml file)
- open and compile jrxml file 
- print jrxml file
- get path and name file (xls file)
- extract xls file
- thanks

*/

public class XLSGenerator extends JRXMLGenerator implements ReportGenerator{

	JRXlsExporter exporter = null;
	File file = null;
	
	public void generateReportFile(Map<String, Object> param) {
		JasperReport jrxmlFile = null;
    	JasperPrint jasperPrint = null;
    	 	
    	try {
    		
	    	//list object request to memory	
	    	parameters =  new HashMap<String, Object>();
	    	dataSource = new JREmptyDataSource();
	    	
	    	this.getPathAndNameFromFile(file,CONSTANT_HELPER.JRXML_FILENAME);// this Method for get path and name file (jrxml file)
	    	jrxmlFile = this.compileJRXMLFile (jrxmlFile,filePathAndName);//this method open and compile jrxml file	
	    	jasperPrint = this.printJRXMLFile(jasperPrint, jrxmlFile);//this method print jrxml file	  
	    	this.getPathAndNameFromFile(file,CONSTANT_HELPER.EXCEL_DOWNLOAD_FILENAME);// this Method for get path and name file (xls file)
	    	this.exportReportToXlsFile(jasperPrint);// Extract xls file
	    	
        
		} catch (JRException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.clearActiveObject();
		}
        System.out.println("Done!");
		
	}
	
	
	@SuppressWarnings({ CONSTANT_HELPER.SUPPRESS_WARNINGS_DEPRECATION })
	private void exportReportToXlsFile (JasperPrint jasperPrint)throws JRException, Exception{
		try {
			exporter = new JRXlsExporter();
			exporter.setParameter(net.sf.jasperreports.engine.JRExporterParameter.JASPER_PRINT,
					jasperPrint);
	             exporter.setParameter(net.sf.jasperreports.engine.JRExporterParameter.OUTPUT_FILE_NAME,
	            		 this.getPathAndNameFromFile(file,CONSTANT_HELPER.EXCEL_DOWNLOAD_FILENAME));
	             exporter.exportReport();
	            
		} catch (JRException e) {
			throw new JRException(e.getMessage());
		} catch (Exception e) {
			throw new JRException(e.getMessage());
		}
    }
	
	private void clearActiveObject(){
		exporter = null;
		file = null;
	}

}

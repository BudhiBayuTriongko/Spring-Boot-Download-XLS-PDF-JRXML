package com.jrxml.pdf.report;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;


/* Read these point first

- get path and name file (jrxml file)
- open and compile jrxml file 
- print jrxml file
- get path and name file (pdf file)
- export to pdf file
- thanks

*/

public class PDFGenerator extends JRXMLGenerator implements ReportGenerator{

	
	public void generateReportFile(Map<String, Object> param) {
		JasperReport jrxmlFile = null;
    	JasperPrint jasperPrint = null;
    	File file = null;
    	 	
    	try {
    		
	    	//list object request to memory	
	    	parameters =  new HashMap<String, Object>();
	    	dataSource = new JREmptyDataSource();
	    	
	    	this.getPathAndNameFromFile(file,CONSTANT_HELPER.JRXML_FILENAME);// this Method for get path and name file (jrxml file)
	    	jrxmlFile = this.compileJRXMLFile (jrxmlFile,filePathAndName);//this method open and compile jrxml file	
	    	jasperPrint = this.printJRXMLFile(jasperPrint, jrxmlFile);//this method print jrxml file	  
	    	this.getPathAndNameFromFile(file,CONSTANT_HELPER.PDF_DOWNLOAD_FILENAME);// this Method for get path and name file (pdf file)
	    	this.exportReportToPdfFile(jasperPrint, filePathAndName);// this method export to PDF File.
        
		} catch (JRException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
        System.out.println("Done!");
		
	}
	
	private void exportReportToPdfFile (JasperPrint jasperPrint, String path)throws JRException, Exception{
    	
    	try {
    		JasperExportManager.exportReportToPdfFile(jasperPrint,path);
		} catch (JRException e) {
			throw new JRException(e.getMessage());
		} catch (Exception e) {
			throw new JRException(e.getMessage());
		}
    }

}

package com.jrxml.pdf.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import com.jrxml.pdf.report.CONSTANT_HELPER;
import com.jrxml.pdf.report.PDFGenerator;
import com.jrxml.pdf.report.ReportGenerator;
import com.jrxml.pdf.report.StreamReport;
import com.jrxml.pdf.report.XLSGenerator;


import java.io.File;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;


@RestController  // Also possible to @Controller here
public class StreamingResponseBodyController extends StreamReport{
	
	File file = null;
	ReportGenerator repotGenerate = null;
	String result = CONSTANT_HELPER.EMPTY_STRING;
			
	
    @RequestMapping(value = CONSTANT_HELPER.PDF_REQUEST_MAPPING, method = RequestMethod.POST)
    public StreamingResponseBody getPdfFile(@RequestBody Map<String, Object> param, HttpServletResponse response) throws Exception {
    	
    	try {
    		result = CONSTANT_HELPER.PDF_DOWNLOAD_FILENAME;
    		
    		repotGenerate =  new PDFGenerator();
        	repotGenerate.generateReportFile(param);

        	response.setContentType(CONSTANT_HELPER.PDF_CONTENT_TYPE);
        	response.setHeader(CONSTANT_HELPER.HEADER_CONTENT_DISPOSITION, CONSTANT_HELPER.PDF_HEADER_ATTACHMENT_FILENAME);
        	
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			file = null;
			repotGenerate = null;
			result = CONSTANT_HELPER.EMPTY_STRING;
		}
    	return StreamReport.printReportStream(file,result);  
    }
    
    
    
    @RequestMapping(value = CONSTANT_HELPER.EXCEL_REQUEST_MAPPING, method = RequestMethod.POST)
    public StreamingResponseBody getExcelFile(@RequestBody Map<String, Object> param, HttpServletResponse response) throws Exception {
    	
    	try {    		
    		result = CONSTANT_HELPER.EXCEL_DOWNLOAD_FILENAME;
    		repotGenerate = new XLSGenerator();
    		repotGenerate.generateReportFile(param);
        	
        	response.setContentType(CONSTANT_HELPER.EXCEL_CONTENT_TYPE);
       	 	response.setHeader(CONSTANT_HELPER.HEADER_CONTENT_DISPOSITION, CONSTANT_HELPER.EXCEL_HEADER_ATTACHMENT_FILENAME);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			file = null;
			repotGenerate = null;
			result = CONSTANT_HELPER.EMPTY_STRING;
		}
    	
    	return StreamReport.printReportStream(file,result);  
        
    }
    

}


/*Old 
 * JRXMLGenerator jrxmlGenerator = new JRXMLGenerator();
jrxmlGenerator.generateReportPdfFile(param);*/
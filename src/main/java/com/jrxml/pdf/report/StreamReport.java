package com.jrxml.pdf.report;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;


public abstract class StreamReport{
	private static JRXMLGenerator jrxmlGen = null;
	
	static{
		jrxmlGen =  new JRXMLGenerator();
	}
	
	@SuppressWarnings(CONSTANT_HELPER.SUPPRESS_WARNINGS_RESOURCE)
	public static StreamingResponseBody printReportStream (File file, String result) throws FileNotFoundException, Exception{
		
		InputStream inputStream = new FileInputStream(new File(jrxmlGen.getPathAndNameFromFile(file,result)));
        return outputStream -> {
            int nRead;
            byte[] data = new byte[1024];
            while ((nRead = inputStream.read(data, 0, data.length)) != -1) {
                System.out.println("Writing some bytes..");
                outputStream.write(data, 0, nRead);
            }
        };
	}

}

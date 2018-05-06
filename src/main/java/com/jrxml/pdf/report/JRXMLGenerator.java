package com.jrxml.pdf.report;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;


/* Read these point first

- open and compile jrxml file 
- print jrxml file
- get path and name file (file)
- Set Parameter
- thanks

*/

public class JRXMLGenerator {
	
	//list global variable initialized declaration
	JRDataSource dataSource = null;
	Map<String, Object> parameters = null;
	boolean result = false;
	String filePathAndName= CONSTANT_HELPER.EMPTY_STRING;
	
	protected JasperReport compileJRXMLFile (JasperReport jrxmlFile, String path)throws JRException, Exception{
    	
    	try {
    		jrxmlFile	= JasperCompileManager.compileReport(path);
		} catch (JRException e) {
			throw new JRException(e.getMessage());
		} catch (Exception e) {
			throw new JRException(e.getMessage());
		}
    	return jrxmlFile;
	
    }
    
	protected JasperPrint printJRXMLFile (JasperPrint jasperPrint, JasperReport jrxmlFile)throws JRException, Exception{
    	
    	try {
    		jasperPrint = JasperFillManager.fillReport(jrxmlFile,
    		        this.setParameterGoToPrint(), dataSource);
    		
    	} catch (JRException e) {
			throw new JRException(e.getMessage());
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
    	return jasperPrint;
    }
    
	protected String getPathAndNameFromFile (File file, String fileName)throws Exception{
    	ClassLoader classLoader;
    	try {
    		classLoader = getClass().getClassLoader();
    		file = new File (classLoader.getResource(fileName).getFile());
	    	filePathAndName = file.getPath();
	    	System.out.println("Isi PATH" + filePathAndName);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
    	return filePathAndName;
    }
	
    
	protected Map<String, Object> setParameterGoToPrint(){
    	Model model = new Model();
    	List<Model> list = new ArrayList<Model>();
    	parameters = new HashMap<String, Object>();
    	model.setNo(1);
    	model.setNamaPelanggan("Test");
    	model.setNoKontrak(1);
    	model.setOrderId( "test");
    	model.setKodeProduk("test");
    	model.setNamaProduk("test");
    	model.setNamaPartner("test");
    	model.setNamaBarang("test");
    	model.setPembayaran("test");
    	model.setTanggalBuat("test");
    	model.setStatus("test");
    	model.setImei("test");
    	model.setNoFaktur("test");
    	model.setNamaPos("test");
    	model.setHargaBarang(1000);
    	list.add(model);
    	
    	
    	parameters = new HashMap<String, Object>();
    	model.setNo(2);
    	model.setNamaPelanggan("Test");
    	model.setNoKontrak(2);
    	model.setOrderId( "test");
    	model.setKodeProduk("test");
    	model.setNamaProduk("test");
    	model.setNamaPartner("test");
    	model.setNamaBarang("test");
    	model.setPembayaran("test");
    	model.setTanggalBuat("test");
    	model.setStatus("test");
    	model.setImei("test");
    	model.setNoFaktur("test");
    	model.setNamaPos("test");
    	model.setHargaBarang(2000);
    	list.add(model);
    	dataSource = new JREmptyDataSource();
    	parameters.put(CONSTANT_HELPER.OBJECT_DATASOURCE,list);

    	
    	parameters = new HashMap<String, Object>();
    	model.setNo(2);
    	model.setNamaPelanggan("Test");
    	model.setNoKontrak(2);
    	model.setOrderId( "test");
    	model.setKodeProduk("test");
    	model.setNamaProduk("test");
    	model.setNamaPartner("test");
    	model.setNamaBarang("test");
    	model.setPembayaran("test");
    	model.setTanggalBuat("test");
    	model.setStatus("test");
    	model.setImei("test");
    	model.setNoFaktur("test");
    	model.setNamaPos("test");
    	model.setHargaBarang(2000);
    	list.add(model);
    	dataSource = new JREmptyDataSource();
    	parameters.put(CONSTANT_HELPER.OBJECT_DATASOURCE,list);

    	return parameters;
    }

}

package com.kirwa.webdriver.main;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.log4j.Logger;
import org.w3c.dom.*;

public class Reporter {
	private static Logger LOGGER = Logger.getLogger(Reporter.class.getName());
	public String TCCLASS=""; 
	public Reporter(String TestCaseClass)
	{
		if(Properties.printReport)
		try
		{
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			Document doc = docBuilder.newDocument();
			Element root = doc.createElement("KirWa");
			Element TestSuite = doc.createElement("TestSuite");
			TestSuite.setAttribute("TsName",TestCaseClass);
			TestSuite.setAttribute("TsStartTime",DateUtills.CurrentDateTime());
			root.appendChild(TestSuite);
			doc.setXmlStandalone(true);
			ProcessingInstruction pi = doc.createProcessingInstruction("xml-stylesheet", "type=\"text/xsl\" href=\"rpt1.xsl\"");
			doc.appendChild(root);
			doc.insertBefore(pi, root);
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File(Properties.getProperty("ReportFolder")+"/"+TestCaseClass+Properties.DTSTAMP+".xml"));
			TCCLASS = TestCaseClass;
			transformer.transform(source, result);
		}
		catch(Exception e)
		{
			LOGGER.error(e);
			e.printStackTrace();
		}
	}
	
	public void RPT_TC_Start() throws Exception
	{
		if(Properties.printReport)
		{
		Document doc = rootDoc();
		if(Properties.TCCNTR>0)
		{
			Element TC = (Element) doc.getElementsByTagName("TestCase").item(Properties.TCCNTR-1);
			TC.setAttribute("TcEndTime",  DateUtills.CurrentDateTime());
			TC.setAttribute("TcName",Properties.TestCaseTitle );
			Element KW = (Element) TC.getElementsByTagName("Keyword").item( TC.getElementsByTagName("Keyword").getLength()-1);
			KW.setAttribute("KwEndTime", DateUtills.CurrentDateTime());
			Properties.KWCNTR=0;
		}
		Node root = doc.getElementsByTagName("TestSuite").item(0);
		Element TC = doc.createElement("TestCase");
		TC.setAttribute("TcStartTime", DateUtills.CurrentDateTime());
		TC.setAttribute("ModuleName", Properties.ModuleName);
		root.appendChild(TC);
		SaveDoc(doc);
		Properties.TCCNTR++;}
	}
	public void RPT_KW_Start() throws Exception
	{
		if(Properties.printReport){
		Document doc = rootDoc();
		Element TC = (Element) doc.getElementsByTagName("TestCase").item(Properties.TCCNTR-1);
		if(Properties.KWCNTR>0)
		{
			Element KW = (Element) TC.getElementsByTagName("Keyword").item(Properties.KWCNTR-1);
			KW.setAttribute("KwEndTime", DateUtills.CurrentDateTime());
		}
		Element NewKW = doc.createElement("Keyword");
		NewKW.setAttribute("KwStartTime", DateUtills.CurrentDateTime());
		NewKW.setAttribute("KwName", Thread.currentThread().getStackTrace()[2].getMethodName());
		TC.appendChild(NewKW);
		SaveDoc(doc);
		Properties.KWCNTR++;}
	}
	private Document rootDoc() throws Exception
	{
		String filepath = Properties.getProperty("ReportFolder")+"/"+TCCLASS+Properties.DTSTAMP+".xml";
		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
		return docBuilder.parse(filepath);
	}
	private void SaveDoc(Document doc) throws Exception
	{
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(doc);
		StreamResult result = new StreamResult(new File(Properties.getProperty("ReportFolder")+"/"+TCCLASS+Properties.DTSTAMP+".xml"));
		transformer.transform(source, result);
	}
	public void RPT_Info(String Information) throws Exception
	{
		ReportNote(Information, "Info");
	}
	public void RPT_Error(String Information) throws Exception
	{
		ReportNote(Information, "ERROR");
	}
	public void RPT_Image(String Information) throws Exception
	{
		if(Properties.printReport){
		File theDir = new File(Properties.getProperty("ReportFolder")+"/" + TCCLASS + Properties.DTSTAMP);

		  // if the directory does not exist, create it
		File Source = new File(Information);
		File Destination = new File(Properties.getProperty("ReportFolder")+"/"+TCCLASS+Properties.DTSTAMP+"/"+Source.getName());
		
		if (!theDir.exists()) {
		    System.out.println("creating directory: " + theDir);
		    boolean result = theDir.mkdir();  

		     if(result) {    
		       System.out.println("DIR created");  
		     }
		  }
		  org.apache.commons.io.FileUtils.copyFile(Source, Destination);
		  ReportNote(TCCLASS+Properties.DTSTAMP+"/"+Source.getName(), "Image");
		}
	}
	private void ReportNote(String Information, String Level) throws Exception
	{
		if(Properties.printReport){
		Document doc = rootDoc();
		Element TC = (Element) doc.getElementsByTagName("TestCase").item(Properties.TCCNTR-1);
		Element KW = (Element) TC.getElementsByTagName("Keyword").item(Properties.KWCNTR-1);
		Element newNote = doc.createElement("Note");
		newNote.setAttribute("Level", Level);
		newNote.setAttribute("LogTime", DateUtills.CurrentDateTime());
		newNote.setTextContent(Information);
		KW.appendChild(newNote);
		SaveDoc(doc);
	}
	}

	public void TSEnd(){
		if(Properties.printReport)
		try{
		Document doc = rootDoc();
		Element TC = (Element) doc.getElementsByTagName("TestCase").item(Properties.TCCNTR-1);
		TC.setAttribute("TcEndTime",  DateUtills.CurrentDateTime());
		TC.setAttribute("TcName",Properties.TestCaseTitle );
		Element KW = (Element) TC.getElementsByTagName("Keyword").item( TC.getElementsByTagName("Keyword").getLength()-1);
		KW.setAttribute("KwEndTime", DateUtills.CurrentDateTime());
		Properties.KWCNTR=0;
		SaveDoc(doc);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			LOGGER.error(e);
		}
	}
}

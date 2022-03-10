package testData;

import javax.xml.parsers.DocumentBuilderFactory;  
import javax.xml.parsers.DocumentBuilder;  
import org.w3c.dom.Document;  
import org.w3c.dom.NodeList;  
import org.w3c.dom.Node;  
import org.w3c.dom.Element;  
import java.io.File; 

public class readProperties {
	
	public static String browserPath;
	public static String appurl;
	public static String username;
	public static String pwd;
	
	public void readData() {
		// TODO Auto-generated method stub
		
		try   
		{  
			//creating a constructor of file class and parsing an XML file  
			//File file = new File("D:\\Ram_Office\\Selenium_Dump\\configProperties.xml"); 
			File file = new File("DataManager\\configProperties.xml");
			//an instance of factory that gives a document builder  
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();  
			//an instance of builder to parse the specified xml file  
			DocumentBuilder db = dbf.newDocumentBuilder();  
			Document doc = db.parse(file);  
			doc.getDocumentElement().normalize();  
			System.out.println("Root element: " + doc.getDocumentElement().getNodeName());  
			NodeList nodeList = doc.getElementsByTagName("Login");  
			// nodeList is not iterable, so we are using for loop  
			for (int itr = 0; itr < nodeList.getLength(); itr++)   
			{  
				Node node = nodeList.item(itr);  
				System.out.println("\nNode Name :" + node.getNodeName());  
				if (node.getNodeType() == Node.ELEMENT_NODE)   
				{  
					Element eElement = (Element) node;  
					browserPath = eElement.getElementsByTagName("chrome").item(0).getTextContent();  
					appurl = eElement.getElementsByTagName("url").item(0).getTextContent();  
					username = eElement.getElementsByTagName("login").item(0).getTextContent();
					pwd = eElement.getElementsByTagName("password").item(0).getTextContent(); 
				}  
			}  
		}   
		catch (Exception e)   
		{  
			e.printStackTrace();  
		}

	} // End of readData
	
} // End of Class
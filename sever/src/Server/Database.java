package com.socket;

import java.io.*;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.*;

public class Database {
    
    public String filePath;
    
    public Database(String filePath){
        this.filePath = filePath;
    }

    
    //checking user exists or not !!
    public boolean userExists(String username){
        
        //String fileName = "D:\\LanProject\\src\\Server\\newfile.xml";
        String line = null;
        ArrayList<String> userId = new ArrayList<String>();

        try {
            FileReader fileReader = new FileReader(filePath);  
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while ((line = bufferedReader.readLine()) != null) {
                String [] strArray = line.split("\\s+");
                userId.add(strArray[0]);
            }
            
            for(int i = 0; i < userId.size(); i++){
                if(userId.get(i).equals(username)){
                    System.out.println("User exits");
                    return true;
                }
            }
            
            bufferedReader.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Unable to open file '" + filePath + "'");
            
        } catch (IOException ex) {
            System.out.println("Error reading file '"+ filePath + "'");
        }    
        return false;
    }
    
    
    
    public boolean checkLogin(String username, String password){

        //String fileName = "D:\\LanProject\\src\\Server\\newfile.xml";
        String line = null;
        ArrayList<String> userId = new ArrayList<String>();
        ArrayList<String> passwId = new ArrayList<String>();

        try {
            FileReader fileReader = new FileReader(filePath);  
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while ((line = bufferedReader.readLine()) != null) {
                String [] strArray = line.split("\\s+");
                userId.add(strArray[0]);
                passwId.add(strArray[1]);
            }
            
            for(int i = 0; i < userId.size(); i++){
                if(userId.get(i).equals(username) && passwId.get(i).equals(password)){
                    System.out.println("Login successful");
                    return true;
                }
            }
            
            bufferedReader.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Unable to open file '" + filePath + "'");
            
        } catch (IOException ex) {
            System.out.println("Error reading file '"+ filePath + "'");
        }    
        return false;
    }
    
    /*
    public boolean userExists(String username){
        
        try{
            File fXmlFile = new File(filePath);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);
            doc.getDocumentElement().normalize();
            
            NodeList nList = doc.getElementsByTagName("user");
            
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    if(getTagValue("username", eElement).equals(username)){
                        return true;
                    }
                }
            }
            return false;
        }
        catch(Exception ex){
            System.out.println("Database exception : userExists()");
            return false;
        }
    }
    
    public boolean checkLogin(String username, String password){
        
        if(!userExists(username)){ return false; }
        
        try{
            File fXmlFile = new File(filePath);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);
            doc.getDocumentElement().normalize();
            
            NodeList nList = doc.getElementsByTagName("user");
            
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    if(getTagValue("username", eElement).equals(username) && getTagValue("password", eElement).equals(password)){
                        return true;
                    }
                }
            }
            System.out.println("Hippie");
            return false;
        }
        catch(Exception ex){
            System.out.println("Database exception : userExists()");
            return false;
        }
    }
    
    public void addUser(String username, String password){
        
        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.parse(filePath);
 
            Node data = doc.getFirstChild();
            
            Element newuser = doc.createElement("user");
            Element newusername = doc.createElement("username"); newusername.setTextContent(username);
            Element newpassword = doc.createElement("password"); newpassword.setTextContent(password);
            
            newuser.appendChild(newusername); newuser.appendChild(newpassword); data.appendChild(newuser);
            
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(filePath));
            transformer.transform(source, result);
 
	   } 
           catch(Exception ex){
		System.out.println("Exceptionmodify xml");
	   }
	}
    
    public static String getTagValue(String sTag, Element eElement) {
	NodeList nlList = eElement.getElementsByTagName(sTag).item(0).getChildNodes();
        Node nValue = (Node) nlList.item(0);
	return nValue.getNodeValue();
  }
    
  */
}

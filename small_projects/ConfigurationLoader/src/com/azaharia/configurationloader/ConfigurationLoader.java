package com.azaharia.configurationloader;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by Zaharia Costin-Alexandru, email: zaharia.c.alexandru@gmail.com on 11/7/2016.
 */
public class ConfigurationLoader {
    private static ConfigurationLoader instance = new ConfigurationLoader();
    private static Map<String,String> configMap = new HashMap<String,String>();

    private ConfigurationLoader(){}

    public static ConfigurationLoader getInstance(){
        parseXml();
        return instance;

    }

    public Object getProperty(String propName){
        if(System.getProperty(propName) != null){
            return (String) System.getProperty(propName);
        }
            return (String) configMap.get(propName);

    }

    private static void parseXml(){
        try {
            File fXmlFile = new File("configuration.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);

            doc.getDocumentElement().normalize();

            for(Node n : XmlUtil.asList(doc.getElementsByTagName("property"))){
                Element eElement = (Element) n;
                configMap.put(eElement.getElementsByTagName("name").item(0).getTextContent(),eElement.getElementsByTagName("value").item(0).getTextContent());
            }

        } catch (SAXException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}

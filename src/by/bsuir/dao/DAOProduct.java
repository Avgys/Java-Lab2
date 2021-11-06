package by.bsuir.dao;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import by.bsuir.entity.Kettle;
import by.bsuir.entity.Oven;
import by.bsuir.entity.Phone;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import by.bsuir.entity.Product;

public class DAOProduct {

    private Document doc;
        public DAOProduct(String filePath) {
        try {
            DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            this.doc = documentBuilder.parse(new File(filePath));
            this.doc.getDocumentElement().normalize();
            Node root = this.doc.getDocumentElement();
        } catch (ParserConfigurationException ex) {
            ex.printStackTrace(System.out);
        } catch (SAXException ex) {
            ex.printStackTrace(System.out);
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
    }

    public static Product ParseNode(Element node) throws Exception{
        String productType = node.getAttribute("type");
        String name = node.getElementsByTagName("name").item(0).getTextContent();
        String priceStr = node.getElementsByTagName("price").item(0).getTextContent();
        int price = Integer.parseInt(priceStr);
        switch(productType){
            case "kettle":{
                String capacityStr = node.getElementsByTagName("capacity").item(0).getTextContent();
                int capacity = Integer.parseInt(capacityStr);
                return new Kettle(price, name, capacity);
            }
            case "oven":{
                int height = Integer.parseInt(node.getElementsByTagName("height").item(0).getTextContent());
                int width = Integer.parseInt(node.getElementsByTagName("width").item(0).getTextContent());
                return new Oven(price, name, height, width);
            }
            case "phone":{
                String color = node.getElementsByTagName("color").item(0).getTextContent();
                int diagonal = Integer.parseInt(node.getElementsByTagName("diagonal").item(0).getTextContent());
                return new Phone(price, name, color, diagonal);
            }
        }
        throw new Exception();
    }

    public interface CriteriaFunc {
        public void ProcessProduct(Product product);
    }

    public void FindProducts(CriteriaFunc criteriaFunc){
        Element root = this.doc.getDocumentElement();
        NodeList products = this.doc.getElementsByTagName("product");
        for (int i = 0; i < products.getLength(); i++){
            final Node node = products.item(i);
            try {
                if(node.getNodeType() == Node.ELEMENT_NODE) {
                    Product product = ParseNode((Element) node);
                    criteriaFunc.ProcessProduct(product);
                }
            }catch(Exception ex){
                continue;
            }
        }
    }
}

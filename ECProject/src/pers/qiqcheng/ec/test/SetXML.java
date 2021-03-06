package pers.qiqcheng.ec.test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.output.XMLOutputter;

public class SetXML {
	public static void setInfo(){
		 //定义一个root作为xml文档的根元素
		  Element root = new Element("CDRS"); 
		  //生成一个文档
		  Document Doc = new Document(root);   
		  for (int j = 1; j <= 5; j++) { 
		   //在生成的名称为CDRS的跟元素下生成下一级元素标签名称为cdr
		      Element elements = new Element("cdr");   
		      
		      //为cdr设置属性名和属性值
		      elements.setAttribute("name", "" + j);   
		      
		      //在cdr标签内部添加新的元素，即cdr的下一级标签，标签属性名为username,值为ss
		      elements.addContent(new Element("username").setText("ss"));
		      elements.addContent(new Element("password").setText("dd"));  
		      //将已经设置好值的elements赋给root
		      root.addContent(elements);  
		      
		     } 
		     //定义一个用于输出xml文档的类
		     XMLOutputter XMLOut = new XMLOutputter();  
		     
		     try {
		   //将生成的xml文档Doc输出到c盘的test.xml文档中
		   XMLOut.output(Doc, new FileOutputStream("E:/test.xml"));
		  } catch (FileNotFoundException e) {
		   // TODO Auto-generated catch block
		   e.printStackTrace();
		  } catch (IOException e) {
		   // TODO Auto-generated catch block
		   e.printStackTrace();
		  } 
	}public SetXML() {
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String[] args) {
		setInfo();
	}

}

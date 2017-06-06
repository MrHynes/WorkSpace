package pers.qiqcheng.ec.test;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

public class JDom {
	public static void main(String[] args) {
		SAXBuilder builder = new SAXBuilder();
		Document doc;
		try {
			doc = builder.build(new File("F:\\WorkSpace\\ECProject\\WebContent\\WEB-INF\\info.xml"));
			Element foo = doc.getRootElement();
			List allChildren = foo.getChildren();
			for (int i = 0; i < allChildren.size(); i++) {
				System.out.print("用户名:" + ((Element) allChildren.get(i)).getChild("name").getText());
				System.out.println("密码:" + ((Element) allChildren.get(i)).getChild("pwd").getText());
			}
		} catch (JDOMException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

}
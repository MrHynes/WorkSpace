package pers.qiqcheng.springmvc.first;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import pers.qiqcheng.springmvc.po.Items;

/**
 * 入门程序
 * 
 * @author Buer
 *
 */
@Controller
public class ItemController3 {

	@RequestMapping("/queryItems")
	public ModelAndView queryItems(){
		// TODO Auto-generated method stub
		List<Items> itemsList = new ArrayList<Items>();

		Items items_1 = new Items();
		items_1.setName("联想笔记本");
		items_1.setPrice(6000f);
		items_1.setCreatetime(new Date());
		items_1.setDetail("ThinkPad T430 联想笔记本电脑！");

		Items items_2 = new Items();
		items_2.setName("苹果手机");
		items_2.setPrice(5000f);
		items_2.setCreatetime(new Date());
		items_2.setDetail("iphone7苹果手机！");

		itemsList.add(items_1);
		itemsList.add(items_2);
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.addObject("itemsList", itemsList);
		modelAndView.setViewName("/itemsList.jsp");
		return modelAndView;
	}
}

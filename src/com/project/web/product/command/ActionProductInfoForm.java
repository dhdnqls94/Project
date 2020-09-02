package com.project.web.product.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.web.product.command.Action;
import com.project.web.product.command.ActionForward;
import com.project.web.product.dto.PDto;

public class ActionProductInfoForm implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ActionForward forward = new ActionForward();
		PDto dto = new PDto();
		
		int no = Integer.parseInt(request.getParameter("no"));
		String name = request.getParameter("name");
		int price = Integer.parseInt(request.getParameter("price"));
		int qty = Integer.parseInt(request.getParameter("qty"));
		int total = Integer.parseInt(request.getParameter("total"));
		
		
		
		System.out.println("InfoForm no : " + no);
		System.out.println("InfoForm name : " + name);
		System.out.println("InfoForm price : " + price);
		System.out.println("InfoForm qty : " + qty);
		System.out.println("InfoForm total : " + total);
		
		request.setAttribute("no", no);
		request.setAttribute("name", name);
		request.setAttribute("price", price);
		request.setAttribute("qty", qty);
		request.setAttribute("total", total);
		
		forward.setRedirect(false);
		forward.setNextPath("WEB-INF/view/product/productinfoform.jsp");
		
		return forward;
		
	}

}

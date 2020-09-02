package com.project.web.product.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ActionBuyForm implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ActionForward forward = new ActionForward();
		
		int no = Integer.parseInt(request.getParameter("no").trim());
		int qty = Integer.parseInt(request.getParameter("qty").trim());
		String name = request.getParameter("name").trim();
//		int category = Integer.parseInt(request.getParameter("category").trim());
		int price = Integer.parseInt(request.getParameter("price").trim());
		String img = request.getParameter("img").trim();
		
		
		request.setAttribute("no", no);
		request.setAttribute("qty", qty);
		request.setAttribute("name", name);
//		request.setAttribute("category", category);
		request.setAttribute("price", price);
		request.setAttribute("img", img);
		
		forward.setRedirect(false);
		forward.setNextPath("WEB-INF/view/product/productbuyform.jsp");
		
		return forward;
		
	}

}

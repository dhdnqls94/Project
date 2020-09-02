package com.project.web.product.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.web.product.dao.PDao;

public class ActionProductDeliveryOkDelete implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ActionForward forward = new ActionForward();
		
		int productnum = Integer.parseInt(request.getParameter("productnum"));
		PDao dao = new PDao();
		
		dao.ProductDeliveryOkDelete(productnum);
		
		forward.setRedirect(false);
		forward.setNextPath("WEB-INF/view/product/productdeliveryokdelete.jsp");
		
		return forward;
	}

}

package com.project.web.product.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.web.product.dao.PDao;

public class ActionProductRefundOk implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ActionForward forward = new ActionForward();
		PDao dao = new PDao();
		int productnum = Integer.parseInt(request.getParameter("productnum"));
		dao.ProductDeleteRefund(productnum);
		
		forward.setRedirect(false);
		forward.setNextPath("WEB-INF/view/product/productdeleterefundok.jsp");
		
		return forward;
	}

}

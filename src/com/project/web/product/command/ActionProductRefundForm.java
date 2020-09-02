package com.project.web.product.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.web.product.dao.PDao;
import com.project.web.product.dto.ProductRefundDto;

public class ActionProductRefundForm implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ActionForward forward = new ActionForward();
		PDao dao = new PDao();
		
		ArrayList<ProductRefundDto> list = dao.ProductRefundList();
		
		request.setAttribute("list", list);
		forward.setRedirect(false);
		forward.setNextPath("WEB-INF/view/product/productrefundform.jsp");
		
		return forward;
		
	}

}

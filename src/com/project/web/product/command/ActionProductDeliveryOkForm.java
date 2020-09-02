package com.project.web.product.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.web.product.dao.PDao;
import com.project.web.product.dto.DeliverOkDto;

public class ActionProductDeliveryOkForm implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ActionForward forward = new ActionForward();
		
		PDao dao = new PDao();
		ArrayList<DeliverOkDto> list =  dao.DeliveryOkList();
		
		request.setAttribute("list", list);
		
		forward.setRedirect(false);
		forward.setNextPath("WEB-INF/view/product/productdeliveryokform.jsp");
		
		return forward;
		
	}

}

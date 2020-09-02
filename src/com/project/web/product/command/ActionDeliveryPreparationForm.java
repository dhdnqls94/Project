package com.project.web.product.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.web.product.dao.PDao;
import com.project.web.product.dto.DDto;
import com.project.web.product.dto.PDto;

public class ActionDeliveryPreparationForm implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ActionForward forward = new ActionForward();
		
		PDao dao = new PDao();
		
		ArrayList<DDto> list = dao.ProductDeliveryPreparation();
		
		request.setAttribute("list", list);
		forward.setRedirect(false);
		forward.setNextPath("WEB-INF/view/product/productdeliverpreparationform.jsp");
		
		return forward;
		
	}

}

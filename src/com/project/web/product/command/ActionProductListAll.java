package com.project.web.product.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.web.product.dao.PDao;
import com.project.web.product.dto.PDto;

public class ActionProductListAll implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ActionForward forward = new ActionForward();
		PDao dao = new PDao();
		ArrayList<PDto> list = dao.ProductListAll();
		
		request.setAttribute("list", list);
		forward.setRedirect(false);
		forward.setNextPath("WEB-INF/view/product/index.jsp");
		
		return forward;
	}

}

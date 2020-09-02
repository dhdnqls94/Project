package com.project.web.product.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.web.product.dao.PDao;
import com.project.web.product.dto.DDto;

public class ActionOrderListForm implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ActionForward forward = new ActionForward();
		
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("sessionID");
		PDao dao = new PDao();
		System.out.println("orderlist id : "+id);
		
		ArrayList<DDto> list = new ArrayList<DDto>();
		
		list = dao.ProductOrderList(id);
		
		request.setAttribute("list", list);
		
		forward.setRedirect(false);
		forward.setNextPath("WEB-INF/view/product/productorderlist.jsp");
		System.out.println("ActionOrderList 실행");
		return forward;
	}

}

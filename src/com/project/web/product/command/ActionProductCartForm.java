package com.project.web.product.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.web.product.dto.PDto;

public class ActionProductCartForm implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ActionForward forward = new ActionForward();
		HttpSession session = request.getSession();
		PDto dto = new PDto();
		ArrayList<PDto> list = (ArrayList<PDto>) session.getAttribute("ArrayList");
		
		if(list == null) {
			list = new ArrayList<PDto>();
			session.setAttribute("ArrayList", list);
			
		}
		
		dto.setNo(Integer.parseInt(request.getParameter("no")));
		dto.setQty(Integer.parseInt(request.getParameter("qty")));
		dto.setPrice(Integer.parseInt(request.getParameter("price")));
		dto.setImg(request.getParameter("img"));
		dto.setName(request.getParameter("name"));
		
		list.add(dto);
		
		forward.setRedirect(false);
		forward.setNextPath("WEB-INF/view/product/productcartform.jsp");
		
		return forward;
		
	}

}

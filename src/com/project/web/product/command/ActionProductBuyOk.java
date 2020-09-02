package com.project.web.product.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.web.product.dao.PDao;
import com.project.web.product.dto.DDto;
import com.project.web.product.dto.PDto;

public class ActionProductBuyOk implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ActionForward forward = new ActionForward();
		
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("sessionID");
		int test = 0;
		
		PDao dao = new PDao();
		DDto Ddto = new DDto(); // 배송관련 DTO
		
		Ddto.setName(request.getParameter("user_name").trim());
		Ddto.setPhone(request.getParameter("user_phone").trim());
		Ddto.setZipCode(request.getParameter("user_zipCode").trim());
		Ddto.setAddr(request.getParameter("user_addr").trim());
		Ddto.setNo(Integer.parseInt(request.getParameter("no").trim()));
		Ddto.setProductName(request.getParameter("name").trim());
		Ddto.setProductQty(Integer.parseInt(request.getParameter("qty").trim()));
		Ddto.setProductTotal(Integer.parseInt(request.getParameter("total").trim()));
		// 구매한 유저의 이름
		Ddto.setId(id);
		
		test = dao.ProductBuyOk(Ddto);
		System.out.println("test : " + test);
		forward.setRedirect(false);
		forward.setNextPath("WEB-INF/view/product/productbuyokform.jsp");
		
		return forward;
		
	}

}

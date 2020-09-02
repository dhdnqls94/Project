package com.project.web.product.command;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.web.product.dao.PDao;
import com.project.web.product.dto.ProductRefundDto;

public class ActionProductRefund implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("text/html; charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		ActionForward forward = new ActionForward();
		ProductRefundDto dto = new ProductRefundDto();
		PDao dao = new PDao();
		PrintWriter script = response.getWriter();
		
		int check = 0;
		int productnum1 = Integer.parseInt(request.getParameter("productnum").trim());
		check = dao.refundOverlapCheck(productnum1);
		
		if(check == 1) {
			dto.setProductNum(Integer.parseInt(request.getParameter("productnum").trim()));
			dto.setName(request.getParameter("name"));
			dto.setAddr(request.getParameter("addr"));
			dto.setProductName(request.getParameter("productname"));
			dto.setProductQty(Integer.parseInt(request.getParameter("productqty")));
			dto.setProductTotal(Integer.parseInt(request.getParameter("producttotal")));
			
			dao.ProductRefund(dto);
			
			forward.setRedirect(false);
			forward.setNextPath("WEB-INF/view/product/productrefundwait.jsp");
			return forward;
		} else {
			script.println("<script>alert('이미 환불신청 하셨습니다.')</script>");
			script.println("<script>history.back();</script>");
		}
		
		
		return forward;
	}
	
}

package com.project.web.product.command;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.web.product.dao.PDao;
import com.project.web.product.dto.PDto;

public class ActionDetailForm implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		ActionForward forward = new ActionForward();
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("sessionID");
		PrintWriter script = response.getWriter();
		
		if(id == null) {
			script.println("<script>alert('로그인해주세요');");
			script.println("location.href='LoginForm.do'");
			script.println("</script>");
			script.flush();
			
		}
		
		PDto dto = new PDto();
		PDao dao = new PDao();
		
		int no = Integer.parseInt(request.getParameter("no"));
		
		dto = dao.ProductDetailForm(no);
		
		request.setAttribute("dto", dto);
		
		forward.setRedirect(false);
		forward.setNextPath("WEB-INF/view/product/ProductDetail.jsp");
		System.out.println("액션 들어옴");
		return forward;
		
	}

}

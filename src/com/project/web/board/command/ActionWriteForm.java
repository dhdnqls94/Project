package com.project.web.board.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.web.board.dao.BDao;
import com.project.web.board.dto.BDto;

public class ActionWriteForm implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ActionForward forward = new ActionForward();
		String bWriter = request.getParameter("bWriter");
		System.out.println("bWriter : " + bWriter);
		BDto dto = new BDto();
		BDao dao = new BDao();
		
		dto = dao.WriteForm(bWriter);
		
		request.setAttribute("dto", dto);
		
		forward.setRedirect(false);
		forward.setNextPath("WEB-INF/view/board/boardWriteForm.jsp");
		
		return forward;
		
	} 
}
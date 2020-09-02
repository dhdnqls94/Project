package com.project.web.board.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.web.board.dao.BDao;
import com.project.web.board.dto.BDto;

public class ActionBoardReWrite implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ActionForward forward = new ActionForward();
		
		BDto dto = new BDto();
		BDao dao = new BDao();
		dto.setbWriter(request.getParameter("id"));
		dto.setbTitle(request.getParameter("bTitle"));
		dto.setbPassword(request.getParameter("bPassword"));
		dto.setContent(request.getParameter("content"));
		dto.setRef(Integer.parseInt(request.getParameter("ref")));
		dto.setReStep(Integer.parseInt(request.getParameter("reStep")));
		dto.setReLevel(Integer.parseInt(request.getParameter("reLevel")));
		dto.setbEmail(request.getParameter("bEmail"));
		
		System.out.println("id : " + dto.getbWriter());
		System.out.println("Title : " + dto.getbTitle() );
		System.out.println("password : " + dto.getbPassword());
		System.out.println("Content : " + dto.getContent());
		System.out.println("Ref : " + dto.getRef());
		System.out.println("ReStep : " + dto.getReStep());
		System.out.println("ReLevel : " + dto.getReLevel());
		System.out.println("email : " + dto.getbEmail());
		
		dao.BoardReWrite(dto);
		
		forward.setRedirect(false);
		forward.setNextPath("WEB-INF/view/board/boardReWriteOk.jsp");
		
		return forward;
		
	}

}

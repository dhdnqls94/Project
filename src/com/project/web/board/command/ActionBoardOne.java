package com.project.web.board.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.web.board.dao.BDao;
import com.project.web.board.dto.BDto;

public class ActionBoardOne implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ActionForward forward = new ActionForward();
		
		int bNum = Integer.parseInt(request.getParameter("bNum"));
		System.out.println("작성번호 값1 : " + bNum);
		
		BDao dao = new BDao();
		BDto dto = new BDto();
		
		dto = dao.BoardOne(bNum);
		
		System.out.println("작성번호 값2 : " + bNum);
		
		request.setAttribute("dto", dto);
		
		forward.setRedirect(false);
		forward.setNextPath("WEB-INF/view/board/boardOneForm.jsp");
		System.out.println("actionBoardOne 들어옴");
		
		return forward;
	}

}

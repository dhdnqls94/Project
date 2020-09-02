package com.project.web.board.command;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.web.board.dao.BDao;
import com.project.web.board.dto.BDto;

public class ActionBoardWrite implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		ActionForward forward = new ActionForward();
		PrintWriter script = response.getWriter();
		
		// 로그인한 사용자 아이디를 가져옴
		HttpSession session = request.getSession();
		
		BDto dto = new BDto();
		BDao dao = new BDao();
		dto.setbWriter((String) session.getAttribute("sessionID"));
		dto.setbTitle(request.getParameter("bTitle"));
		dto.setbEmail(request.getParameter("bEmail"));
		dto.setbPassword(request.getParameter("bPassword"));
		dto.setContent(request.getParameter("content"));
		
		try {
			dao.BoardWrite(dto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		forward.setRedirect(false);
		forward.setNextPath("WEB-INF/view/board/boardWriteOk.jsp");
		System.out.println("ActionBoardWrite 수행함");
		
		return forward;
	}

}

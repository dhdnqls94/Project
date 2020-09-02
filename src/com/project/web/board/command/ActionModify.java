package com.project.web.board.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.web.board.dao.BDao;
import com.project.web.board.dto.BDto;

public class ActionModify implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ActionForward forward = new ActionForward();
		
		String bTitle = request.getParameter("bTitle");
		String content = request.getParameter("content");
		int bNum = Integer.parseInt(request.getParameter("bNum"));
		
		BDao dao = new BDao();
		
		System.out.println("bNum : " + bNum);
		System.out.println("bTitle : " + bTitle);
		System.out.println("content : " + content);
		
		int test = dao.BoardModify(bNum, bTitle, content);
		
		request.setAttribute("test", test);
		
		forward.setRedirect(false);
		forward.setNextPath("WEB-INF/view/board/boardModifyOk.jsp");
		
		return forward;
		
	}  

}

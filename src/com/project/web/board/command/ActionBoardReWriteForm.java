package com.project.web.board.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.web.board.dao.BDao;
import com.project.web.board.dto.BDto;

public class ActionBoardReWriteForm implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ActionForward forward = new ActionForward();
		
		// 답글을 저장하기 위한
		BDao dao = new BDao();
		request.setCharacterEncoding("utf-8");
		
		BDto dto = new BDto();
		// 빈에 넘어온 데이터를 저장
		
		int bNum = Integer.parseInt(request.getParameter("bNum"));
		int ref = Integer.parseInt(request.getParameter("ref"));
		int reStep = Integer.parseInt(request.getParameter("reStep"));
		int reLevel = Integer.parseInt(request.getParameter("reLevel"));
		String bEmail = request.getParameter("bEmail");
		
		request.setAttribute("bNum", bNum);
		request.setAttribute("ref", ref);
		request.setAttribute("reStep", reStep);
		request.setAttribute("reLevel", reLevel);
		request.setAttribute("bEmail", bEmail);
		
		
		System.out.println("---------------------------------");
		System.out.println("ActionBoardReWriteForm에 들어온 값");
		System.out.println("bNum : " + bNum);
		System.out.println("ref : " + ref);
		System.out.println("reStep : " + reStep);
		System.out.println("reLevel : " + reLevel);
		System.out.println("bEmail : " + bEmail);
		System.out.println("---------------------------------");
		
		forward.setRedirect(false);
		forward.setNextPath("WEB-INF/view/board/boardReWriteForm.jsp");
		
		return forward;
	}
}
package com.project.web.member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MemberLogoutAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		
		ActionForward forward = new ActionForward();
		
		HttpSession session = request.getSession();
		
		session.removeAttribute("sessionID");
		
		forward.setRedirect(true);
		forward.setNextPath("Logout.do");
		
		return forward;
	}

}

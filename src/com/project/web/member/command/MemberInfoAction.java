package com.project.web.member.command;


import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.web.member.dao.MDao;
import com.project.web.member.dto.MDto;

public class MemberInfoAction implements Action{

	// 로그인한 사용자의 정보를 화면에 보여준다.
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ActionForward forward = new ActionForward();
		ArrayList<MDto> dto = new ArrayList<MDto>();
		
		// 세션이 가지고있는 로그인한 ID 정보를 가져온다.
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("sessionID");
		
		// 그 아이디 해당하는 회원정보를 가져온다.
		MDao dao = new MDao();
		dto = dao.getUserInfo(id);
		
		
		// UserInfoForm.jsp에 회원정보를 전달하기 위해 request에 MDto를 세팅한다.
		request.setAttribute("MDto", dto);
		
		forward.setRedirect(false);
		forward.setNextPath("/UserInfoForm.do");
		System.out.println("MemberInfoAction 수행함");
		
		return forward;
		
	}

}

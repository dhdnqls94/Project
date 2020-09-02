package com.project.web.member.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.web.member.dao.MDao;
import com.project.web.member.dto.MDto;

public class MemberModifyFormAction implements Action{

	// 회원정보 수정 화면에 현재 회원정보를 출력한다.
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ActionForward forward = new ActionForward();
		
		// 세션이 가지고있는 로그인한 ID 정보를 가져온다.
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("sessionID");
		
		// 수정할 회원정보를 가져온다.
		MDao dao = new MDao();
		ArrayList<MDto> dto = dao.getUserInfo(id);
		
		// ModifyForm.jsp에 회워정보를 전달하기 위해 request에 MDto를 세팅한다.
		request.setAttribute("MDto", dto);
		System.out.println("MemberModifyFormAction 수행함");
		forward.setRedirect(false);
		forward.setNextPath("ModifyForm.do");
		
		return forward;
	}

}

package com.project.web.member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.web.member.dao.MDao;
import com.project.web.member.dto.MDto;

public class MemberModifyAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("utf-8");
		
		ActionForward forward = new ActionForward();
		
		MDao dao = new MDao();
		
		// 세션이 가지고있는 로그인한 ID 정보를 가져온다.
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("sessionID");
		
		// 수정할 정보를 자바빈에 세팅한다.
		MDto dto = new MDto();
		dto.setMember_Id(id);
		dto.setMember_Pw(request.getParameter("passwd"));
		dto.setMember_Name(request.getParameter("name"));
		dto.setMember_Addr(request.getParameter("addr"));
		dto.setMember_Phone(request.getParameter("phone"));
		dto.setMember_Email(request.getParameter("email"));
		
		dao.updateMember(dto);
		
		forward.setRedirect(true);
		 forward.setNextPath("ModifyOk.do");
		 
		 // 회원정보 수정 성공 메시지를 세션에 담는다.
		 session.setAttribute("msg", "0");
		
		return forward;
	}

}

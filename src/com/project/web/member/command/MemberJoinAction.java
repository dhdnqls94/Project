package com.project.web.member.command;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.web.member.dao.MDao;
import com.project.web.member.dto.MDto;

public class MemberJoinAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("utf-8");
		PrintWriter script = response.getWriter();
		
		ActionForward forward = new ActionForward();
		
		// DB에 동일한 아이디가 있는지 확인
		int idCheck = 0;
		
		MDao dao = new MDao();
		
		
		// 회원가입 실행
		String id = request.getParameter("id");
		System.out.println(id);
		
		// 회원가입 전 유저가 입력한 id가 DB에 있다면 idCheck = 0 없다면 1을 리턴하는 메소드
		idCheck =  dao.insertCheckId(id);
		System.out.println("idcheck : " + idCheck);
		
		if(idCheck == 1) {
			MDto dto = new MDto();
			dto.setMember_Id(request.getParameter("id"));
			dto.setMember_Pw(request.getParameter("passwd"));
			dto.setMember_Name(request.getParameter("name"));
			dto.setMember_Addr(request.getParameter("addr"));
			dto.setMember_Phone(request.getParameter("phone"));
			dto.setMember_Email(request.getParameter("email"));
			dao.insertMember(dto);
			forward.setRedirect(true);
			forward.setNextPath("./JoinOk.do");
		} else {
			forward.setRedirect(false);
			forward.setNextPath("WEB-INF/view/member/JoinFail.jsp");
		}
		return forward;
	}
}

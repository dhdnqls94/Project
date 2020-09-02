package com.project.web.member.command;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.web.member.dao.MDao;

public class MemberLoginAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		ActionForward forward = new ActionForward();
		HttpSession session = request.getSession();
		PrintWriter script = response.getWriter();
		response.setContentType("text/html; charset=utf-8");

		// 아이디와 비밀번호를 가져온다.
		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");

		// DB에서 아이디, 비밀번호 확인
		MDao dao = new MDao();

		
		int checkID = dao.loginCheck(id, passwd);
		int checkPW = dao.idCheck(id);
		
		if(checkID == 1 && checkPW == 1) {
			session.setAttribute("sessionID", id);
			// 로그인 성공후 메인화면으로 이동
			forward.setRedirect(false);
			forward.setNextPath("WEB-INF/view/member/loginOk.jsp");
		}
		
		// 비밀번호가 동일하지 않으면 loginFail.jsp로 이동
		else if(checkID == 0 && checkPW == 0) {
			forward.setRedirect(false);
			forward.setNextPath("WEB-INF/view/member/loginFail.jsp");
		}
		else {
			forward.setRedirect(false);
			forward.setNextPath("WEB-INF/view/member/loginFail.jsp");
		}
		return forward;
	}

}

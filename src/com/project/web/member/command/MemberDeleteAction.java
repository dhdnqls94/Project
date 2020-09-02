package com.project.web.member.command;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.project.web.member.dao.MDao;

public class MemberDeleteAction implements Action{

	// 회원삭제 작업 처리
	
	// 아이디와 비밀번호를 이용해 회원 삭제 작업을 처리한다. 처리 후 결과 값을 받는다.
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ActionForward forward = new ActionForward();
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter script = response.getWriter();
		
		
		// 세션이 가지고있는 로그인한 ID 정보를 가져온다.
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("sessionID");
		String passwd = request.getParameter("passwd");
		
		
		System.out.println("패스워드 값 : " + passwd);
		MDao dao = new MDao();
		int check = dao.deleteMember(id, passwd);
		
		if(check == 1) {
			forward.setRedirect(true);
			script.println("<script>alert('회원 탈퇴 완료.');");
			script.println("location.href='index.po'");
			script.println("</script>");
			script.flush();
			session.removeAttribute("sessionID");
			
		} else {
			script.println("<script>alert('비밀번호가 일치하지 않습니다.');");
			script.println("history.back();");
			script.println("</script>");
			return null;
		}
		return forward;
	}
}

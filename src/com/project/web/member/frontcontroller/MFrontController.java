package com.project.web.member.frontcontroller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.web.member.command.*;

@WebServlet("*.do")
public class MFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MFrontController() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request, response);
	}

	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setCharacterEncoding("utf-8");

		String uri = request.getRequestURI();
		String contextPath = request.getContextPath();
		ActionForward forward = null;
		Action action = null;
		String viewPage = "";

		// 보여줄 화면 URL
		String form = "WEB-INF/view/member/";

		String command = uri.substring(contextPath.length());
		System.out.println("MFrontController: "+command);
		
		try {
			
			if(command.equals("/LoginForm.do")) { // 로그인화면 이동
				forward = new ActionForward();
				forward.setRedirect(false);
				forward.setNextPath(form+"login.jsp");
			} 
			
			else if(command.equals("/list.do")) { // 공지사항화면 이동
				forward = new ActionForward();
				forward.setRedirect(false);
				forward.setNextPath(form+"list.jsp");
			}  

			else if(command.equals("/JoinForm.do")) { // 회원가입화면 이동
				forward = new ActionForward();
				forward.setRedirect(false);
				forward.setNextPath(form+"join.jsp");
			}
			
			
			else if(command.equals("/Logout.do")) { // 로그아웃 페이지로 이동
				forward = new ActionForward();
				forward.setNextPath(form+"logout.jsp");
			}
			
			else if(command.equals("/JoinOk.do")) { // 로그아웃 페이지로 이동
				forward = new ActionForward();
				forward.setNextPath(form+"joinOk.jsp");
			}
			
			else if(command.equals("/ModifyOk.do")) { // 로그아웃 페이지로 이동
				forward = new ActionForward();
				forward.setNextPath(form+"ModifyOk.jsp");
			}


			else if(command.equals("/UserInfoForm.do")) { // 내정보 클릭 - 회원정보화면 이동
				forward = new ActionForward();
				forward.setRedirect(false);
				
				forward.setNextPath(form+"UserInfoForm.jsp");
			}

			else if(command.equals("/ModifyForm.do")) { // 회원수정화면 이동
				forward = new ActionForward();
				forward.setRedirect(false);
				forward.setNextPath(form+"ModifyForm.jsp");
			}

			else if(command.equals("/DeleteForm.do")) { // 회원삭제화면 이동
				forward = new ActionForward();
				forward.setRedirect(false);
				forward.setNextPath(form+"DeleteForm.jsp");
			}

			else if(command.equals("/Result.do")) { // 각종 처리결과 화면 이동
				forward = new ActionForward();
				forward.setRedirect(false);
				forward.setNextPath(form+"ResultForm.jsp");
			}

			else if(command.equals("/MemberLoginAction.do")) { // 로그인 처리
				action = new MemberLoginAction();
				forward = action.execute(request, response);
				System.out.println(form+"memberaction.do 들어옴");
			}

			else if(command.equals("/MemberLogoutAction.do")) { // 로그아웃 처리
				action = new MemberLogoutAction();
				forward = action.execute(request, response);
				System.out.println(form + "memberLogoutAction.do 들어옴");
				
			}

			else if(command.equals("/MemberJoinAction.do")) { // 회원가입 처리
				action = new MemberJoinAction();
				forward = action.execute(request, response);
				System.out.println("MemberJoinAction.do수행함");
			} 

			else if(command.equals("/MemberInfoAction.do")) { // 회원정보화면에 보여줄 정보 처리
				action = new MemberInfoAction();
				forward = action.execute(request, response);
				System.out.println("MemberInfoAction.do 들어옴");
				
			}

			else if(command.equals("/MemberModifyFormAction.do")) { // 회원수정화면에 보여줄 정보
				action = new MemberModifyFormAction();
				forward = action.execute(request, response);
			}

			else if(command.equals("/MemberModifyAction.do")) { // 회원수정 처리
				action = new MemberModifyAction();
				forward = action.execute(request, response);
			}

			else if(command.equals("/MemberDeleteAction.do")) { // 회원삭제 처리
				action = new MemberDeleteAction();
				forward = action.execute(request, response);
			}
			
			else if(command.equals("/MemberListAll.do")) {
				action = new MemberListAll();
				forward = action.execute(request, response);
			}
			System.out.println();
			
			// 화면이동 - isRedirect() 값에 따라 sendRedirect 또는 forward를 사용
			// sendRedirect : 새로운 페이지에서는 request와 response객체가 새롭게 생성된다.
			// forward : 현재 실행중인 페이지와 forward에 의해 호출될 페이지는 request와 response 객체를 공유

			if(forward != null) { 
				if(forward.isRedirect()) { 
					response.sendRedirect(forward.getNextPath());
				} else {
					RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getNextPath());
					dispatcher.forward(request, response);
				}
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}

package com.project.web.board.frontcontroller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.web.board.command.Action;
import com.project.web.board.command.ActionBoardDelete;
import com.project.web.board.command.ActionBoardList;
import com.project.web.board.command.ActionBoardModify;
import com.project.web.board.command.ActionBoardOne;
import com.project.web.board.command.ActionBoardReWrite;
import com.project.web.board.command.ActionBoardReWriteForm;
import com.project.web.board.command.ActionBoardWrite;
import com.project.web.board.command.ActionForward;
import com.project.web.board.command.ActionModify;
import com.project.web.board.command.ActionWriteForm;

@WebServlet("*.bo")
public class BFrontController extends HttpServlet {
    public BFrontController() { }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ActionBo(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ActionBo(request, response);
	}

	protected void ActionBo(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
		
		request.setCharacterEncoding("utf-8");
		
		String uri = request.getRequestURI();
		String contextPath = request.getContextPath();
		ActionForward forward = null;
		Action action = null;
		String viewPage = "";
		
		// 보여줄 화면 URL
		String form = "WEB-INF/view/board/";
		
		String command = uri.substring(contextPath.length());
		System.out.println("BFrontController : " + command);
		
		try {
			// 공지사항 글작성 페이지로 이동
			if(command.equals("/boardWriteForm.bo")) {
				action = new ActionWriteForm();
				forward = action.execute(request, response);
			}
			
			// 공지사항 페이지로 이동
			else if(command.equals("/list.bo")) {
				action = new ActionBoardList();
				forward = action.execute(request, response);
			}
			
			// 게시글 작성하는 기능
			else if(command.equals("/boardWrite.bo")) {
				action = new ActionBoardWrite();
				forward = action.execute(request, response);
			}
			
			// 한개의 게시글을 출력
			else if(command.equals("/boardOneForm.bo")) {
				action = new ActionBoardOne();
				forward = action.execute(request, response);
			}
			
			// 수정하는 페이지로 이동
			else if(command.equals("/boardModifyForm.bo")) {
				action = new ActionBoardModify();
				forward = action.execute(request, response);
			}
			
			// 수정한 데이터를 DB에 저장
			else if(command.equals("/boardModify.bo")) {
				action = new ActionModify();
				forward = action.execute(request, response);
				System.out.println("BFrontController : boardModify.bo 들어옴");
			}
			
			else if(command.equals("/boardModifyOk.bo")) {
				forward = new ActionForward();
				forward.setNextPath(form+"boardModifyOk.jsp");
			}
			
			// 게시물 삭제
			else if(command.equals("/boardDelete.bo")) {
				action = new ActionBoardDelete();
				forward = action.execute(request, response);
			}
			
			// 댓글
			else if(command.equals("/boardReWriteForm.bo")) {
				action = new ActionBoardReWriteForm();
				forward = action.execute(request, response);
			}
			
			else if(command.equals("/boardReWriteAction.bo")) {
				action = new ActionBoardReWrite();
				forward = action.execute(request, response);
			}
			
			
//			 화면이동 - isRedirect() 값에 따라 sendRedirect 또는 forward를 사용
//			 sendRedirect : 새로운 페이지에서는 request와 response 객체가 새롭게 생성된다.
//			 forward : 현재 실행중인 페이지와 forward에 의해 호출될 페이지는 reqeust와 response 객체를 공유
			
			if(forward != null) { 
				if(forward.isRedirect()) {  
					response.sendRedirect(forward.getNextPath()); 
				} else {
					RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getNextPath());
					dispatcher.forward(request, response);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
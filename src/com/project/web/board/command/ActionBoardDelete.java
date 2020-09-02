package com.project.web.board.command;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.web.board.dao.BDao;

public class ActionBoardDelete implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		String bWriter = request.getParameter("bWriter");
		HttpSession session = request.getSession();
		String sessionID = (String) session.getAttribute("sessionID");
		
		PrintWriter script = response.getWriter();
		
		if(sessionID.equals(bWriter)) {
			forward = new ActionForward();
			int bNum = Integer.parseInt(request.getParameter("bNum"));
			BDao dao = new BDao();
			dao.ActionBoardDelete(bNum);
		} else {
			script.println("<script>alert('해당 게시글 삭제는 해당글 작성자만 가능합니다.');</script>");
			script.println("<script>history.back();</script>");
		}
		
		
		forward.setRedirect(false);
		forward.setNextPath("WEB-INF/view/board/boardDelete.jsp");
		return forward;
	}

}

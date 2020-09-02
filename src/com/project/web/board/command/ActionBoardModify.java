package com.project.web.board.command;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.web.board.dao.BDao;
import com.project.web.board.dto.BDto;

public class ActionBoardModify implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		int bNum = Integer.parseInt(request.getParameter("bNum"));
		String bWriter = request.getParameter("bWriter");
		HttpSession session = request.getSession();
		ActionForward forward = null;
		PrintWriter script = response.getWriter();
		
		String sessionID = (String) session.getAttribute("sessionID");
		
		System.out.println("ActionForward bNum 값 : " + bNum);
		System.out.println("bWriter : " + bWriter);
		
		if(sessionID.equals(bWriter)) {
			forward = new ActionForward();
			BDao dao = new BDao();
			BDto dto = new BDto();
			ArrayList<BDto> list = new ArrayList<BDto>();
			list = dao.BoardMofidyForm(bNum);
			request.setAttribute("list", list);
		} else {
			script.println("<script>alert('해당 게시글 수정은 해당글 작성자만 가능합니다.');</script>");
			script.println("<script>history.back();</script>");
		}
		
		forward.setRedirect(false);
		forward.setNextPath("WEB-INF/view/board/boardModifyForm.jsp");
		return forward;
	}

}

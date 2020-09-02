package com.project.web.board.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.web.board.dao.BDao;
import com.project.web.board.dto.BDto;

public class ActionBoardList implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ActionForward forward = new ActionForward();
		
		// 화면에 보여질 게시글의 개수를 지정
		int pageSize = 10;
		
		// 현재 보여지고 있는 페이지의 넘버값을 읽어드림
		String pageNum = request.getParameter("pageNum");
		
		// null처리
		if(pageNum == null) {
			pageNum = "1";
		}
		
		// 전체 게시글의 갯수
		int count = 0;
		
		// jsp페이지 내에서 보여질 넘버링 숫자값을 저장하는변수
		int number = 0;
		
		// 현재 보여지고있는 페이지 문자를 숫자로 변환
		int currentPage = Integer.parseInt(pageNum);
		
		// 전체 게시글의 갯수를 가져와야 하기에 데이터베이스 객체 생성
		BDao dao = new BDao();
		count = dao.getAllCount();
		
		// 현재 보여질 페이지 시작 번호를 설정
		int startRow = (currentPage - 1) * pageSize + 1;
		int endRow = currentPage * pageSize;
		
		// 최신글 10개를 기준으로 게시글을 리턴 받아주는 메소드 호출
		ArrayList<BDto> list = dao.BoardList(startRow, endRow);
		
		number = count - (currentPage - 1) * pageSize;
		
		request.setAttribute("list", list);
		request.setAttribute("number", number);
		request.setAttribute("pageSize", pageSize);
		request.setAttribute("count", count);
		request.setAttribute("currentPage", currentPage);
		
		forward.setRedirect(false);
		forward.setNextPath("WEB-INF/view/board/list.jsp");
		return forward;
	}
}
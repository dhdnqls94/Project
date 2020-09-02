package com.project.web.member.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.web.member.dao.MDao;
import com.project.web.member.dto.MDto;

public class MemberListAll implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ActionForward forward = new ActionForward();
		ArrayList<MDto> list = new ArrayList<MDto>();
		MDao dao = new MDao();
		
		list = dao.MemberListAll();
		
		request.setAttribute("list", list);
		
		forward.setRedirect(false);
		forward.setNextPath("WEB-INF/view/member/memberlistall.jsp");
		
		return forward;
	}

}

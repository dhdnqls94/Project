package com.project.web.product.command;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.web.product.dto.PDto;

public class ActionProductCartDelete implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		ActionForward forward = new ActionForward();
		PrintWriter script = response.getWriter();
		HttpSession session = request.getSession();
		PDto dto = new PDto();

		String name = request.getParameter("name");
		String img = request.getParameter("img");
		int no = Integer.parseInt(request.getParameter("no"));
		int qty = Integer.parseInt(request.getParameter("qty").trim());
		int price = Integer.parseInt(request.getParameter("price").trim());

		ArrayList<PDto> ArrayList = (ArrayList<PDto>) session.getAttribute("ArrayList");

		for(int i = 0; i < ArrayList.size(); i++) {
			dto = ArrayList.get(i);

			System.out.println("ArrayList.name : " + dto.getName());
			System.out.println("ArrayList.img : " + dto.getImg());
			System.out.println("ArrayList.no : " + dto.getNo());
			System.out.println("ArrayList.qty : " + dto.getQty());
			System.out.println("ArrayList.price : " + dto.getPrice());

			if(name.equals(dto.getName())) {
				ArrayList.remove(dto);
			}
		}
		forward.setRedirect(false);
		forward.setNextPath("ProductCartList.po");

		return forward;
	}

}

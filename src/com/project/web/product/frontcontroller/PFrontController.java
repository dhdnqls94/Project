package com.project.web.product.frontcontroller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.web.product.command.Action;
import com.project.web.product.command.ActionBuyForm;
import com.project.web.product.command.ActionDeliverOk;
import com.project.web.product.command.ActionDeliveryPreparationForm;
import com.project.web.product.command.ActionDetailForm;
import com.project.web.product.command.ActionForward;
import com.project.web.product.command.ActionOrderListForm;
import com.project.web.product.command.ActionProductBuyOk;
import com.project.web.product.command.ActionProductCartDelete;
import com.project.web.product.command.ActionProductCartForm;
import com.project.web.product.command.ActionProductDeliveryOkDelete;
import com.project.web.product.command.ActionProductDeliveryOkForm;
import com.project.web.product.command.ActionProductInfoForm;
import com.project.web.product.command.ActionProductListAll;
import com.project.web.product.command.ActionProductRefund;
import com.project.web.product.command.ActionProductRefundForm;
import com.project.web.product.command.ActionProductRefundOk;

@WebServlet("*.po")
public class PFrontController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ActionPo(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ActionPo(request,response);
	}

	protected void ActionPo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		String uri = request.getRequestURI();
		String contextPath = request.getContextPath();
		ActionForward forward = null;
		Action action = null;
		
		// 보여줄 화면 URL
		String form = "WEB-INF/view/product/";
		
		String command = uri.substring(contextPath.length());
		System.out.println("PFrontController : " + command);
		
		try {
			
			if(command.equals("/index.po")) { // 메인화면 이동
				action = new ActionProductListAll();
				forward = action.execute(request, response);
				System.out.println("index.po 들어옴");
			} 
			
			// 상품 상세페이지
			else if(command.equals("/ProductDetailForm.po")) {
				action = new ActionDetailForm();
				System.out.println("들어옴");
				forward = action.execute(request, response);
			}
			
			// 구매정보/배송정보 폼
			else if(command.equals("/ProductBuyForm.po")) {
				action = new ActionBuyForm();
				forward = action.execute(request, response);
			}
			
			// 구매정보 -> 주문하기
			else if(command.equals("/ProductInfoForm.po")) {
				action = new ActionProductInfoForm();
				forward = action.execute(request, response);
			}
			
			// 구매한 제품을 DB에 저장하는 메소드
			else if(command.equals("/ProductBuyOk.po")) {
				action = new ActionProductBuyOk();
				forward = action.execute(request, response);
			}
			
			// 주문확인 페이지 보여주는 메소드
			else if(command.equals("/ProductOrderListForm.po")) {
				action = new ActionOrderListForm();
				forward = action.execute(request, response);
			}
			
			// 환불페이지 이동
			else if(command.equals("/ProductRefundForm.po")) {
				action = new ActionProductRefundForm();
				forward = action.execute(request, response);
			}
			
			// 환불페이지에 환불목록 출력
			else if(command.equals("/ProductRefund.po")) {
				action = new ActionProductRefund();
				forward = action.execute(request, response);
			}
			
			// 관리자가 환불승인 처리
			else if(command.equals("/ProductRefundOk.po")) {
				action = new ActionProductRefundOk();
				forward = action.execute(request, response);
			}
			
			// 관리자 배송준비 페이지 이동
			else if(command.equals("/ProductDeliveryPreparationForm.po")) {
				action = new ActionDeliveryPreparationForm();
				forward = action.execute(request, response);
			}
			
			// 배송준비 -> 배송완료
			else if(command.equals("/ProductDeliveryProcessing.po")) {
				action = new ActionDeliverOk();
				forward = action.execute(request, response);
			}
			
			// 배송완료 전체 리스트
			else if(command.equals("/ProductDeliveryOkForm.po")) {
				action = new ActionProductDeliveryOkForm();
				forward = action.execute(request, response);
			}
			
			// 배송완료된 정보 DB에서 삭제하기
			else if(command.equals("/ProductDeliveryOkDelete.po")) {
				action = new ActionProductDeliveryOkDelete();
				forward = action.execute(request, response);
			}
			
			// productbuyform에서 장바구니에 제품을 넣고 productcartform 페이지로 이동
			else if(command.equals("/ProductCartForm.po")) {
				action = new ActionProductCartForm();
				forward = action.execute(request, response);
			}
			// 단순 페이지 이동 : productcartform
			else if(command.equals("/ProductCartList.po")) {
				forward = new ActionForward();
				forward.setRedirect(false);
				forward.setNextPath(form + "productcartform.jsp");
			}
			
			// 장바구니 제품을 삭제
			else if(command.equals("/ProductCartDelete.po")) {
				action = new ActionProductCartDelete();
				forward = action.execute(request, response);
				
			}
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
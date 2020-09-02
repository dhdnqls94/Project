package com.project.web.member.command;

public class ActionForward {

	// 페이지 이동을 처리하기 위한 클래스
	// isRedirect : sendRedirect와 forward 중 어떤 것을 이용해서 페이지 이동할지를 결정하기 위한 boolean 변수이다.
	// isRedirect가 true 이면 sendRedirect()를 통해 화면 이동을 처리, false면 forward()를 통해 화면 이동을 처리
	// nextPath : 이동할 페이지 경로값을 갖고있는 변수이다.
	
	private boolean isRedirect = false;
	private String nextPath = null;
	
	// Redirect 사용여부, false이면 Forward 사용
	
	public boolean isRedirect() {
		return isRedirect;
	}
	
	public void setRedirect(boolean isRedirect) {
		this.isRedirect = isRedirect;
	}
	
	public String getNextPath() {
		return nextPath;
	}
	
	public void setNextPath(String nextPath) {
		this.nextPath = nextPath;
	}
}

package com.multicampus.controller.user;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class LogoutController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("로그아웃 처리");
		
		// 로그아웃 요청한 브라우저와 매핑된 세션을 강제 종료한다. 
		HttpSession session = request.getSession();
		session.invalidate();

		// 화면 이동
		// 이동하고자 하는 화면을 ModelAndView에 담아서 리턴한다.
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/");
		return mav;
	}

}

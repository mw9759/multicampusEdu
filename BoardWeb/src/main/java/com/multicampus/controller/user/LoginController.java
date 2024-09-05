package com.multicampus.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.multicampus.biz.user.UserDAO;
import com.multicampus.biz.user.UserVO;

import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {

	//@RequestMapping(value = "/login.do", method = RequestMethod.GET)
	@GetMapping("/login.do")
	public String loginView(@ModelAttribute("user") UserVO vo) throws Exception {
		// 커맨드 객체에 값을 설정하면 해당 데이터를 jsp에서 사용할 수 있다.
		vo.setId("test");
		vo.setPassword("test");
		return "login.jsp";
	}
	
	//@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	@PostMapping("/login.do")
	public String login(UserVO vo, UserDAO dao, HttpSession session) throws Exception {
		UserVO user = dao.getUser(vo);
		
		if(dao.getUser(vo) != null) {
			// 로그인 성공시 세션에 회원 정보 저장
			session.setAttribute("user", user);
			// 리턴되는 뷰이름 앞에 forward:이나 redirect: 을 붙이면 ViewResolver가 동작하지 않는다.
			return "forward:getBoardList.do";
		}
		else return "login.jsp";
	}
	
	@RequestMapping("/logout.do")
	public String logout(HttpSession session) throws Exception {
		session.invalidate();
		return "redirect:/";
	}

}




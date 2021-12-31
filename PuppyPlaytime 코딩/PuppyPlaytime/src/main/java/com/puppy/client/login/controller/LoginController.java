package com.puppy.client.login.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.puppy.client.login.service.LoginService;
import com.puppy.client.member.service.MemberService;
import com.puppy.client.member.vo.MemberVO;

@Controller
@RequestMapping("/client/login")
public class LoginController {
	private Logger log = LoggerFactory.getLogger(LoginController.class);

	@Autowired
	private LoginService loginService;

	@Autowired
	private MemberService memberService;
	
	private HttpSession session;

	// 로그인 화면 보여주기 위한 메소드
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() throws Exception {
		log.info("login.do get 호출 성공");
		return "client/login/login";
	}

	// 로그인 등록 처리 메서드
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String userLogin(@ModelAttribute("MemberVO") MemberVO mvo, HttpServletRequest request,
			RedirectAttributes rttr, HttpServletResponse response) throws Exception {
		log.info("login post 호출 성공");

		session = request.getSession();
		MemberVO lvo = loginService.userLogin(mvo);

		if (lvo == null) { // 일치하지 않은 아이디,비밀번호 입력 경우
			int result = 0;
			rttr.addFlashAttribute("result", result);
			
			response.setContentType("text/html; charset=euc-kr");
	    	PrintWriter out = response.getWriter();
	    	out.println("<script type='text/javascript'>");
	    	out.println("alert('로그인에 실패하였습니다.');");
	    	out.println("location.href='/client/login/login'");
	    	out.println("</script>");
	    	out.flush();
			
			return "/client/login/login";
		}else {
			session.setAttribute("userId", lvo.getM_id()); // 일치하는 아이디와 비밀번호일 경우
			if(lvo.getM_id().equals("admin")){
				return "adminIntro";
			}else {
				return "intro";
			}	
		}
	}

	// 아이디 찾기 페이지
	@RequestMapping(value = "/find_id", method = RequestMethod.GET)
	public String find_idForm() {
		log.info("find_id GET 호출 성공");
		return "/client/login/find_id";
	}

	// 아이디 찾기
	@ResponseBody
	@RequestMapping(value = "/find_id", method = RequestMethod.POST)
	public String find_id(@RequestParam("m_email") String m_email, MemberVO mvo, Model model) throws Exception {
		log.info("find_id POST 호출 성공");
		String ok = "";
		MemberVO vo = memberService.find_id(m_email);
		model.addAttribute("m_id", vo.getM_id());// id값 입력
		if (vo != null) {
			ok = "ok";
		}
		return vo.getM_id();// vo의 id값을 받아온다.
	}

	
	@RequestMapping(value="logout")
	public String logout() {
		session.removeAttribute("userId"); 
	    session.invalidate();
	    
		return "intro";
	}
}

package kosta.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ExceptionController {

	@RequestMapping("/exception.do")
	public String exception(String no) {
		System.out.println("no: " + no);
		
		int coverNo = Integer.parseInt(no);
		
		int result = 100/coverNo;
		
		System.out.println("나눈 결과: " + result);
		
		return "result"; // WEB-INF/vies/result.jsp로 이동한다.
		
	}

	/**
	 * 현재 Controller에서 예외가 발생하면 처리해줄 메서드
	 * */
	@ExceptionHandler({NumberFormatException.class, ArithmeticException.class})
	public ModelAndView error(Exception e) {
		System.out.println("예외가 났을 때 해야될 일을 합니다.");
		System.out.println(e + " = " + e.getMessage());
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("error/errorView"); // WEB-INF/vies/error/errorView.jsp
		mv.addObject("errMsg", e.getMessage()); // null이라고 표시된다.
		mv.addObject("errorInfo", e.getClass()+"에서 발생했어요.");
		
		return mv;
	}
}

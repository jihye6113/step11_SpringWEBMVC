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
		
		System.out.println("���� ���: " + result);
		
		return "result"; // WEB-INF/vies/result.jsp�� �̵��Ѵ�.
		
	}

	/**
	 * ���� Controller���� ���ܰ� �߻��ϸ� ó������ �޼���
	 * */
	@ExceptionHandler({NumberFormatException.class, ArithmeticException.class})
	public ModelAndView error(Exception e) {
		System.out.println("���ܰ� ���� �� �ؾߵ� ���� �մϴ�.");
		System.out.println(e + " = " + e.getMessage());
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("error/errorView"); // WEB-INF/vies/error/errorView.jsp
		mv.addObject("errMsg", e.getMessage()); // null�̶�� ǥ�õȴ�.
		mv.addObject("errorInfo", e.getClass()+"���� �߻��߾��.");
		
		return mv;
	}
}

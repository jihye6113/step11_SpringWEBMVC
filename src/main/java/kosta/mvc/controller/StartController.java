package kosta.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // 생성이면서 Controller의 역할이다.
// servlet-context.xml에서 base-package 설정을 먼저 해야된다.
public class StartController {

	
	/**
	 * 리턴이 String이면 리턴값이 뷰이름이 된다.
	 * */
	@RequestMapping("/a.do") // a.do 링크를 누르면 이 컨트롤러를 찾을 수 있게 handlerMapping
	public String aaa(){
		System.out.println("a.do가 요청되었습니다.");
		
		return "result"; // WEB-INF/views/result.jsp
	}
}

package kosta.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//@Controller
@RestController // @Controller + @ResponseBody // 비동기화통신
public class ResponseBodyController {

	@RequestMapping(value="/responseBody.do", produces = "text/html;charset=UTF-8")
	//@ResponseBody // 리턴되는 값이 그대로 응답객체가 된다.
	public String aa() {
		System.out.println("responseBody.do가 요청되었습니다.");
		
		return "점심 뭐먹지? -- hello";
	}
	
	@RequestMapping(value="responseBody2.do", produces = "text/html;charset=UTF-8")
	//@ResponseBody
	public String bb() {
		System.out.println("responseBody2.do가 요청되었습니다.");
		
		return "잼따";
	}
}

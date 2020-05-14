package kosta.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//@Controller
@RestController // @Controller + @ResponseBody // �񵿱�ȭ���
public class ResponseBodyController {

	@RequestMapping(value="/responseBody.do", produces = "text/html;charset=UTF-8")
	//@ResponseBody // ���ϵǴ� ���� �״�� ���䰴ü�� �ȴ�.
	public String aa() {
		System.out.println("responseBody.do�� ��û�Ǿ����ϴ�.");
		
		return "���� ������? -- hello";
	}
	
	@RequestMapping(value="responseBody2.do", produces = "text/html;charset=UTF-8")
	//@ResponseBody
	public String bb() {
		System.out.println("responseBody2.do�� ��û�Ǿ����ϴ�.");
		
		return "���";
	}
}

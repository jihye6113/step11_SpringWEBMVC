package kosta.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // �����̸鼭 Controller�� �����̴�.
// servlet-context.xml���� base-package ������ ���� �ؾߵȴ�.
public class StartController {

	
	/**
	 * ������ String�̸� ���ϰ��� ���̸��� �ȴ�.
	 * */
	@RequestMapping("/a.do") // a.do ��ũ�� ������ �� ��Ʈ�ѷ��� ã�� �� �ְ� handlerMapping
	public String aaa(){
		System.out.println("a.do�� ��û�Ǿ����ϴ�.");
		
		return "result"; // WEB-INF/views/result.jsp
	}
}

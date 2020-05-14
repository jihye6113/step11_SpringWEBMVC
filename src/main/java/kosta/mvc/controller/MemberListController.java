package kosta.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kosta.mvc.domain.MemberListDTO;

@Controller
public class MemberListController {

	@RequestMapping("/list/memberMulti.do")
	public ModelAndView list(@ModelAttribute("listDTO")MemberListDTO listDTO) { // �μ��� List<Member> ��� �Ұ�
		System.out.println("MemberListController�� list ȣ���");
		
		return new ModelAndView("listResult", "message", "������ �����");
	}
}

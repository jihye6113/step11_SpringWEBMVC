package kosta.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kosta.mvc.domain.MemberListDTO;

@Controller
public class MemberListController {

	@RequestMapping("/list/memberMulti.do")
	public ModelAndView list(@ModelAttribute("listDTO")MemberListDTO listDTO) { // 인수에 List<Member> 사용 불가
		System.out.println("MemberListController의 list 호출됨");
		
		return new ModelAndView("listResult", "message", "오늘은 목요일");
	}
}

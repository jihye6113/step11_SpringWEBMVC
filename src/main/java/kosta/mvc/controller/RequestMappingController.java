package kosta.mvc.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/rem") // ��Ʈ�ѷ��� ���� �� rem�� �ƴϸ� �ɷ�����.
public class RequestMappingController {
	
	@RequestMapping("a.do")
	public ModelAndView bb() {
		System.out.println("rem/a.do ��û�Ǿ����ϴ�.");
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("result"); // WEB-INF/views/result.jsp�� �̵��� !
		mv.addObject("message", "�ű��"); // requestScope�� ����ȴ�. // �信�� ${requestScope.message}�� ����� �ҷ���.
		mv.addObject("id", "bjhye");
		
		return mv;
	}
	
	/**
	 * ���� ���� ��û�� ���� �޼���(Controller)�� ȣ��
	 * 
	 * @param: Model�� �信 ���޵� ��ü
	 * @return: String�� ���� �̸��� �ȴ�.
	 * */
	@RequestMapping(value = {"/b.do", "/c.do"})
	public String cc(Model model) {
		System.out.println("���� ���� ��û�� ���� �޼���(Controller)�� ȣ���ϱ�");
		
		model.addAttribute("message", "����");
		model.addAttribute("id", "mingming");
		
		return "result"; // �� �̸��� �ȴ�.
	}
	
	/**
	 * ��û���(get or post, put, delete)�� ���� �ٸ� �޼��� ȣ��
	 * @return: void�� ���� ��û �̸��� ���� �̸��� �ȴ�.
	 * ���� ��� rem/test.do ��û�Ǹ�, 
	 * WEB-INF/views/rem/test.jsp
	 * */
	@PostMapping("/test.do")
	public void aa(HttpServletRequest request) {
		String name = request.getParameter("name");
		System.out.println("post��� test.do�� ��û�Ǿ����ϴ�. name: " + name);
	}
	
	@GetMapping("/test.do")
	public void bbb(String name) {
		// request�� ���ؼ� getParameter�� ���� ���� �ʾƵ� �ȴ�. ���� ���̳� �Ѿ�� ���� �� �ΰ� ������ ������ �ᵵ �ɵ�.
		System.out.println("Get��� test.do�� ��û�Ǿ����ϴ�. name: " + name);
		// �ѱ۱��� ������ ���ؼ� ���ڵ� ó���� �ؾߵȴ�.
	}
	
	/**
	 * parameter ������ ���� Mapping ó���ϱ�
	 * */
	@RequestMapping(value="a.do", params = {"id=!jang", "age"})
	public void dd() {
		System.out.println("a.do�� parameter ������ ���� Mapping");
	}

}

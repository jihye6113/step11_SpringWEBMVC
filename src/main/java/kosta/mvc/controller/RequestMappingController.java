package kosta.mvc.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/rem") // 컨트롤러로 들어올 때 rem이 아니면 걸러진다.
public class RequestMappingController {
	
	@RequestMapping("a.do")
	public ModelAndView bb() {
		System.out.println("rem/a.do 요청되었습니다.");
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("result"); // WEB-INF/views/result.jsp로 이동해 !
		mv.addObject("message", "신기룽"); // requestScope에 저장된다. // 뷰에서 ${requestScope.message}를 사용해 불러옴.
		mv.addObject("id", "bjhye");
		
		return mv;
	}
	
	/**
	 * 여러 개의 요청이 같은 메서드(Controller)를 호출
	 * 
	 * @param: Model은 뷰에 전달될 객체
	 * @return: String은 뷰의 이름이 된다.
	 * */
	@RequestMapping(value = {"/b.do", "/c.do"})
	public String cc(Model model) {
		System.out.println("여러 개의 요청이 같은 메서드(Controller)를 호출하기");
		
		model.addAttribute("message", "졸려");
		model.addAttribute("id", "mingming");
		
		return "result"; // 뷰 이름이 된다.
	}
	
	/**
	 * 요청방식(get or post, put, delete)에 따라 다른 메서드 호출
	 * @return: void인 경우는 요청 이름이 뷰의 이름이 된다.
	 * 예를 들어 rem/test.do 요청되면, 
	 * WEB-INF/views/rem/test.jsp
	 * */
	@PostMapping("/test.do")
	public void aa(HttpServletRequest request) {
		String name = request.getParameter("name");
		System.out.println("post방식 test.do가 요청되었습니다. name: " + name);
	}
	
	@GetMapping("/test.do")
	public void bbb(String name) {
		// request를 구해서 getParameter는 굳이 하지 않아도 된다. 숫자 값이나 넘어올 값이 한 두개 정도일 때에는 써도 될듯.
		System.out.println("Get방식 test.do가 요청되었습니다. name: " + name);
		// 한글깨짐 방지를 위해서 인코딩 처리를 해야된다.
	}
	
	/**
	 * parameter 정보에 따라 Mapping 처리하기
	 * */
	@RequestMapping(value="a.do", params = {"id=!jang", "age"})
	public void dd() {
		System.out.println("a.do의 parameter 정보에 따른 Mapping");
	}

}

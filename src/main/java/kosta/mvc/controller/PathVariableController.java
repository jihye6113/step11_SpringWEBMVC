package kosta.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PathVariableController {
	
	@RequestMapping(value = "{type}/{id}.do") 
	public String aa(@PathVariable String type, @PathVariable String id) { // ?type=cafe&id=bjhye // 이름이 같은 것이 중요하지, String id, String type처럼 순서는 바뀌어도 된다.
		System.out.println("PathVariableController 실행됨");
		System.out.println("type: " + type);
		System.out.println("id: " + id);
		return "result";
	}
	
	/**
	 * /blog/* 설정
	 * */
	@RequestMapping(value = "/{id}")
	public String bb(@PathVariable String id) {
		System.out.println("blog/"+id+"가 요청되었습니다.");
		
		return "result";
	}
	
	@RequestMapping(value="{type}/{kind}/{no}") // @RequestMapping(value="board/{kind}/{no}")도 가능
	public String cc(@PathVariable(name="type") String typeName, @PathVariable String kind, @PathVariable int no) {
		System.out.println(typeName+"/"+kind+"/"+no+"가 요청되었습니다.");
		
		return "result";
	}
	
	@RequestMapping("{url}.do")
	public void url() {} // void의 의미: 요청된 주소 url으로 이동한다. 들어오는 주소가 view의 이름이 된다.
	// ex) http://localhost:8888/controller/jihye.do -> jihye.jsp를 찾아서 화면에 띄운다.

}

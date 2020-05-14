package kosta.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PathVariableController {
	
	@RequestMapping(value = "{type}/{id}.do") 
	public String aa(@PathVariable String type, @PathVariable String id) { // ?type=cafe&id=bjhye // �̸��� ���� ���� �߿�����, String id, String typeó�� ������ �ٲ� �ȴ�.
		System.out.println("PathVariableController �����");
		System.out.println("type: " + type);
		System.out.println("id: " + id);
		return "result";
	}
	
	/**
	 * /blog/* ����
	 * */
	@RequestMapping(value = "/{id}")
	public String bb(@PathVariable String id) {
		System.out.println("blog/"+id+"�� ��û�Ǿ����ϴ�.");
		
		return "result";
	}
	
	@RequestMapping(value="{type}/{kind}/{no}") // @RequestMapping(value="board/{kind}/{no}")�� ����
	public String cc(@PathVariable(name="type") String typeName, @PathVariable String kind, @PathVariable int no) {
		System.out.println(typeName+"/"+kind+"/"+no+"�� ��û�Ǿ����ϴ�.");
		
		return "result";
	}
	
	@RequestMapping("{url}.do")
	public void url() {} // void�� �ǹ�: ��û�� �ּ� url���� �̵��Ѵ�. ������ �ּҰ� view�� �̸��� �ȴ�.
	// ex) http://localhost:8888/controller/jihye.do -> jihye.jsp�� ã�Ƽ� ȭ�鿡 ����.

}

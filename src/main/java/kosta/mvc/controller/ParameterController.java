package kosta.mvc.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kosta.mvc.domain.Member;

@Controller
@RequestMapping("/param")
public class ParameterController {

	/**
	 * ���� int���� null�� ���� �� �ִ� ��Ȳ�̶��
	 * Integer�� �����Ѵ�.
	 * */
	@RequestMapping("a.do")
	//public ModelAndView aa(String name, int age) {
	public ModelAndView aa(String name, Integer age) {
		System.out.println("name: " + name);
		System.out.println("age: " + age);
		
		return new ModelAndView("result"); // ���̸� ����
	}
	
	/**
	 * ������ ���۵Ǵ� ���� ���� �����͸� domain ��ü�� binding �ϱ�
	 * 
	 * parameter ������ DTO ��ü�� ������ �� ������
	 * �������� �״�� ���޵Ǿ� ����� �� �ִ�.
	 * ������������ �Ӽ��鿡 �����Ҷ���
	 * ��ü �̸��� ù���ڸ� �ҹ��ڷ� �����Ѵ�.
	 * ex) Member ��ü��� ${member.id}
	 * 
	 * ����, ����� ��ü�� �̸��� �����ϰ� ������
	 * @ModelAttribute("")�� �����ؼ� ��Ī�� �����, ����Ѵ�.
	 * */
	@PostMapping("/c.do")
	public String dd(@ModelAttribute("m") Member member) {
		System.out.println(member);
		
		return "paramResult"; // WEB-INF/views/paramResult.jsp
	}
	
	/**
	 * �޼��� ����� ���� @ModelAttribute�� �����ϸ�
	 * ���� ��Ʈ�ѷ��� ��ȴٰ� ��� �̵��ϴ� ��������
	 * Model ������ ���޵ȴ�. �信�� ${} ��밡��
	 * */
	@ModelAttribute("msg")
	public String test() {
		return "Spring ¯ ���ƿ� ^^";
	}
	
	@ModelAttribute("hobbies")
	public List<String> test2(){
		List<String> list = Arrays.asList(new String [] {"����", "����", "����", "���"});
		
		return list;
	}
	
	/**
	 * @RequestParam�� �����ϸ� required="true"�̹Ƿ�
	 * �ݵ�� ���� ���;� �Ѵ�.
	 * ����, ���� ���� �� �ִٸ� defaultValue�� �����Ѵ�.
	 * */
	@RequestMapping(value = "/d.do")
	public void dd(@RequestParam(name = "id", defaultValue = "Guest") String userId, // required = "false"�� ����
			@RequestParam(defaultValue = "0")int age) { 
		System.out.println("userId = " + userId);
		System.out.println("age = " + age);
	}
}

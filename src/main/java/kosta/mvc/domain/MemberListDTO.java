package kosta.mvc.domain;

import java.util.List;

public class MemberListDTO {

	private List<Member> list;

	public List<Member> getList() {
		System.out.println();
		System.out.println("List<Member> getList(): " + list);
		return list;
	}

	public void setList(List<Member> list) {
		System.out.println("setList(List<Member> list) È£ÃâµÊ. list = " + list);
		this.list = list;
	}
}

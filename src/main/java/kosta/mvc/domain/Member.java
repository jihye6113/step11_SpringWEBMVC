package kosta.mvc.domain;

public class Member {

	private String id;
	private String name;
	private int age;
	private String addr;
	
	private boolean state;

	public boolean isState() { // getState°°Àº
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		System.out.println("setId(String id) call " + id);
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		System.out.println("setName(String name) call " + name);
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		System.out.println("setAge(int age) call " + age);
		this.age = age;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		System.out.println("setAddr(String addr) call " + addr);
		this.addr = addr;
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", name=" + name + ", age=" + age + ", addr=" + addr + "]";
	}
}

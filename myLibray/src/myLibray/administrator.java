package myLibray;

public class administrator extends person {

	protected administrator(String name, String sex, int age, String phone_muber, String passWrod, String user) {
		super(name, sex, age, phone_muber, passWrod, user);
		// TODO 自动生成的构造函数存根
	}

	@Override
	public String show_degree() {
		// TODO 自动生成的方法存根
		return "administrator";
	}

	@Override
	public String show_introduce() {
		// TODO 自动生成的方法存根
		return name+"\t"+sex+"\t"+age+"\t"+phone_muber+"\t";
	}

	@Override
	public String show_ranking() {
		// TODO 自动生成的方法存根
		return null;
	}
   
}

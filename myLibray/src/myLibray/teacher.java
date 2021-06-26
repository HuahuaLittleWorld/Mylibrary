package myLibray;

public class teacher extends user {
	public String show_degree() {
		return "Teacher";
	}

	final static int max_borrow=30;
	protected teacher(String name, String sex, int age, String phone_muber, String passWrod, String user) {
		super(name, sex, age, phone_muber, passWrod, user);
		// TODO 自动生成的构造函数存根
	}
	public teacher() {
		// TODO 自动生成的构造函数存根
	}
	@Override
	public String show_introduce() {
		// TODO 自动生成的方法存根
		return name+"\t"+sex+"\t"+age+"\t"+phone_muber+"\t"+borroweBooks.size()+"\t";
	}
}

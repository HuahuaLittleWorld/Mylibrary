package myLibray;

public class teacher extends user {
	public String show_degree() {
		return "Teacher";
	}

	final static int max_borrow=30;
	protected teacher(String name, String sex, int age, String phone_muber, String passWrod, String user) {
		super(name, sex, age, phone_muber, passWrod, user);
		// TODO �Զ����ɵĹ��캯�����
	}
	public teacher() {
		// TODO �Զ����ɵĹ��캯�����
	}
	@Override
	public String show_introduce() {
		// TODO �Զ����ɵķ������
		return name+"\t"+sex+"\t"+age+"\t"+phone_muber+"\t"+borroweBooks.size()+"\t";
	}
}

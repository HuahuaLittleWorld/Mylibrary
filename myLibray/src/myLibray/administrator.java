package myLibray;

public class administrator extends person {

	protected administrator(String name, String sex, int age, String phone_muber, String passWrod, String user) {
		super(name, sex, age, phone_muber, passWrod, user);
		// TODO �Զ����ɵĹ��캯�����
	}

	@Override
	public String show_degree() {
		// TODO �Զ����ɵķ������
		return "administrator";
	}

	@Override
	public String show_introduce() {
		// TODO �Զ����ɵķ������
		return name+"\t"+sex+"\t"+age+"\t"+phone_muber+"\t";
	}

	@Override
	public String show_ranking() {
		// TODO �Զ����ɵķ������
		return null;
	}
   
}

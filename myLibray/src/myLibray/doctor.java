package myLibray;

import java.util.ArrayList;

public class doctor extends user{
    @Override
    public String show_degree() {
    	// TODO �Զ����ɵķ������
    	return "Doctor";
    }
	protected doctor(String name, String sex, int age, String phone_muber, String passWrod, String user) {
		super(name, sex, age, phone_muber, passWrod, user);
		// TODO �Զ����ɵĹ��캯�����
	}
	public doctor() {
		// TODO �Զ����ɵĹ��캯�����
	}
	public boolean borrow_book(book temp_book) {
		// TODO �Զ����ɵķ������
	    if(temp_book.getInventoryOfBook()<=0) {
	    	System.err.println("�������ͼ����ȫ�������");
	    	return false;
	    }
	    if(!temp_book.isLendOfbook()) {
	    	System.err.println("��Ǹ��"+temp_book.getTitleOfBook()+"�ѱ����");
	    	return false;
	    }
	    if(getBorroweBooks().size()<=max_borrow)
	    this.borroweBooks.add(temp_book);
	    temp_book.setInventoryOfBook(temp_book.getInventoryOfBook()-1);
	    return true;
	}
	final static int max_borrow=25;
	@Override
	public String show_introduce() {
		// TODO �Զ����ɵķ������
		return name+"\t"+sex+"\t"+age+"\t"+phone_muber+"\t"+borroweBooks.size()+"\t";
	}
	
	
}

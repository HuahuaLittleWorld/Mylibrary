package myLibray;

import java.util.ArrayList;

abstract class user extends person implements book_borrow_return ,Comparable<user> ,show_me{
    protected user(String name, String sex, int age, String phone_muber, String passWrod, String user) {
		super(name, sex, age, phone_muber, passWrod, user);
		// TODO �Զ����ɵĹ��캯�����
	}
    public user() {
		super();// TODO �Զ����ɵĹ��캯�����
	}
    //������
    @Override
    public int compareTo(user o) {
    	// TODO �Զ����ɵķ������
    	return o.Max_borrow_number-this.Max_borrow_number;
    }
    private int Max_borrow_number=0;
    //�����û��ѽ���ͼ��
	ArrayList<book> borroweBooks = new ArrayList<book>();
   @Override
   //��������Ǹ������
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
	    this.borroweBooks.add(temp_book);
	    temp_book.setInventoryOfBook(temp_book.getInventoryOfBook()-1);
	    return true;
	}
   
    @Override
    public boolean return_book(book temp_book) {
    	// TODO �Զ����ɵķ������
    	return false;
    }
	protected ArrayList<book> getBorroweBooks() {
		return borroweBooks;
	}
	protected void setBorroweBooks(ArrayList<book> borroweBooks) {
		this.borroweBooks = borroweBooks;
	}
	protected int getMax_borrow_number() {
		return Max_borrow_number;
	}
	protected void setMax_borrow_number(int max_borrow_number) {
		Max_borrow_number = max_borrow_number;
	}
    public String show_ranking() {
    	//                 �û���     ����       �Ա�      ����     ������
		return getUser()+"\t"+name+"\t"+sex+"\t"+age+"\t"+Max_borrow_number;
	}
}
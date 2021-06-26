package myLibray;

import java.util.ArrayList;

public class doctor extends user{
    @Override
    public String show_degree() {
    	// TODO 自动生成的方法存根
    	return "Doctor";
    }
	protected doctor(String name, String sex, int age, String phone_muber, String passWrod, String user) {
		super(name, sex, age, phone_muber, passWrod, user);
		// TODO 自动生成的构造函数存根
	}
	public doctor() {
		// TODO 自动生成的构造函数存根
	}
	public boolean borrow_book(book temp_book) {
		// TODO 自动生成的方法存根
	    if(temp_book.getInventoryOfBook()<=0) {
	    	System.err.println("您所借的图书以全部被借出");
	    	return false;
	    }
	    if(!temp_book.isLendOfbook()) {
	    	System.err.println("抱歉，"+temp_book.getTitleOfBook()+"已被借出");
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
		// TODO 自动生成的方法存根
		return name+"\t"+sex+"\t"+age+"\t"+phone_muber+"\t"+borroweBooks.size()+"\t";
	}
	
	
}

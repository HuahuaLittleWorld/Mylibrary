package myLibray;

import java.util.ArrayList;

abstract class user extends person implements book_borrow_return ,Comparable<user> ,show_me{
    protected user(String name, String sex, int age, String phone_muber, String passWrod, String user) {
		super(name, sex, age, phone_muber, passWrod, user);
		// TODO 自动生成的构造函数存根
	}
    public user() {
		super();// TODO 自动生成的构造函数存根
	}
    //排序函数
    @Override
    public int compareTo(user o) {
    	// TODO 自动生成的方法存根
    	return o.Max_borrow_number-this.Max_borrow_number;
    }
    private int Max_borrow_number=0;
    //储存用户已借阅图书
	ArrayList<book> borroweBooks = new ArrayList<book>();
   @Override
   //忘了这个是干嘛的了
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
	    this.borroweBooks.add(temp_book);
	    temp_book.setInventoryOfBook(temp_book.getInventoryOfBook()-1);
	    return true;
	}
   
    @Override
    public boolean return_book(book temp_book) {
    	// TODO 自动生成的方法存根
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
    	//                 用户名     姓名       性别      年龄     借阅量
		return getUser()+"\t"+name+"\t"+sex+"\t"+age+"\t"+Max_borrow_number;
	}
}
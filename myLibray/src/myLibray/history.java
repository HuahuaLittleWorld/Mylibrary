package myLibray;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedList;
/*
 * 构建操作记录类
 */
import java.util.Queue;
public class history extends person {
	
	/* 有从人类继承而来的
	 *  String name;
   	 *	String user;
   	 *	String passWrod;
   	 *	String phone_muber;
   	 *	String sex;
   	 *	int age;
	 * --------------成员变量----------------
	 */
	    private Date history_data=new Date();
		private String op;
		private String role;
		//图书被借阅次数排行榜
		static ArrayList<book> borrowed_ranking_list_OfBook =new ArrayList<book>();
		//读者借阅次数排行榜
		static ArrayList<user> borrowing_ranking_list_OfUser =new ArrayList<user>();
		//日志表
		static Queue<history> log_sheet=new LinkedList<history>();
		//初始化
		static {
			borrowed_ranking_list_OfBook.addAll(data.libOfBook_CS);
			borrowed_ranking_list_OfBook.addAll(data.libOfbook_Liberal_arts);
			borrowing_ranking_list_OfUser.addAll(data.user_resited);
		}
	/*
	 * 
	 * --------------成员变量----------------
	 */
	
	//-------------成员方法-----------------
		
		
		
		
	//日志生成方法
		
		
		
		
		
		
		
		
		
		
		
		
		
	/*-------------记录最高借阅读者和被借阅次数最多图书功能实现-------------------
	 * 存储借阅最次数最多的用户
	 * 被借阅次数最多的图书
	 * 读者借阅次数排行榜
	 * 图书被借阅次数排行榜
	 */

	//用户排行榜更新
	static void refresh_ranking_list(user temp) {
		if(borrowing_ranking_list_OfUser.contains(temp)) {
			temp.setMax_borrow_number(temp.getMax_borrow_number()+1);
		}
		else 
		{
			borrowing_ranking_list_OfUser.add(temp);
			temp.setMax_borrow_number(1);
		}
		Collections.sort(borrowing_ranking_list_OfUser);
	}
	static void refresh_ranking_list() {
		Collections.sort(borrowing_ranking_list_OfUser);
		Collections.sort(borrowed_ranking_list_OfBook);
	}
	
	//书籍排行榜更新
	static void refresh_ranking_list(book temp) {
		if(borrowed_ranking_list_OfBook.contains(temp)) {
			temp.setMax_borrow_number(temp.getMax_borrow_number()+1);
		}
		else 
		{
			borrowed_ranking_list_OfBook.add(temp);
			temp.setMax_borrow_number(1);
		}
		Collections.sort(borrowed_ranking_list_OfBook);
	}
	//得到借书最多的读者
	static user get_Max_borrow_readr() {
		return borrowing_ranking_list_OfUser.get(0);
	}
	//得到被借阅次数最多的图书
		static book get_Max_borrow_book() {
			return borrowed_ranking_list_OfBook.get(0);
		}
	//-------------成员方法-----------------
	
	
	
	
	
	
	//-------------------构造方法---------------------------
  	public history(person man,Date t,String op) {
		super.name=man.getName();
		this.history_data=t;
		this.op=op;
		this.user=man.getUser();
		this.role=man.show_degree();
		// TODO 自动生成的构造函数存根
	}
  	//-------------------构造方法---------------------------
  	
  	
  	
  	
  	
  	
  	
  	
  	
  	
  	
  	
  	
  	
  	
  	//---------------show_me接口----------------------
	@Override
	public String show_degree() {
		// TODO 自动生成的方法存根
		return null;
	}	
	@Override
	public String show_ranking() {
		// TODO 自动生成的方法存根
		return null;
	}
	@Override
	public String show_introduce() {
		// TODO 自动生成的方法存根
		 SimpleDateFormat formatter =new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		return user+"\t"+name+"\t"+role+"\t"+op+"\t"+formatter.format(history_data);
	}
	//---------------show_me接口----------------------
	
	
	
	
	
	
	
	
	
	
	//-------------------getter & setter ----------------
     protected Date getHistory_data() {
		return history_data;
	}
	protected void setHistory_data(Date history_data) {
		this.history_data = history_data;
	}
	protected String getOp() {
		return op;
	}
	protected void setOp(String op) {
		this.op = op;
	}
	//-----------------------------------------------------

}

package myLibray;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedList;
/*
 * ����������¼��
 */
import java.util.Queue;
public class history extends person {
	
	/* �д�����̳ж�����
	 *  String name;
   	 *	String user;
   	 *	String passWrod;
   	 *	String phone_muber;
   	 *	String sex;
   	 *	int age;
	 * --------------��Ա����----------------
	 */
	    private Date history_data=new Date();
		private String op;
		private String role;
		//ͼ�鱻���Ĵ������а�
		static ArrayList<book> borrowed_ranking_list_OfBook =new ArrayList<book>();
		//���߽��Ĵ������а�
		static ArrayList<user> borrowing_ranking_list_OfUser =new ArrayList<user>();
		//��־��
		static Queue<history> log_sheet=new LinkedList<history>();
		//��ʼ��
		static {
			borrowed_ranking_list_OfBook.addAll(data.libOfBook_CS);
			borrowed_ranking_list_OfBook.addAll(data.libOfbook_Liberal_arts);
			borrowing_ranking_list_OfUser.addAll(data.user_resited);
		}
	/*
	 * 
	 * --------------��Ա����----------------
	 */
	
	//-------------��Ա����-----------------
		
		
		
		
	//��־���ɷ���
		
		
		
		
		
		
		
		
		
		
		
		
		
	/*-------------��¼��߽��Ķ��ߺͱ����Ĵ������ͼ�鹦��ʵ��-------------------
	 * �洢��������������û�
	 * �����Ĵ�������ͼ��
	 * ���߽��Ĵ������а�
	 * ͼ�鱻���Ĵ������а�
	 */

	//�û����а����
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
	
	//�鼮���а����
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
	//�õ��������Ķ���
	static user get_Max_borrow_readr() {
		return borrowing_ranking_list_OfUser.get(0);
	}
	//�õ������Ĵ�������ͼ��
		static book get_Max_borrow_book() {
			return borrowed_ranking_list_OfBook.get(0);
		}
	//-------------��Ա����-----------------
	
	
	
	
	
	
	//-------------------���췽��---------------------------
  	public history(person man,Date t,String op) {
		super.name=man.getName();
		this.history_data=t;
		this.op=op;
		this.user=man.getUser();
		this.role=man.show_degree();
		// TODO �Զ����ɵĹ��캯�����
	}
  	//-------------------���췽��---------------------------
  	
  	
  	
  	
  	
  	
  	
  	
  	
  	
  	
  	
  	
  	
  	
  	//---------------show_me�ӿ�----------------------
	@Override
	public String show_degree() {
		// TODO �Զ����ɵķ������
		return null;
	}	
	@Override
	public String show_ranking() {
		// TODO �Զ����ɵķ������
		return null;
	}
	@Override
	public String show_introduce() {
		// TODO �Զ����ɵķ������
		 SimpleDateFormat formatter =new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		return user+"\t"+name+"\t"+role+"\t"+op+"\t"+formatter.format(history_data);
	}
	//---------------show_me�ӿ�----------------------
	
	
	
	
	
	
	
	
	
	
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

package myLibray;

import java.io.ByteArrayInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

interface studentManage{
	boolean add_student();
	boolean sub_student(user temp_user);
	boolean alt_student(user temp_user);
	boolean add_book();
	boolean sub_book(book temp_book);
	boolean alt_book(user temp);
}
interface book_borrow_return{
	boolean borrow_book(book temp_book);
	boolean return_book(book temp_book);
}
interface book_alter_add_sub{
	boolean alter_book(book temp_book);
	boolean add_book(book temp_book);
	boolean sub_book(book temp_book);
}
interface show_me{
	String show_degree();
	String show_introduce();
	String show_ranking();
}
public class libray_Interface  {
	//��ģ������
	//����ģ������
   static protected void fuzzy_search_book(){
	   Scanner sc=new Scanner(System.in);
	  String key_word=sc.next();
	  //�Ƿ��ѯ�ɹ�
	   boolean query=false; 
	   //��ȡ����ϣ���keyֵ�Ա������������ͼ��
	   for(Integer key:data.lib.keySet()) {
		   //�򵥵�ʹ�����ַ�����indexOf����������ģ����
		   if(data.lib.get(key).getTitleOfBook().indexOf(key_word)!=-1||data.lib.get(key).getAuthorOfBook().indexOf(key_word)!=-1) {
				//���������ͼ��Ļ�����Ϣ
			   	System.out.println( data.lib.get(key).show_introduce());
				query=true;
				//��¼����
				record(system_frame.getLog_er(), get_Time(), "ʹ��ģ�������������˹ݲر�ţ�"+data.lib.get(key).show_degree()+"������"+data.lib.get(key).getTitleOfBook());
			}
		}
	   //��û��������һ����Ϣ�����������ʾ��Ϣ
	   if(!query) {
		   System.out.println("��ǸΪ����������鼮");
		   record(system_frame.getLog_er(), get_Time(), "ʹ�ùؼ���"+key_word+"����ģ����ѯ��δ��ѯʧ�ܣ�û�ü���������鼮");
	   }
   }
   //_______________________________________________________________________
   //��¼֪ͨ
   static void log_inform() {
	   system_frame.getLog_er().show_mail();
	   System.out.println("������������Ӧָʾ�Խ�����һ������");
	   System.out.println("1�����ڴ����ʼ�");
	   System.out.println("2���Ժ����ʼ�");
	   Scanner sc=new Scanner(System.in);
	   int op=sc.nextInt();
	   if(op==1) {
		   deal_myMail();
	   }
   }
   private static void deal_myMail() {
	// TODO �Զ����ɵķ������
	 System.out.println("���롰\\�������Ѷ�");
	 System.out.println("���롰/�������Ժ��������");
	 Scanner sc=new Scanner(System.in);
	 String op;
	 while(!system_frame.getLog_er().my_mails.isEmpty()) {
		 op=sc.nextLine();
		 if(op.equals("\\")) {
			 system_frame.getLog_er().my_mails.poll();
		 }
		 if(op.equals("/")) {
			 return ;
		 }
		 system_frame.getLog_er().show_mail();		
	 }
	 if(system_frame.getLog_er().my_mails.isEmpty()) {
		 System.out.println("��Ϣ��ȫ����գ������µ���Ϣ");
	 }
   }
//�鼮��Ϣչʾ 
   static public void show_book(book tempBook) {
	   System.out.println("������      ���ߣ�    �����磺         ISBN��           ���ۣ�        ��棺   ");
	   System.out.println(tempBook.show_introduce());
	   //System.out.println(tempBook.getTitleOfBook()+"\t"+tempBook.getAuthorOfBook()+"\t"+tempBook.getPressOfBook()+"\t"+tempBook.getIsbnOfBook()+"\t"+tempBook.getPriceOfBook()+"\t"+tempBook.getInventoryOfBook());
   }
   static public void show_user(user tempUser) {
	   System.out.println("������      �Ա�    ���䣺    �ѽ�ͼ��������      ");
	   
   }
   //��¼���� ���ð�����Ȩ������ ֻ�ܱ�����ʹ��
   static  boolean logn() {
	   Scanner sc=new Scanner(System.in);
	   boolean exit=false;
	   while(!exit) {
		   System.out.println("�����������˻���");
		   String User=sc.nextLine();
		   //��ֹ��Ӣ�����뷨�����޷���������
		   if(User.equals("~")||User.equals("`")) {
			   System.out.println("ϵͳ���˳�");
			   break;
		   }
		   //�����û��б�
		   //��̬����
		   for(person e: data.all_user) {
			   if(e.getUser().equals(User)) {
				   while(true) {
					   System.out.println("��������������");
					   String passwrod=sc.nextLine();
					   //��ֹ��Ӣ�����뷨�����޷���������
					   if(passwrod.equals("$")||passwrod.equals("��")) {
						   break;
					   }
					   if(passwrod.equals(e.getPassWrod())) {
						   System.out.println(e.getName()+e.show_degree());
						   //���õ�¼��
						   system_frame.setLog_er(e);
						   //��¼�����ɹ�
						   record(e, get_Time(), "��¼ͼ���ϵͳ�ɹ�");
						   //�����ɹ�����
						   System.out.println(e.getName()+"��ϲ��ɹ�����ͼ���ϵͳ");
						   //չʾ�ʼ���Ϣ
						   log_inform();
						   return true;
					   }
					   System.err.println("������󣡣������������룬���û�����������$�����������û���");
				   }
			   }
		   }
		   System.out.println("��������˻��������ڣ����������룬�����˳�ϵͳ������~");
	   }
	   return false;
   }
   //���������������������������������������������������������������������������������û��˲�����������������������������������������������������������������������������������������������
   //����ͼ��
   static void borrowing_book() {
	   System.out.println("��������Ҫ����ͼ��Ĺݲر��");
	   System.out.println("�������Ҫͼ���������������Ӧָ��");
	   System.out.println("1����׼����");
	   System.out.println("2��ģ������");
	   System.out.println("3������������ͼ��");
	   System.out.println("4���������������ͼ��");
	   System.out.println("����Ҫ�����������������+�س�����");
	   Scanner sc=new Scanner(System.in);
	   String op=sc.next();
	   //Ϊ��ʵ�������+�س����������ѵĲ�������ϣ�����ǿ�����һ�����õķ���
	   try{

		   Integer.parseInt(op);
		   switch(Integer.parseInt(op)) {
		   case 1:{
			   search_book();
		   }
		   break;
		   case 2:{
			   fuzzy_search_book();
		   }
		   break;
		   case 3:{
			   view_CS();
		   }
		   break;
		   case 4:{
			   view_Liberal_arts();
		   }
		   default:{
			   break;
		   }
	   }
       }
	   catch(NumberFormatException e){


		}
	   
	   System.out.println("��������Ҫ���ĵ�ͼ��Ĺݲر��");
	   Integer op_book=sc.nextInt();
	   if(data.lib.containsKey(op_book)) {
		   if(data.lib.get(op_book).getInventoryOfBook()>0) {
			   data.lib.get(op_book).setInventoryOfBook(data.lib.get(op_book).getInventoryOfBook()-1);
			   //���Լ��������Ӹ���
			   Type_conversion().getBorroweBooks().add(data.lib.get(op_book));
			   //�����ɹ�����
			   System.out.println("��ϲ���ѳɹ�����"+data.lib.get(op_book).getTitleOfBook());
			   //���ͽ��İ����
			   history.refresh_ranking_list(data.lib.get(op_book));
			   history.refresh_ranking_list(Type_conversion());
			   //��¼�����ɹ�
			   record(system_frame.getLog_er(), get_Time(), "����ͼ��"+data.lib.get(op_book).getTitleOfBook()+"�ɹ�");
		   }
		   else if(data.lib.get(op_book).isLendOfbook()){
			   System.err.println("��Ǹ�������ĵ�ͼ���ѱ�����");
			   record(system_frame.getLog_er(), get_Time(), "����ͼ��"+data.lib.get(op_book).getTitleOfBook()+"ʧ�ܡ�ʧ��ԭ�򣺹��ڸ����ѱ�����");
		   }
		   else {
			   System.err.println("��������鼮�ѱ��¼�");
			   record(system_frame.getLog_er(), get_Time(), "����ͼ��"+data.lib.get(op_book).getTitleOfBook()+"ʧ�ܡ�ʧ��ԭ�򣺹��ڸ����ѱ��¼�");
		   }
	   }
	   else {
		   System.out.println("��������"+op_book+"���󣬿��ܱ����������ϸ���");
		   record(system_frame.getLog_er(), get_Time(), "����ͼ��������");
	   }
   }
   //��׼����ͼ��
   private static void search_book() {
	// TODO �Զ����ɵķ������
	Scanner sc=new Scanner(System.in);
	String keyworld=sc.nextLine();
	boolean isSearched=false;
	for(Integer key: data.lib.keySet()) {
		if(data.lib.get(key).getAuthorOfBook().equals(keyworld)||data.lib.get(key).equals(keyworld)) {
			System.out.print(data.lib.get(key).show_degree());
			System.out.println(data.lib.get(key).show_introduce());
			isSearched=true;
			record(system_frame.getLog_er(), get_Time(), "ʹ�ùؼ���"+keyworld+"���о�׼��ѯ�ɹ�����ѯ�����鼮"+data.lib.get(key).show_degree()+"\t"+data.lib.get(key).getTitleOfBook());
		}
	}
	if(!isSearched) {
		System.out.println("��Ǹδ����������鼮");
		record(system_frame.getLog_er(), get_Time(), "ʹ�ùؼ���"+keyworld+"���о�׼��ѯʧ�ܣ�û�м���������鼮");
	}
   }
   //�黹ͼ��
   static void return_book() {
	   System.out.println("���������ѽ��ĵ�ͼ�飺");
	   //�����Ҫ�Ľ������Ҳ�̫�ᣬ��Ҫ���и�ת��
	   for(book e: Type_conversion().getBorroweBooks()) {
		   e.show_introduce();
	   }
	   System.out.println("����������Ҫ�黹��ͼ��Ĺݲر�ţ�");
	   Scanner sc=new Scanner(System.in);
	   Integer book_index=sc.nextInt();
	   if(data.lib.containsKey(book_index)) {
		   if(Type_conversion().getBorroweBooks().contains(data.lib.get(book_index))){
			   Iterator<book> it=Type_conversion().getBorroweBooks().iterator();
			   while (it.hasNext()) {
				book book = (book) it.next();
				if(book.show_degree().equals(book_index.toString())) {
					Type_conversion().getBorroweBooks().remove(book);
					//�����ɹ�����
					System.out.println("��ϲ���ѳɹ���"+book.getTitleOfBook()+"�黹�ɹ�");
					//��¼�ɹ�����
					record(system_frame.getLog_er(), get_Time(), "�ɹ���"+book.getTitleOfBook()+"�黹�ɹ�");
				}
			   } 
		   }
		   else {
			   //����ʧ������
			   System.out.println("�����ѽ�ͼ���в�û��"+data.lib.get(book_index).getTitleOfBook());
			   //��¼����ʧ��
			   record(system_frame.getLog_er(), get_Time(),"����ʧ�ܣ�ʧ��ԭ�������ѽ�ͼ��δ���ҵ�"+data.lib.get(book_index).getTitleOfBook() );
		   }
	   }
	   else {
		   System.err.println("������Ĺݲر��"+book_index+"����");
		   System.err.println("������ٽ��д˲���");
	   }
   }
   //�鿴���˼��
	static void view_profile() {
		System.out.println(system_frame.getLog_er().show_introduce());
	}
   //��ת������ת��С����
	private static user Type_conversion() {
	// TODO �Զ����ɵķ������
	   if(system_frame.getLog_er() instanceof teacher) {
		   user t=new teacher();
		   t=(user)system_frame.getLog_er();
		   return t;
	   }
	   if(system_frame.getLog_er() instanceof doctor) {
		   user t=new doctor();
		   t=(user)system_frame.getLog_er();
		   return t;
	   }
	   if(system_frame.getLog_er() instanceof master) {
		   user t=new master();
		   t=(user)system_frame.getLog_er();
		   return t;
	   }
	   if(system_frame.getLog_er() instanceof bachelor) {
		   user t=new bachelor();
		   t=(user)system_frame.getLog_er();
		   return t;
	   }
	   return null;
}

//����������������������������������������������������������������������������������������Ա�˲���������������������������������������������������������������������������������������
   
   
   //�ϼ��鼮
	protected static void add_book() {
		// TODO �Զ����ɵķ������
		System.out.println("�밴˳�������ϼ�ͼ�����ȷ��Ϣ��");
		System.out.println("****��������77�ɷ����ϲ�˵�****");
		System.out.println("****��������������뻻������777����������");
		book temp=new book();
    	boolean isregister=true;
		Scanner sc2=new Scanner(System.in);
    	for(int i=0;i<5;i++) {
			if(i==0){
				System.out.println("������¼���鼮������");
				String title=sc2.nextLine();
				temp.setTitleOfBook(title);
				if(title.equals("77")) {
					isregister=false;
					break;
				}
			}
			if(i==1) {
				System.out.println("������¼���鼮����������");
				String author=sc2.nextLine();
				temp.setAuthorOfBook(author);
				if(author.equals("777")) {
					i-=2;
				}
				if(author.equals("77")) {
					isregister=false;
					break;
				}
			}
			if(i==2) {
				System.out.println("������¼���鼮���������ƣ�");
				String press=sc2.nextLine();
				temp.setPressOfBook(press);
				if(press.equals("777")) {
					i-=2;
				}
				if(press.equals("77")) {
					isregister=false;
					break;
				}
			}
			if(i==3) {
				System.out.println("������¼���鼮ISBN��ţ�");
				String ISBN=sc2.nextLine();
				temp.setIsbnOfBook(ISBN);
				if(ISBN.equals("777")) {
					i-=2;
				}
				if(ISBN.equals("77")) {
					isregister=false;
					break;
				}
			}
			if(i==4) {
				System.out.println("������¼���鼮���");
			    int inventoryOfBook=sc2.nextInt();
			    temp.setInventoryOfBook(inventoryOfBook);
			    if(inventoryOfBook==777) {
					i-=2;
				}
				if(inventoryOfBook==77) {
					isregister=false;
					break;
				}
			}
		}
    	
    	if(isregister) {
    		int op;
    		while (true) {
    			System.out.println("������¼���鼮�ķ����� \n1������� \n2���������\n���������ǰ��ż��ɣ�");
        		op=sc2.nextInt();
        		if(op==2||op==1)
        			break;
        		if(op==777) {
        			System.out.println("���ѳɹ�ȡ���˴β���");
        			return;
        		}
        		System.err.println("���������밴��ʾ������ʵ�ѡ���������¼�����������777");
			}
    		if(op==1)
    			data.libOfBook_CS.add(temp);
    		else {
				data.libOfbook_Liberal_arts.add(temp);
			}
    		//���ϼ�ͼ��������
    		data.lib.put(temp.hashCode()%100000, temp);
    		//��������������
			System.out.println("��ϲ��"+temp.getTitleOfBook()+"�Ѿ��ɹ��ϼܹݲر��Ϊ��"+temp.hashCode()%1000);
			//��¼����
			record(system_frame.getLog_er(), get_Time(), "�ɹ��ϼ�ͼ��"+temp.getTitleOfBook());
		}
	}
	//�¼��鼮
	static void sub_book() {
		Scanner sc=new Scanner(System.in);
		System.out.println("���Ƿ���Ҫ���ȫ��ͼ���Ի����Ҫ�¼����ͼ��Ĺݲر�š�����Ҫ������1������Ҫ�س����ɣ�");
		String op=sc.nextLine();
		if(op.equals("1")) {
			view_lib();
		}
		System.out.println("��������Ҫɾ����Ĺݲر�ţ�");
		int index=sc.nextInt();
//		try {
//			data.lib.remove(index);
//		} catch (Exception e) {
//			e.printStackTrace();
//			// TODO: handle exception
//		}
		if(data.lib.containsKey(index)) {
			data.libOfBook_CS.remove(data.lib.get(index));
			data.libOfbook_Liberal_arts.remove(data.lib.get(index));
			//�����ɹ�����
			System.out.println(data.lib.get(index).show_degree()+data.lib.get(index).getTitleOfBook()+"�ѱ��¼�");
			//��¼�ɹ�����
			record(system_frame.getLog_er(), get_Time(), "�ɹ��¼�ͼ��"+data.lib.get(index).getTitleOfBook());
			data.lib.remove(index);
		}
		else {
			//����ʧ������
			System.err.println("�¼�ʧ�ܣ�"+"\n"+"������Ĺݲر�ţ�"+index+"  ������в�δ��ѯ��������������ٽ��дβ���");
			//��¼ʧ�ܲ���
			record(null, get_Time(), op);
		}
	}
//	private static void book_all_show() {
//		// TODO �Զ����ɵķ������
//		System.out.println("����"+"\t"+"����"+"\t"+"������"+"\t"+"ISBN"+"\t"+"���"+"\t"+"�۸�"+"\t"+"�Ƿ�ɽ�");
//		for(Map.Entry<Integer, book> entry: data.lib.entrySet()) {
//			System.out.println("�ݲر��:"+entry.getKey());
////          ����            ������               ������            ISBN             ���                   �۸�             �Ƿ��ϼ�
//			entry.getValue().show_introduce();
//		}
//	}
	//����鼮
	static void view_book() {
		System.out.println("���ȫ��ͼ��������1��س�");
		System.out.println("����������ͼ��������2��س�");
		System.out.println("������������ͼ��������3��س�");
		System.out.println("����ȡ�����β��������������س�����");
		Scanner sc=new Scanner(System.in);
		String op=sc.nextLine();
		//������֮����
		try {
			 switch(Integer.parseInt(op)) {
				//���ȫ��ͼ��
				case 1:{
					view_lib();
					record(system_frame.getLog_er(), get_Time(), "���ȫ��ͼ��");
				}
				break;
				//��������
				case 2:{
					view_CS();
					record(system_frame.getLog_er(), get_Time(), "����������ͼ��");
				}
				break;
				//����������
				case 3:{
					view_Liberal_arts();
					record(system_frame.getLog_er(), get_Time(), "������������ͼ��");
				}
				break;
				//ȡ������
				default:{
					break;
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	//�鿴��������
	static void view_reader_analyze() {
		System.out.println("������Ϣչʾ��");
		//չʾ����������û��� �����Ĵ�������ͼ��
		show_MAX_borrowing_number();
	    Scanner sc=new Scanner(System.in);
	    int op;
		System.out.println("Ŀǰ���Բ�ѯ�û��������а�������ͼ�����а�");
		System.out.println("1���û��������а�");
		System.out.println("2������ͼ�����а�");
		System.out.println("----�����+�س� �˳�---");
		op=sc.nextInt();
		if(op==1) {
//          �û���     ����       �Ա�      ����     ������
			System.out.println("�û���            ����       �Ա�      ����     ������");
			for(user e: history.borrowing_ranking_list_OfUser ) {
				System.out.println(e.show_ranking());
			}
			record(system_frame.getLog_er(), get_Time(), "�鿴���û��������а�");
		}
		if(op==2) {
			System.out.println("�ݲر��      ����        ����      ������           �ݲؿ��      ��������");
			for(book e:history.borrowed_ranking_list_OfBook) {
				System.out.println(e.show_ranking());
			}
			record(system_frame.getLog_er(), get_Time(), "�鿴������ͼ�����а�");
		}
	}
	//�����µ��û�
	static void register_new_user(){//�����û������ܻ�δʵ�֣�����������������������������������������������������������������������������
		my_GUI.register_new_user_GUI();
		Scanner sc=new Scanner(System.in);
		user temp;
		while(true) {
			int op=sc.nextInt();
			//��ʦ
			if(op==1) {
				temp=new teacher();
				break;
			}
			//��ʿ
			if(op==2) {
				temp=new doctor();
				break;
			}
			//˶ʿ
			if(op==3) {
				temp=new master();
				break;
			}
			//������
			if(op==4) {
				temp=new bachelor();
				break;
			}
			//ȡ������
			if(op==9) {
				return ;
			}
			my_GUI.warn_new_user();
		}
    	boolean isregister=true;
    	//��������Ĺؼ���
    	Integer again_Enter=777;
    	//ȡ�������Ĺؼ���
    	Integer exit=77;
		Scanner sc2=new Scanner(System.in);
    	for(int i=0;i<5;i++) {
			if(i==0){
				System.out.println("������ע���û�������");
				String name=sc2.nextLine();
				temp.setName(name);
				if(name.equals(exit.toString())) {
					isregister=false;
					System.out.println("���β����ѳɹ�ȡ��");
					break;
				}
			}
			if(i==1) {
				System.out.println("������ע���û��Ա�");
				String sex=sc2.nextLine();
				temp.setSex(sex);
				if(sex.equals(again_Enter.toString())) {
					i-=2;
				}
				if(sex.equals(exit.toString())) {
					isregister=false;
					System.out.println("���β����ѳɹ�ȡ��");
					break;
				}
			}
			if(i==2) {
				System.out.println("������ע���û��û���(������ѧ�Ż򹤺ų䵱)��");
				while(true) {
					String user=sc2.nextLine();
					if(is_vaild(user)) {
						temp.setUser(user);
					}
					else {
						System.out.println("������ĸ�ʽ�Ƿ�������������(����ȡ��ע��ѧ������"+exit.toString()+"����)");
					}
					if(user.equals(again_Enter.toString())) {
						i-=2;
						break;
					}
					if(user.equals(exit.toString())) {
						isregister=false;
						System.out.println("���β����ѳɹ�ȡ��");
						break;
					}
				}
			}
			if(i==3&&isregister) {
				System.out.println("������ע���û����ֻ���");
				String phone_number=sc2.nextLine();
				temp.setPhone_muber(phone_number);
				if(phone_number.equals(again_Enter.toString())) {
					i-=2;
				}
				if(phone_number.equals(exit.toString())) {
					isregister=false;
					System.out.println("���β����ѳɹ�ȡ��");
					break;
				}
			}
			if(i==4&&isregister) {
				System.out.println("������ע���û�������");
				int age=sc2.nextInt();
				temp.setAge(age);
				if(age==again_Enter) {
					i-=2;
				}
				if(age==exit) {
					isregister=false;
					System.out.println("���β����ѳɹ�ȡ��");
					break;
				}
			}
    	}
    	if(isregister) {
			data.user_resited.add(temp);
			data.all_user.add(temp);
			System.out.println("��ϲ��"+temp.getUser()+"\t"+temp.getName()+"�û��Ѿ�ע��ɹ�");
			temp.Initialize_password();//����
			record(system_frame.getLog_er(), get_Time(), "������һ��"+temp.show_degree()+"�û�");
		}
	}
	
//	 * ����˻��ĺϷ���
//	 * ����˵����
//	 * 1.���벻�ܺ��пո��ַ��� 
//	 * 2.����ֻ�ܰ�����ĸ������

	private static boolean is_vaild(String password) {
		// TODO �Զ����ɵķ������
		if (password.length() > 0) {
			//�ж��Ƿ��пո��ַ���
			for (int t = 0; t < password.length(); t++) {
				String b = password.substring(t, t + 1);
				if (b.equals(" ")) {
					System.out.println("�п��ַ���");
					return false;
				}
			}
			
			
			//�ж��Ƿ��к���
		     int count = 0;    
	         String regEx = "[\\u4e00-\\u9fa5]";    
	         Pattern p = Pattern.compile(regEx);    
	         Matcher m = p.matcher(password);    
	        while (m.find()) {    
	            for (int i = 0; i <= m.groupCount(); i++) {    
	                 count = count + 1;    
	             }    
	         }
	       
	         if(count>0){
	        	 System.out.println("�к���");
	        	 return false;
	         }
	         
 
	         //�ж��Ƿ�����ĸ������
			int numberCounter = 0;
			for (int i = 0; i < password.length(); i++) {
				char c = password.charAt(i);
				if (!Character.isLetterOrDigit(c)) {
					return false;
				}
				if (Character.isDigit(c)) {
					numberCounter++;
				}
			}
 
		} else {
			return false;
		}
		return true;
	}

	
	//ע���û�
	static void  logout_user() {
		System.out.println("��������Ҫɾ���û����û���");
		Scanner sc=new Scanner(System.in);
		String logout_user=sc.next();
		boolean isLogout=false;
		Iterator<user> it=data.user_resited.iterator();
		user temp_u;
		while(it.hasNext()){
			temp_u=it.next();
	        if(logout_user.equals(temp_u.user)) {
	        	 if(temp_u.getBorroweBooks().size()>0) {
	        		 System.err.println("���û�����Ϊδ�黹ͼ�飬�����Ƿ���Ҫϵͳ���䷢�ͻ���֪ͨ");
	        		 System.out.println("1����Ҫ");
	        		 System.out.println("2������Ҫ");
	        		 System.out.println("����������ѡ��");
	        		 Scanner sc1=new Scanner(System.in);
	        		 int op=sc1.nextInt();
	        		 if(op==1) {
	        			message.send_message(system_frame.getLog_er(), temp_u,"�뼰ʱ�黹δ��ͼ��", get_Time());
	        		 }
	        		 return;
	        	 }
	        	 else {
	        	   System.out.println("�û���Ϊ��"+temp_u.getUser()+"���˻��ѳɹ���ע��");
	        	  isLogout=true;
	        	  record(system_frame.getLog_er(), get_Time(), "ע�����û�����"+temp_u.getUser()+"���û�");
	        	  data.user_resited.remove(temp_u);
	        	  //���½��İ�
	        	  history.borrowing_ranking_list_OfUser.remove(temp_u);
	        	  }
	         }
		}
		if(!isLogout) {
			System.err.println("��������û���"+logout_user+"�����ڣ�������ٽ��дβ���");
		}
	}
	//�����û���Ϣ
	static void alter_user_datail() {
		System.out.println("���������޸��û����û�����");
		Scanner sc3=new Scanner(System.in);
		String user_name=sc3.nextLine();
		user temp=null;
		if(data.user_resiteMap.containsKey(user_name)) {
			temp=data.user_resiteMap.get(user_name);
			System.out.println("�������¿��޸�ѡ����ѡ��ɣ�����ȡ������������������ӻس�����");
			System.out.println("		1���޸��ֻ�����");
	    	System.out.println("		2���޸�����");
	    	System.out.println("		3���޸�����");
	    	System.out.println("-----------one--------------divider---------------");
	    	Scanner sc2=new Scanner(System.in);
	    	int op=sc3.nextInt();
	    	switch(op) {
		    	case 1:{//�޸��ֻ���
		    		System.out.println("�������������ֻ���");
		    		String modify_phone_number=sc2.nextLine();
		    		temp.setPhone_muber(modify_phone_number);
		    		System.out.println("��ϲ�����ĳɹ��������Ǹ��ĺ�ĸ�����Ϣ");
		    		temp.show_introduce();
		    		record(system_frame.getLog_er(), get_Time(), "������"+temp.name+"���ֻ���");
		    	}
		    	break;
		    	case 2:{//�޸�����
		    		System.out.println("����������������");
		    		String modify_password=sc2.nextLine();
		    		temp.setPassWrod(modify_password);
		    		System.out.println("��ϲ�����ĳɹ��������Ǹ��ĺ�ĸ�����Ϣ");
		    		temp.show_introduce();
		    		record(temp, null, modify_password);
		    		record(system_frame.getLog_er(), get_Time(), "������"+temp.name+"������");
		    	}
		    	break;
		    	case 3:{//�޸�����
		    		System.out.println("������������ȷ����");
		    		int modify_age=sc3.nextInt();
		    		temp.setAge(modify_age);
		    		System.out.println("��ϲ�����ĳɹ��������Ǹ��ĺ�ĸ�����Ϣ");
		    		temp.show_introduce();
		    		record(system_frame.getLog_er(), get_Time(), "������"+temp.name+"������");
		    	}
		    	default:{
		    		System.out.println("���ѳɹ�ȡ���˴β���");
		    		break;
		    	}
		    	
	    	}
		}
		else{
			System.err.println("������û���������");
		}
		
	}
	//����ͼ����
	static void alter_book_datail() {//����������������������δ���
		System.out.println("��������Ҫ�޸�ͼ��Ĺݲر�ţ�");
		System.out.println("��������ǵô��޸�ͼ��Ĺݲر���밴��ʾ����ð���");
		Scanner sc =new Scanner(System.in);
		view_book();
		int book_index;
		System.out.println("�������������޸�ͼ��Ĺݲر�ţ�");
		book_index=sc.nextInt();
		System.out.println(data.lib.get(book_index).getInventoryOfBook());
		System.out.println("���Ǵ��޸�ͼ���ԭ���");
		System.out.println("��������ֿ��(���뷶ΧΪ0~100)");
		int new_inventory=sc.nextInt();
		if(new_inventory<1||new_inventory>100) {
			System.err.println("���뷶Χ����,�˴β���ʧ��");
			//��¼����ʧ��
			record(system_frame.getLog_er(), get_Time(), "���ÿ��ʧ��");
		}
		data.lib.get(book_index).setInventoryOfBook(new_inventory);
		//�����ɹ�����
		System.out.println("��ϲ�����ѽ�"+data.lib.get(book_index).getTitleOfBook()+"�Ŀ������Ϊ��"+data.lib.get(book_index).getInventoryOfBook());
		//��¼�����ɹ�
		record(system_frame.getLog_er(), get_Time(), "��"+data.lib.get(book_index).show_degree()+data.lib.get(book_index).getTitleOfBook());
	}
	//�鿴��־
	 static void view_log() {
		 System.out.println("�û���"+"\t\t"+"������"+"\t"+"���"+"\t"+"���еĲ���"+"\t"+"����ʱ��");
		 //��������չʾ��Ϣ
		 for(history e: history.log_sheet) {
			 System.out.println(e.show_introduce());
		 }
	 }
	 //��¼�����ķ���
	 /*
	  * ���������ɼ��ɵ�record��֮�У���Ϊ�˽ṹ��������δ����
	  */
	 static void record(person t,Date e,String op) {
		 //������ʷ��¼
		  history temp = new history(t,e,op);
		  //��������־��
		  history.log_sheet.add(temp);
	 }
	 //��ȡ��ǰʱ��
	 static Date get_Time() {
		 Date time=new Date();
		 return time;
	 }
	//���ȫ��ͼ��
	private static void view_lib() {
		//����������ͼ��
		view_CS();
		//������������ͼ��
		view_Liberal_arts();
	}
	//����������ͼ��
	private static void view_CS() {
		System.out.println("�������");
		System.out.println("�ݲر��"+"\t"+"����"+"\t\t\t"+"����"+"\t\t"+"������"+"\t\t\t"+"ISBN"+"\t\t\t"+"���"+"\t"+"�۸�"+"\t"+"�Ƿ�ɽ�");
		//��������������鼯����չʾͼ����Ϣ
		for(book e: data.libOfBook_CS) {
			System.out.println(e.show_introduce());
		}
	}
	//������������ͼ��
	private static void view_Liberal_arts() {
		System.out.println("���������");
		System.out.println("�ݲر��"+"\t"+"����"+"\t\t"+"����"+"\t\t"+"������"+"\t\t\t"+"ISBN"+"\t\t\t"+"���"+"\t"+"�۸�"+"\t"+"�Ƿ�ɽ�");
		//�������鼯��������ͼ��
		for(book e: data.libOfbook_Liberal_arts) {
			System.out.println(e.show_introduce());
		}
	}
	//��ѯ������������û�
	private static void show_MAX_borrowing_number() {
		//�����ܷ��н�������
		if(history.borrowed_ranking_list_OfBook.isEmpty()) {
			System.err.println("!!!!!��û�����ݲ���������");
			System.err.println("��δ���û���ͼ��ݽ��в���");
		}
		else {
		//չʾ�����Ĵ�������ͼ��
		System.err.println("�����Ĵ�������ͼ��:");
		System.out.println("�ݲر��      ����        ����      ������           �ݲؿ��      ��������");
		System.out.println(history.get_Max_borrow_book().show_introduce());
		//չʾ���Ĵ��������û�
		System.out.println("���Ĵ��������û�:");
		System.out.println("�û���            ����       �Ա�      ����     ������");
		System.out.println(history.get_Max_borrow_readr().show_introduce());
		}
	}
	   static void view_time() {
		   Date time=new Date();
		   SimpleDateFormat formatter =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		   System.out.println("��ǰʱ����");
		   System.out.println(formatter.format(time));
	   }
	//����������������������������������������������������������������������������������������Ա�˲���������������������������������������������������������������������������������������//
	
	
	
	
	
	//�������������������������������������������������������������������������������������û��˲�������������������������������������������������������������������������������������������//
	
}

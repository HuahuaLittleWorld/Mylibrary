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
	//简单模糊搜索
	//书名模糊搜索
   static protected void fuzzy_search_book(){
	   Scanner sc=new Scanner(System.in);
	  String key_word=sc.next();
	  //是否查询成功
	   boolean query=false; 
	   //获取书库哈希表的key值以遍历书库来检索图书
	   for(Integer key:data.lib.keySet()) {
		   //简单的使用了字符串的indexOf方法来进行模搜索
		   if(data.lib.get(key).getTitleOfBook().indexOf(key_word)!=-1||data.lib.get(key).getAuthorOfBook().indexOf(key_word)!=-1) {
				//输出检索到图书的基本信息
			   	System.out.println( data.lib.get(key).show_introduce());
				query=true;
				//记录操作
				record(system_frame.getLog_er(), get_Time(), "使用模糊搜索检索到了馆藏编号："+data.lib.get(key).show_degree()+"书名："+data.lib.get(key).getTitleOfBook());
			}
		}
	   //若没有搜索到一条信息则会输出相关提示信息
	   if(!query) {
		   System.out.println("抱歉为检索到相关书籍");
		   record(system_frame.getLog_er(), get_Time(), "使用关键词"+key_word+"进行模糊查询并未查询失败：没用检索到相关书籍");
	   }
   }
   //_______________________________________________________________________
   //登录通知
   static void log_inform() {
	   system_frame.getLog_er().show_mail();
	   System.out.println("您可以输入相应指示以进行下一步操作");
	   System.out.println("1、现在处理邮件");
	   System.out.println("2、稍后处理邮件");
	   Scanner sc=new Scanner(System.in);
	   int op=sc.nextInt();
	   if(op==1) {
		   deal_myMail();
	   }
   }
   private static void deal_myMail() {
	// TODO 自动生成的方法存根
	 System.out.println("输入“\\”代表已读");
	 System.out.println("输入“/”代表稍后继续处理");
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
		 System.out.println("消息已全部清空，暂无新的消息");
	 }
   }
//书籍信息展示 
   static public void show_book(book tempBook) {
	   System.out.println("书名：      作者：    出版社：         ISBN：           单价：        库存：   ");
	   System.out.println(tempBook.show_introduce());
	   //System.out.println(tempBook.getTitleOfBook()+"\t"+tempBook.getAuthorOfBook()+"\t"+tempBook.getPressOfBook()+"\t"+tempBook.getIsbnOfBook()+"\t"+tempBook.getPriceOfBook()+"\t"+tempBook.getInventoryOfBook());
   }
   static public void show_user(user tempUser) {
	   System.out.println("姓名：      性别：    年龄：    已借图书数量：      ");
	   
   }
   //登录操作 采用包访问权限修饰 只能被子类使用
   static  boolean logn() {
	   Scanner sc=new Scanner(System.in);
	   boolean exit=false;
	   while(!exit) {
		   System.out.println("请输入您的账户名");
		   String User=sc.nextLine();
		   //防止中英文输入法导致无法正常操作
		   if(User.equals("~")||User.equals("`")) {
			   System.out.println("系统已退出");
			   break;
		   }
		   //遍历用户列表
		   //多态运用
		   for(person e: data.all_user) {
			   if(e.getUser().equals(User)) {
				   while(true) {
					   System.out.println("请输入您的密码");
					   String passwrod=sc.nextLine();
					   //防止中英文输入法导致无法正常操作
					   if(passwrod.equals("$")||passwrod.equals("￥")) {
						   break;
					   }
					   if(passwrod.equals(e.getPassWrod())) {
						   System.out.println(e.getName()+e.show_degree());
						   //设置登录者
						   system_frame.setLog_er(e);
						   //记录操作成功
						   record(e, get_Time(), "登录图书馆系统成功");
						   //操作成功提醒
						   System.out.println(e.getName()+"恭喜你成功进入图书馆系统");
						   //展示邮件信息
						   log_inform();
						   return true;
					   }
					   System.err.println("密码错误！！！请重新输入，若用户名错误，输入$以重新输入用户名");
				   }
			   }
		   }
		   System.out.println("您输入的账户名不存在，请重新输入，若想退出系统请输入~");
	   }
	   return false;
   }
   //————————————————————————————————————————用户端操作——————————————————————————————————————————————
   //借阅图书
   static void borrowing_book() {
	   System.out.println("请输入想要借阅图书的馆藏编号");
	   System.out.println("如果您需要图书检索，请输入相应指令");
	   System.out.println("1、精准搜索");
	   System.out.println("2、模糊搜索");
	   System.out.println("3、浏览计算机类图书");
	   System.out.println("4、浏览人文社团类图书");
	   System.out.println("不需要检索帮助可以任意键+回车跳过");
	   Scanner sc=new Scanner(System.in);
	   String op=sc.next();
	   //为了实现任意键+回车跳过不得已的操作，，希望你们可以想一个更好的方法
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
	   
	   System.out.println("请输入你要借阅的图书的馆藏编号");
	   Integer op_book=sc.nextInt();
	   if(data.lib.containsKey(op_book)) {
		   if(data.lib.get(op_book).getInventoryOfBook()>0) {
			   data.lib.get(op_book).setInventoryOfBook(data.lib.get(op_book).getInventoryOfBook()-1);
			   //给自己书库中添加该书
			   Type_conversion().getBorroweBooks().add(data.lib.get(op_book));
			   //操作成功提醒
			   System.out.println("恭喜您已成功借阅"+data.lib.get(op_book).getTitleOfBook());
			   //书榜和借阅榜更新
			   history.refresh_ranking_list(data.lib.get(op_book));
			   history.refresh_ranking_list(Type_conversion());
			   //记录操作成功
			   record(system_frame.getLog_er(), get_Time(), "借阅图书"+data.lib.get(op_book).getTitleOfBook()+"成功");
		   }
		   else if(data.lib.get(op_book).isLendOfbook()){
			   System.err.println("抱歉！您借阅的图书已被借完");
			   record(system_frame.getLog_er(), get_Time(), "借阅图书"+data.lib.get(op_book).getTitleOfBook()+"失败。失败原因：馆内该书已被借完");
		   }
		   else {
			   System.err.println("您输入的书籍已被下架");
			   record(system_frame.getLog_er(), get_Time(), "借阅图书"+data.lib.get(op_book).getTitleOfBook()+"失败。失败原因：馆内该书已被下架");
		   }
	   }
	   else {
		   System.out.println("您输入编号"+op_book+"有误，可能编号有误，请仔细检查");
		   record(system_frame.getLog_er(), get_Time(), "检索图书编码错误");
	   }
   }
   //精准搜索图书
   private static void search_book() {
	// TODO 自动生成的方法存根
	Scanner sc=new Scanner(System.in);
	String keyworld=sc.nextLine();
	boolean isSearched=false;
	for(Integer key: data.lib.keySet()) {
		if(data.lib.get(key).getAuthorOfBook().equals(keyworld)||data.lib.get(key).equals(keyworld)) {
			System.out.print(data.lib.get(key).show_degree());
			System.out.println(data.lib.get(key).show_introduce());
			isSearched=true;
			record(system_frame.getLog_er(), get_Time(), "使用关键词"+keyworld+"进行精准查询成功，查询到了书籍"+data.lib.get(key).show_degree()+"\t"+data.lib.get(key).getTitleOfBook());
		}
	}
	if(!isSearched) {
		System.out.println("抱歉未检索到相关书籍");
		record(system_frame.getLog_er(), get_Time(), "使用关键词"+keyworld+"进行精准查询失败：没有检索到相关书籍");
	}
   }
   //归还图书
   static void return_book() {
	   System.out.println("以下是您已借阅的图书：");
	   //这个需要改进，但我不太会，需要进行父转子
	   for(book e: Type_conversion().getBorroweBooks()) {
		   e.show_introduce();
	   }
	   System.out.println("请输入您想要归还的图书的馆藏编号：");
	   Scanner sc=new Scanner(System.in);
	   Integer book_index=sc.nextInt();
	   if(data.lib.containsKey(book_index)) {
		   if(Type_conversion().getBorroweBooks().contains(data.lib.get(book_index))){
			   Iterator<book> it=Type_conversion().getBorroweBooks().iterator();
			   while (it.hasNext()) {
				book book = (book) it.next();
				if(book.show_degree().equals(book_index.toString())) {
					Type_conversion().getBorroweBooks().remove(book);
					//操作成功提醒
					System.out.println("恭喜您已成功将"+book.getTitleOfBook()+"归还成功");
					//记录成功操作
					record(system_frame.getLog_er(), get_Time(), "成功将"+book.getTitleOfBook()+"归还成功");
				}
			   } 
		   }
		   else {
			   //操作失败提醒
			   System.out.println("您的已借图书中并没有"+data.lib.get(book_index).getTitleOfBook());
			   //记录操作失败
			   record(system_frame.getLog_er(), get_Time(),"还书失败，失败原因：在其已借图书未查找到"+data.lib.get(book_index).getTitleOfBook() );
		   }
	   }
	   else {
		   System.err.println("您输入的馆藏编号"+book_index+"有误");
		   System.err.println("请检查后再进行此操作");
	   }
   }
   //查看个人简介
	static void view_profile() {
		System.out.println(system_frame.getLog_er().show_introduce());
	}
   //父转子类型转换小工具
	private static user Type_conversion() {
	// TODO 自动生成的方法存根
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

//——————————————————————————————————————————管理员端操作——————————————————————————————————————————
   
   
   //上架书籍
	protected static void add_book() {
		// TODO 自动生成的方法存根
		System.out.println("请按顺序输入上架图书的正确信息：");
		System.out.println("****单行输入77可返回上层菜单****");
		System.out.println("****若数据输入错误，请换行输入777可重新输入");
		book temp=new book();
    	boolean isregister=true;
		Scanner sc2=new Scanner(System.in);
    	for(int i=0;i<5;i++) {
			if(i==0){
				System.out.println("请输入录入书籍书名：");
				String title=sc2.nextLine();
				temp.setTitleOfBook(title);
				if(title.equals("77")) {
					isregister=false;
					break;
				}
			}
			if(i==1) {
				System.out.println("请输入录入书籍作者姓名：");
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
				System.out.println("请输入录入书籍出版社名称：");
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
				System.out.println("请输入录入书籍ISBN编号：");
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
				System.out.println("请输入录入书籍库存");
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
    			System.out.println("请输入录入书籍的分区： \n1、计算机 \n2、人文社科\n（输入分区前编号即可）");
        		op=sc2.nextInt();
        		if(op==2||op==1)
        			break;
        		if(op==777) {
        			System.out.println("您已成功取消此次操作");
        			return;
        		}
        		System.err.println("输入有误，请按提示输入合适的选项，如想需求录入操作请输入777");
			}
    		if(op==1)
    			data.libOfBook_CS.add(temp);
    		else {
				data.libOfbook_Liberal_arts.add(temp);
			}
    		//将上架图书加入书库
    		data.lib.put(temp.hashCode()%100000, temp);
    		//操作完成提醒语句
			System.out.println("恭喜您"+temp.getTitleOfBook()+"已经成功上架馆藏编号为："+temp.hashCode()%1000);
			//记录操作
			record(system_frame.getLog_er(), get_Time(), "成功上架图书"+temp.getTitleOfBook());
		}
	}
	//下架书籍
	static void sub_book() {
		Scanner sc=new Scanner(System.in);
		System.out.println("您是否需要浏览全部图书以获得需要下架入库图书的馆藏编号。（需要请输入1，不需要回车即可）");
		String op=sc.nextLine();
		if(op.equals("1")) {
			view_lib();
		}
		System.out.println("请输入想要删除书的馆藏编号：");
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
			//操作成功提醒
			System.out.println(data.lib.get(index).show_degree()+data.lib.get(index).getTitleOfBook()+"已被下架");
			//记录成功操作
			record(system_frame.getLog_er(), get_Time(), "成功下架图书"+data.lib.get(index).getTitleOfBook());
			data.lib.remove(index);
		}
		else {
			//操作失败提醒
			System.err.println("下架失败！"+"\n"+"您输入的馆藏编号："+index+"  在书库中并未查询到，请您检验后再进行次操作");
			//记录失败操作
			record(null, get_Time(), op);
		}
	}
//	private static void book_all_show() {
//		// TODO 自动生成的方法存根
//		System.out.println("书名"+"\t"+"作者"+"\t"+"出版社"+"\t"+"ISBN"+"\t"+"库存"+"\t"+"价格"+"\t"+"是否可借");
//		for(Map.Entry<Integer, book> entry: data.lib.entrySet()) {
//			System.out.println("馆藏编号:"+entry.getKey());
////          书名            作者名               出版社            ISBN             库存                   价格             是否上架
//			entry.getValue().show_introduce();
//		}
//	}
	//浏览书籍
	static void view_book() {
		System.out.println("浏览全部图书请输入1后回车");
		System.out.println("浏览计算机类图书请输入2后回车");
		System.out.println("浏览人文社科类图书请输入3后回车");
		System.out.println("若想取消本次操作，按任意键后回车即可");
		Scanner sc=new Scanner(System.in);
		String op=sc.nextLine();
		//不得已之操作
		try {
			 switch(Integer.parseInt(op)) {
				//浏览全部图书
				case 1:{
					view_lib();
					record(system_frame.getLog_er(), get_Time(), "浏览全部图书");
				}
				break;
				//浏览计算机
				case 2:{
					view_CS();
					record(system_frame.getLog_er(), get_Time(), "浏览计算机类图书");
				}
				break;
				//浏览人文社科
				case 3:{
					view_Liberal_arts();
					record(system_frame.getLog_er(), get_Time(), "浏览人文社科类图书");
				}
				break;
				//取消操作
				default:{
					break;
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	//查看读者数据
	static void view_reader_analyze() {
		System.out.println("基础信息展示：");
		//展示借阅数最大用户和 被借阅次数最多的图书
		show_MAX_borrowing_number();
	    Scanner sc=new Scanner(System.in);
	    int op;
		System.out.println("目前可以查询用户借书排行榜与热门图书排行榜");
		System.out.println("1、用户借书排行榜");
		System.out.println("2、热门图书排行榜");
		System.out.println("----任意键+回车 退出---");
		op=sc.nextInt();
		if(op==1) {
//          用户名     姓名       性别      年龄     借阅量
			System.out.println("用户名            姓名       性别      年龄     借阅量");
			for(user e: history.borrowing_ranking_list_OfUser ) {
				System.out.println(e.show_ranking());
			}
			record(system_frame.getLog_er(), get_Time(), "查看了用户借书排行榜");
		}
		if(op==2) {
			System.out.println("馆藏编号      书名        作者      出版社           馆藏库存      最大借阅量");
			for(book e:history.borrowed_ranking_list_OfBook) {
				System.out.println(e.show_ranking());
			}
			record(system_frame.getLog_er(), get_Time(), "查看了热门图书排行榜");
		}
	}
	//创建新的用户
	static void register_new_user(){//检验用户名功能还未实现！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！
		my_GUI.register_new_user_GUI();
		Scanner sc=new Scanner(System.in);
		user temp;
		while(true) {
			int op=sc.nextInt();
			//教师
			if(op==1) {
				temp=new teacher();
				break;
			}
			//博士
			if(op==2) {
				temp=new doctor();
				break;
			}
			//硕士
			if(op==3) {
				temp=new master();
				break;
			}
			//本科生
			if(op==4) {
				temp=new bachelor();
				break;
			}
			//取消操作
			if(op==9) {
				return ;
			}
			my_GUI.warn_new_user();
		}
    	boolean isregister=true;
    	//重新输入的关键字
    	Integer again_Enter=777;
    	//取消操作的关键字
    	Integer exit=77;
		Scanner sc2=new Scanner(System.in);
    	for(int i=0;i<5;i++) {
			if(i==0){
				System.out.println("请输入注册用户姓名：");
				String name=sc2.nextLine();
				temp.setName(name);
				if(name.equals(exit.toString())) {
					isregister=false;
					System.out.println("本次操作已成功取消");
					break;
				}
			}
			if(i==1) {
				System.out.println("请输入注册用户性别：");
				String sex=sc2.nextLine();
				temp.setSex(sex);
				if(sex.equals(again_Enter.toString())) {
					i-=2;
				}
				if(sex.equals(exit.toString())) {
					isregister=false;
					System.out.println("本次操作已成功取消");
					break;
				}
			}
			if(i==2) {
				System.out.println("请输入注册用户用户名(建议用学号或工号充当)：");
				while(true) {
					String user=sc2.nextLine();
					if(is_vaild(user)) {
						temp.setUser(user);
					}
					else {
						System.out.println("您输入的格式非法，请重新输入(若想取消注册学生输入"+exit.toString()+"即可)");
					}
					if(user.equals(again_Enter.toString())) {
						i-=2;
						break;
					}
					if(user.equals(exit.toString())) {
						isregister=false;
						System.out.println("本次操作已成功取消");
						break;
					}
				}
			}
			if(i==3&&isregister) {
				System.out.println("请输入注册用户的手机号");
				String phone_number=sc2.nextLine();
				temp.setPhone_muber(phone_number);
				if(phone_number.equals(again_Enter.toString())) {
					i-=2;
				}
				if(phone_number.equals(exit.toString())) {
					isregister=false;
					System.out.println("本次操作已成功取消");
					break;
				}
			}
			if(i==4&&isregister) {
				System.out.println("请输入注册用户的年龄");
				int age=sc2.nextInt();
				temp.setAge(age);
				if(age==again_Enter) {
					i-=2;
				}
				if(age==exit) {
					isregister=false;
					System.out.println("本次操作已成功取消");
					break;
				}
			}
    	}
    	if(isregister) {
			data.user_resited.add(temp);
			data.all_user.add(temp);
			System.out.println("恭喜您"+temp.getUser()+"\t"+temp.getName()+"用户已经注册成功");
			temp.Initialize_password();//密码
			record(system_frame.getLog_er(), get_Time(), "创建了一个"+temp.show_degree()+"用户");
		}
	}
	
//	 * 检测账户的合法性
//	 * 规则说明：
//	 * 1.密码不能含有空格字符串 
//	 * 2.密码只能包括字母和数字

	private static boolean is_vaild(String password) {
		// TODO 自动生成的方法存根
		if (password.length() > 0) {
			//判断是否有空格字符串
			for (int t = 0; t < password.length(); t++) {
				String b = password.substring(t, t + 1);
				if (b.equals(" ")) {
					System.out.println("有空字符串");
					return false;
				}
			}
			
			
			//判断是否有汉字
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
	        	 System.out.println("有汉字");
	        	 return false;
	         }
	         
 
	         //判断是否是字母和数字
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

	
	//注销用户
	static void  logout_user() {
		System.out.println("请输入想要删除用户的用户名");
		Scanner sc=new Scanner(System.in);
		String logout_user=sc.next();
		boolean isLogout=false;
		Iterator<user> it=data.user_resited.iterator();
		user temp_u;
		while(it.hasNext()){
			temp_u=it.next();
	        if(logout_user.equals(temp_u.user)) {
	        	 if(temp_u.getBorroweBooks().size()>0) {
	        		 System.err.println("该用户存在为未归还图书，请问是否需要系统向其发送还书通知");
	        		 System.out.println("1、需要");
	        		 System.out.println("2、不需要");
	        		 System.out.println("请输入您的选择");
	        		 Scanner sc1=new Scanner(System.in);
	        		 int op=sc1.nextInt();
	        		 if(op==1) {
	        			message.send_message(system_frame.getLog_er(), temp_u,"请及时归还未还图书", get_Time());
	        		 }
	        		 return;
	        	 }
	        	 else {
	        	   System.out.println("用户名为："+temp_u.getUser()+"的账户已成功被注销");
	        	  isLogout=true;
	        	  record(system_frame.getLog_er(), get_Time(), "注销了用户名："+temp_u.getUser()+"的用户");
	        	  data.user_resited.remove(temp_u);
	        	  //更新借阅榜单
	        	  history.borrowing_ranking_list_OfUser.remove(temp_u);
	        	  }
	         }
		}
		if(!isLogout) {
			System.err.println("您输入的用户名"+logout_user+"不存在，请检查后再进行次操作");
		}
	}
	//更改用户信息
	static void alter_user_datail() {
		System.out.println("输入你想修改用户的用户名：");
		Scanner sc3=new Scanner(System.in);
		String user_name=sc3.nextLine();
		user temp=null;
		if(data.user_resiteMap.containsKey(user_name)) {
			temp=data.user_resiteMap.get(user_name);
			System.out.println("共有以下可修改选项（输出选项即可，若想取消操作，输入任意键加回车即可");
			System.out.println("		1、修改手机号码");
	    	System.out.println("		2、修改密码");
	    	System.out.println("		3、修改年龄");
	    	System.out.println("-----------one--------------divider---------------");
	    	Scanner sc2=new Scanner(System.in);
	    	int op=sc3.nextInt();
	    	switch(op) {
		    	case 1:{//修改手机号
		    		System.out.println("请输入您的新手机号");
		    		String modify_phone_number=sc2.nextLine();
		    		temp.setPhone_muber(modify_phone_number);
		    		System.out.println("恭喜您更改成功，以下是更改后的个人信息");
		    		temp.show_introduce();
		    		record(system_frame.getLog_er(), get_Time(), "更改了"+temp.name+"的手机号");
		    	}
		    	break;
		    	case 2:{//修改密码
		    		System.out.println("请输入您的新密码");
		    		String modify_password=sc2.nextLine();
		    		temp.setPassWrod(modify_password);
		    		System.out.println("恭喜您更改成功，以下是更改后的个人信息");
		    		temp.show_introduce();
		    		record(temp, null, modify_password);
		    		record(system_frame.getLog_er(), get_Time(), "更改了"+temp.name+"的密码");
		    	}
		    	break;
		    	case 3:{//修改年龄
		    		System.out.println("请输入您的正确年龄");
		    		int modify_age=sc3.nextInt();
		    		temp.setAge(modify_age);
		    		System.out.println("恭喜您更改成功，以下是更改后的个人信息");
		    		temp.show_introduce();
		    		record(system_frame.getLog_er(), get_Time(), "更改了"+temp.name+"的年龄");
		    	}
		    	default:{
		    		System.out.println("您已成功取消此次操作");
		    		break;
		    	}
		    	
	    	}
		}
		else{
			System.err.println("输入的用户名不存在");
		}
		
	}
	//更改图书库存
	static void alter_book_datail() {//！！！！！！！！！！还未完成
		System.out.println("请输入想要修改图书的馆藏编号：");
		System.out.println("如果您不记得待修改图书的馆藏编号请按提示来获得帮助");
		Scanner sc =new Scanner(System.in);
		view_book();
		int book_index;
		System.out.println("请您输入您想修改图书的馆藏编号：");
		book_index=sc.nextInt();
		System.out.println(data.lib.get(book_index).getInventoryOfBook());
		System.out.println("这是待修该图书的原库存");
		System.out.println("请输入的现库存(输入范围为0~100)");
		int new_inventory=sc.nextInt();
		if(new_inventory<1||new_inventory>100) {
			System.err.println("输入范围有误,此次操作失败");
			//记录操作失败
			record(system_frame.getLog_er(), get_Time(), "设置库存失败");
		}
		data.lib.get(book_index).setInventoryOfBook(new_inventory);
		//操作成功提醒
		System.out.println("恭喜您，已将"+data.lib.get(book_index).getTitleOfBook()+"的库存设置为："+data.lib.get(book_index).getInventoryOfBook());
		//记录操作成功
		record(system_frame.getLog_er(), get_Time(), "将"+data.lib.get(book_index).show_degree()+data.lib.get(book_index).getTitleOfBook());
	}
	//查看日志
	 static void view_log() {
		 System.out.println("用户名"+"\t\t"+"姓名："+"\t"+"身份"+"\t"+"进行的操作"+"\t"+"操作时间");
		 //遍历集合展示信息
		 for(history e: history.log_sheet) {
			 System.out.println(e.show_introduce());
		 }
	 }
	 //记录操作的方法
	 /*
	  * 本操作本可集成到record类之中，但为了结构清晰，并未集成
	  */
	 static void record(person t,Date e,String op) {
		 //创建历史记录
		  history temp = new history(t,e,op);
		  //并加入日志单
		  history.log_sheet.add(temp);
	 }
	 //获取当前时间
	 static Date get_Time() {
		 Date time=new Date();
		 return time;
	 }
	//浏览全部图书
	private static void view_lib() {
		//浏览计算机类图书
		view_CS();
		//浏览人文社科类图书
		view_Liberal_arts();
	}
	//浏览计算机类图书
	private static void view_CS() {
		System.out.println("计算机类");
		System.out.println("馆藏编号"+"\t"+"书名"+"\t\t\t"+"作者"+"\t\t"+"出版社"+"\t\t\t"+"ISBN"+"\t\t\t"+"库存"+"\t"+"价格"+"\t"+"是否可借");
		//遍历计算机类数组集合以展示图书信息
		for(book e: data.libOfBook_CS) {
			System.out.println(e.show_introduce());
		}
	}
	//浏览人文社科类图书
	private static void view_Liberal_arts() {
		System.out.println("人文社科类");
		System.out.println("馆藏编号"+"\t"+"书名"+"\t\t"+"作者"+"\t\t"+"出版社"+"\t\t\t"+"ISBN"+"\t\t\t"+"库存"+"\t"+"价格"+"\t"+"是否可借");
		//遍历数组集合艺术类图书
		for(book e: data.libOfbook_Liberal_arts) {
			System.out.println(e.show_introduce());
		}
	}
	//查询借书次数最大的用户
	private static void show_MAX_borrowing_number() {
		//检验受否有借书数据
		if(history.borrowed_ranking_list_OfBook.isEmpty()) {
			System.err.println("!!!!!还没有数据产生！！！");
			System.err.println("还未有用户在图书馆进行操作");
		}
		else {
		//展示被借阅次数最多的图书
		System.err.println("被借阅次数最多的图书:");
		System.out.println("馆藏编号      书名        作者      出版社           馆藏库存      最大借阅量");
		System.out.println(history.get_Max_borrow_book().show_introduce());
		//展示借阅次数最多的用户
		System.out.println("借阅次数最多的用户:");
		System.out.println("用户名            姓名       性别      年龄     借阅量");
		System.out.println(history.get_Max_borrow_readr().show_introduce());
		}
	}
	   static void view_time() {
		   Date time=new Date();
		   SimpleDateFormat formatter =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		   System.out.println("当前时间是");
		   System.out.println(formatter.format(time));
	   }
	//——————————————————————————————————————————管理员端操作——————————————————————————————————————————//
	
	
	
	
	
	//——————————————————————————————————————————用户端操作————————————————————————————————————————————//
	
}

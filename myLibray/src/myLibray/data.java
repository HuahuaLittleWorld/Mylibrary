package myLibray;

import java.util.ArrayList;
import java.util.HashMap;
public class data {
	//馆藏计算机图书列表
	static ArrayList<book> libOfBook_CS= new ArrayList<book>();
	//馆藏人文社科图书列表
	static ArrayList<book> libOfbook_Liberal_arts=new ArrayList<book>();
	//图书哈希表
	static HashMap<Integer, book> lib =new HashMap<Integer, book>();
	//图书初始数据
	static {
		//计算机类
		book temp= new book("java基础案例教程", "978_7-115-54747-1", "黑马程序员", 59.80, "人民邮电出版社", true,2);
		libOfBook_CS.add(temp);
		lib.put(temp.hashCode()%100000, temp);
		book tem= new book("java基础案例教程2", "978_7-115-54747-2", "黑马程序员", 59.80, "人民邮电出版社", true,2);
		libOfBook_CS.add(tem);
		lib.put(tem.hashCode()%100000, tem);
		book tep= new book("java基础案例教程3", "978_7-115-54747-3", "黑马程序员", 54.80, "人民邮电出版社", true,2);
		libOfBook_CS.add(tep);
		lib.put(tep.hashCode()%100000, tep);
		book tmp= new book("java基础案例教程4", "978_7-115-54747-4", "小甲鱼", 59.80, "人民邮电出版社", true,2);
		libOfBook_CS.add(tmp);
		lib.put(tmp.hashCode()%100000, tmp);
		book tp= new book("java基础案例教程", "978_7-115-54747-5", "李文生", 59.80, "电子科技大学出版社", true,2);
		libOfBook_CS.add(tp);
		lib.put(tp.hashCode()%100000, tp);
		book te= new book("Python基础案例教程", "978_7-115-54747-6", "黑马程序员", 59.80, "清华大学出版社", true,2);
		libOfBook_CS.add(te);
		lib.put(te.hashCode()%100000, te);
		book t1= new book("C基础案例教程", "978_7-115-54747-8", "黑马程序员", 59.80, "中山大学出版社", true,2);
		libOfBook_CS.add(t1);
		lib.put(t1.hashCode()%100000, t1);
		book t2= new book("C#基础案例教程", "978_7-115-54747-9", "杨丽红", 59.80, "河南大学出版社", true,2);
		libOfBook_CS.add(t2);
		lib.put(t2.hashCode()%100000, t2);
		book t3= new book("GO语言基础案例教程", "978_7-115-54747-10", "张庆", 59.80, "河南师范大学出版社", true,2);
		libOfBook_CS.add(t3);
		lib.put(t3.hashCode()%100000, t3);
		book t4= new book("Arduino基础案例教程", "978_7-115-54747-11", "杜兴", 59.80, "鹤壁高中出版社", true,2);
		libOfBook_CS.add(t4);
		lib.put(t4.hashCode()%100000, t4);
		book test= new book("test——book     ", "978_7-115-54747-11", "杜兴", 59.80, "鹤壁高中出版社", true,2);
		libOfBook_CS.add(test);
		lib.put(test.hashCode()%100000, test);
		//人文社科类
		book temp1=new book("瓦尔登湖","899-2-112-321-332","梭罗",59.90,"上海译林出版社",true,3);
		libOfbook_Liberal_arts.add(temp1);
		lib.put(temp1.hashCode()%100000, temp1);
		book temp2=new book("朝花夕拾","899-3-112-321-332","鲁迅",19.90,"人民文学出版社",true,3);
		libOfbook_Liberal_arts.add(temp2);
		lib.put(temp2.hashCode()%100000, temp2);
		book temp3=new book("阿Q正传","892-2-112-321-332","鲁迅",39.90,"人民教育出版社",true,3);
		libOfbook_Liberal_arts.add(temp3);
		lib.put(temp3.hashCode()%100000, temp3);
		book temp4=new book("茶馆","829-2-112-321-332","老舍",55.90,"新华文轩出版社",true,3);
		libOfbook_Liberal_arts.add(temp4);
		lib.put(temp4.hashCode()%100000, temp4);
		book temp5=new book("李尔王","899-4-112-321-332","莎士比亚",52.90,"上海译林出版社",true,3);
		libOfbook_Liberal_arts.add(temp5);
		lib.put(temp5.hashCode()%100000, temp5);
		book temp6=new book("红与黑","899-2-112-321-332","司汤达",59.90,"上海译林出版社",true,3);
		libOfbook_Liberal_arts.add(temp6);
		lib.put(temp6.hashCode()%100000, temp6);
		book temp7=new book("悲惨的世界","899-2-112-321-332","雨果",69.90,"上海译林出版社",true,3);
		libOfbook_Liberal_arts.add(temp7);
		lib.put(temp7.hashCode()%100000, temp7);
		book temp8=new book("古文观止","899-2-112-321-332","吴楚才",49.90,"凤凰文艺出版社",true,3);
		libOfbook_Liberal_arts.add(temp8);
		lib.put(temp8.hashCode()%100000, temp8);
		book temp9=new book("红楼梦","899-1-112-321-332","曹雪芹",56.90,"人民文艺出版社",true,3);
		libOfbook_Liberal_arts.add(temp9);
		lib.put(temp9.hashCode()%100000, temp9);
		book temp10=new book("基督山伯爵","892-2-112-321-332","大仲马",52.90,"上海译林出版社",true,3);
		libOfbook_Liberal_arts.add(temp10);
		lib.put(temp10.hashCode()%100000, temp10);
	}
	
	
	//初始学生列表及数据
	static ArrayList<user> user_resited=new ArrayList<user>();
	//哈希表
	static HashMap<String, user> user_resiteMap=new HashMap<String, user>();
	static{
     //数据注释                  姓名     性别 年龄  手机号         密码             账户名
	 user st0=new bachelor("李帅兵","男",20,"17639247585","huba20020402","202003024036");
	 user_resited.add(st0);
	 user_resiteMap.put(st0.getUser(), st0);
	 user st1=new bachelor("冯琳荣","男",20,"17639247585","flr2020","202003024037");
	 user_resited.add(st1);
	 user_resiteMap.put(st1.getUser(), st1);
	 user st2=new master("李鹏翔","男",20,"17639247585","773524","202003024038");
	 user_resited.add(st2);
	 user_resiteMap.put(st2.getUser(), st2);
	 user st3=new master("王一航","男",20,"17639247585","zsc20020402","202003024039");
	 user_resited.add(st3);
	 user_resiteMap.put(st3.getUser(), st3);
	 user st4=new doctor("郭昀慧","男",20,"17639247585","fl20020402","202003024040");
	 user_resited.add(st4);
	 user_resiteMap.put(st4.getUser(), st4);
	 user st5=new doctor("王子涵","女",20,"17639247585","888888","202003024041");
	 user_resited.add(st5);
	 user_resiteMap.put(st5.getUser(), st5);
	 user test1=new teacher("王涵","男",20,"17639247585","2","2");
	 user_resited.add(test1);
	 user_resiteMap.put(test1.getUser(), test1);
	 user test2=new bachelor("王韩羽","女",20,"17639247585","1","1");
	 user_resited.add(test2);
	 user_resiteMap.put(test2.getUser(), test2);
	 user test3=new master("test_master","男",20,"17639247585","3","3");
	 user_resited.add(test3);
	 user_resiteMap.put(test3.getUser(), test3);
	}
	
    //初始管理员列表及数据
	static ArrayList<administrator> adm_resited=new ArrayList<administrator>();
    static {
    	//姓名，性别，年龄，手机号码，登录密码，工号，
    	 administrator ad0=new administrator("李文生","男",40,"17639242341","111111","100001");
    	 adm_resited.add(ad0);
    	 administrator ad1=new administrator("杜兴","男",30,"17539242341","122222","100002");
    	 adm_resited.add(ad1);
    	 administrator ad2=new administrator("杨丽红","男",43,"17639432341","133333","100003");
    	 adm_resited.add(ad2);
    	 administrator ad3=new administrator("张庆","男",42,"17639762341","144444","100004");
    	 adm_resited.add(ad3);
    	 administrator ad4=new administrator("孙虹慧","女",31,"17632342341","155555","100005");
    	 adm_resited.add(ad4);
    	 administrator ad5=new administrator("高静","女",34,"17639627441","166666","100006");
    	 adm_resited.add(ad5);
    	 administrator ad6=new administrator("test_adm","女",34,"17639627441","21","21");
    	 adm_resited.add(ad6); 
    }
	//总数据库
    static ArrayList<person> all_user=new ArrayList<person>();
    static {
    	all_user.addAll(adm_resited);
    	all_user.addAll(user_resited);
    }
	
}

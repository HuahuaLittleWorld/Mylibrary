package myLibray;

import java.util.Scanner;

/*
 * system_frame 本类只为理清程序逻辑
 * 消除耦合，减小因需求变化引起代码僵化。
 * 使程序结构层次化所有结构良好的面向对象构架都具有清晰的层次定义
 */
public class system_frame extends libray_Interface {
	//运用多态记录登录者
	static private person log_er;
	//创建管理和用户的类用以对比
	static private person adm=new administrator(null, null, 0, null, null, null);
	static private person doctor=new doctor(null, null, 0, null, null, null);
	static private person master=new master(null, null, 0, null, null, null);
	static private person teacher= new teacher(null, null, 0, null, null, null);
	static private person bachelor=new bachelor(null, null, 0, null, null, null);  
	//登录
	boolean loging() {
		// TODO 自动生成的方法存根
        return super.logn();
	}
	//操作
	static void operation() {
		//用于记录选项
		Scanner sc=new Scanner(System.in);
		while(true) {
			int op;
			if(log_er instanceof administrator ){
					//管理员选择单界面
					my_GUI.adm_meau();
					System.out.println("进入管理员操作");
					op=sc.nextInt();
					switch(op) {
						//上架图书
						case 1:{
							add_book();
						}
						break;
						//下架图书
						case 2:{
							sub_book();
						}
						break;
						//查看图书数据
						case 3:{
							view_book();
						}
						break;
						//查看读者借阅数据统计与分析
						case 4:{
							view_reader_analyze();
						}
						break;
						//注册读者账户
						case 5:{
							register_new_user();
						}
						break;
						//注销读者账户
						case 6:{
							logout_user();
						}
						break;
						//修改读者信息
						case 7:{
							alter_user_datail();
						}
						break;
						//修改书籍库存
						case 8:{
							alter_book_datail();
						}
						break;
						//查看时间
						case 9:{
							view_time();
						}
						break;
						//查看操作记录
						case 10:{
							view_log();
						}
						break;
						//查看个人邮件
						case 11:{
							log_inform();
						}
						break;
						case 12:{
							System.out.println("已退出登录");
							return ;
						}
						default:{
							System.out.println("请输入正确的操作");
							break;
						}
					}
			}
			//用户操作
			if(log_er instanceof user) {
				my_GUI.stu_meau();
				op=sc.nextInt();
				switch(op) {
					//浏览图书
					case 1:{
						view_book();
					}
					break;
					//借阅图书
					case 2:{
						borrowing_book();
					}
					break;
					//归还图书
					case 3:{
						return_book();
					}
					break;
					//查看个人信息
					case 4:{
						view_profile();
					}
					break;
					//查看个人邮件
					case 5:{
						log_inform();
					}
					break;
					//退出登录
					case 6:{
						System.out.println("已退出登录");
						return ;
					}
					default:{
						System.out.println("请输入正确的操作");
						break;
					}
				}
			}
		}
	}
	/*
	 * getter & setter 
	 */
	protected static person getLog_er() {
		return log_er;
	}
	protected static void setLog_er(person log_er) {
		system_frame.log_er = log_er;
	}
	
}

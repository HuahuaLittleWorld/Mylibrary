package myLibray;
/*
 *****图书管理系统*********
 * 初始馆藏图书10本
 * 初始学生10人
 * 管理员5人
 * enter类为入口类，为程序入口
 * 
 * @author 李帅兵
 */
public class Enter {
    public static void main(String[] args) {
		boolean loging=true;
		while(loging) {
			loging =system_frame.logn();
			system_frame.operation();
		}
	}
}

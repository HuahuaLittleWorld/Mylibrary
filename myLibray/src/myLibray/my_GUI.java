package myLibray;

public class my_GUI {
	//登录界面
    protected static void stu_meau() {
    	System.out.println("菜单使用说明：若想返回上级菜单或取消操作请输入~");
    	System.out.println("	1、浏览书籍");
    	System.out.println("	2、借阅书籍");
    	System.out.println("	3、归还书籍");
    	System.out.println("	4、查看个人信息");
    	System.out.println("	5、查看个人邮件");
    	System.out.println("	6、退出登录");
    }
	public static void adm_meau() {
		// TODO 自动生成的方法存根
		System.out.println("菜单使用说明：若想返回上级菜单或取消操作请输入~");
		System.out.println("	1、上架图书");
		System.out.println("	2、下架图书");
		System.out.println("	3、查看图书数据");
		System.out.println("	4、查看读者借阅数据统计与分析");
		System.out.println("	5、注册读者账户");
		System.out.println("	6、注销读者用户");
		System.out.println("	7、修改读者信息");
		System.out.println("	8、修改书籍库存");
		System.out.println("	9、查看时间");
		System.out.println("	10、查看图书馆日志");
		System.out.println("	11、查看个人邮件");
		System.out.println("	12、退出登录");
	}
    protected static void alter_book_meau() {
    	System.out.println("	1、修改库存");
    	System.out.println("	2、修改分区");
    	System.out.println("	3、修改");
    }
    protected static void search_book_meau() {
    	System.out.println("本系统支持模糊搜索和精准搜索");
    	System.out.println("	1、精准搜索");
    	System.out.println("	2、模糊搜索");
    }
    protected static void register_new_user_GUI() {
    	System.out.println("	请按顺序输入注册用户的正确信息：");
		System.out.println("****单行输入77可返回上层菜单****");
		System.out.println("****若数据输入错误，请换行输入777可重新输入");
		System.out.println("	请输入注册用户身份");
		System.out.println("	1、教师");
		System.out.println("	2、博士");
		System.out.println("	3、硕士");
		System.out.println("	4、本科生");
		System.out.println("____----温馨提示：只输入序号即可----____");
    }
	public static void warn_new_user() {
		// TODO 自动生成的方法存根
		System.err.println("请输入正确的选项");
		System.err.println("	1、教师");
		System.err.println("	2、博士");
		System.err.println("	3、硕士");
		System.err.println("	4、本科生");
		System.err.println("____----温馨提示：只输入序号即可----____");
		System.out.println("若想取消本次操作请输入9取消操作");
	}
}

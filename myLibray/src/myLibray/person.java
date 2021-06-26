package myLibray;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

abstract class person implements show_me {
   String name;
   String user;
   String passWrod;
   String phone_muber;
   String sex;
   int age;
   Queue<message> my_mails=new LinkedList<message>();
   protected person(String name, String sex, int age, String phone_muber, String passWrod,String user ) {
	super();
	this.name = name;
	this.user = user;
	this.passWrod = passWrod;
	this.phone_muber = phone_muber;
	this.sex = sex;
	this.age = age;
   }

   public person() {
	// TODO 自动生成的构造函数存根
   }
   
   protected void Initialize_password() {
	   if(user.length()<6) {
		   System.err.println("!!!!!!!");
		   System.err.println("用户名非法或不存在，无法初始化密码");
	   }
	   else {
		   setPassWrod(getUser().substring(user.length()-6));
		   System.out.println("新用户："+user+"的密码初始化成功");
		   System.out.println("初始密码为："+passWrod);
	   }
   }
    
   protected void show_mail() {
	   for(message e: 	my_mails ) {
		   System.out.println(e.show_introduce());
	   }
   }
   
/*
    * getter & setter 
    */
   
   
   
   
   
protected String getName() {
	return name;
}



protected Queue<message> getMy_mails() {
	return my_mails;
}

protected void setMy_mails(Queue<message> my_mails) {
	this.my_mails = my_mails;
}

protected void setName(String name) {
	this.name = name;
}

protected String getUser() {
	return user;
}

protected void setUser(String user) {
	this.user = user;
}

protected String getPassWrod() {
	return passWrod;
}

protected void setPassWrod(String passWrod) {
	this.passWrod = passWrod;
}

protected String getPhone_muber() {
	return phone_muber;
}

protected void setPhone_muber(String phone_muber) {
	this.phone_muber = phone_muber;
}

protected String getSex() {
	return sex;
}

protected void setSex(String sex) {
	this.sex = sex;
}

protected int getAge() {
	return age;
}

protected void setAge(int age) {
	this.age = age;
}
   
}

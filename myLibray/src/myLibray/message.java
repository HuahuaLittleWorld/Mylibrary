package myLibray;

import java.text.SimpleDateFormat;
import java.util.Date;

public class message implements show_me{
	//寄件人
    private person sender;
    //收件人
    private person addressee;
    //邮件
    private String e_mail;
    //时间
    private Date send_time;
    
    
    
    
    
    protected message(person sender, person addressee, String e_mail, Date send_time) {
		super();
		this.sender = sender;
		this.addressee = addressee;
		this.e_mail = e_mail;
		this.send_time = send_time;
		
	}


	//------------------------发送消息---------------------------
    static void send_message(person s,person r,String mail,Date time) {
    	message e=new message(s,r,mail,time);
    	r.my_mails.add(e);
    }
    
    
    //——————————————————————————show_me接口——————————————————————
    public message() {
		// TODO 自动生成的构造函数存根
	}
    

	@Override
	public String show_degree() {
		// TODO 自动生成的方法存根
		Integer code=this.hashCode();
		return code.toString();
	}



	@Override
	public String show_introduce() {
		// TODO 自动生成的方法存根
		 SimpleDateFormat formatter =new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		return sender.name+"\t"+e_mail+"\t"+formatter.format(send_time);
	}




	@Override
	public String show_ranking() {
		// TODO 自动生成的方法存根
		return null;
	}
    
    //--------------------------show_me接口------------------------------
    
    
    
    
    
    
    
    
    //——————————————————————getter and setter——————————————————————
	
	protected person getSender() {
		return sender;
	}
	protected void setSender(person sender) {
		this.sender = sender;
	}


	protected void setAddressee(person addressee) {
		this.addressee = addressee;
	}


	protected void setE_mail(String e_mail) {
		this.e_mail = e_mail;
	}


	protected void setSend_time(Date send_time) {
		this.send_time = send_time;
	}


	protected person getAddressee() {
		return addressee;
	}
	protected String getE_mail() {
		return e_mail;
	}
	protected Date getSend_time() {
		return send_time;
	}
 //------------------------setter and getter -------------------------------














}

package myLibray;

import java.text.SimpleDateFormat;
import java.util.Date;

public class message implements show_me{
	//�ļ���
    private person sender;
    //�ռ���
    private person addressee;
    //�ʼ�
    private String e_mail;
    //ʱ��
    private Date send_time;
    
    
    
    
    
    protected message(person sender, person addressee, String e_mail, Date send_time) {
		super();
		this.sender = sender;
		this.addressee = addressee;
		this.e_mail = e_mail;
		this.send_time = send_time;
		
	}


	//------------------------������Ϣ---------------------------
    static void send_message(person s,person r,String mail,Date time) {
    	message e=new message(s,r,mail,time);
    	r.my_mails.add(e);
    }
    
    
    //����������������������������������������������������show_me�ӿڡ�������������������������������������������
    public message() {
		// TODO �Զ����ɵĹ��캯�����
	}
    

	@Override
	public String show_degree() {
		// TODO �Զ����ɵķ������
		Integer code=this.hashCode();
		return code.toString();
	}



	@Override
	public String show_introduce() {
		// TODO �Զ����ɵķ������
		 SimpleDateFormat formatter =new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		return sender.name+"\t"+e_mail+"\t"+formatter.format(send_time);
	}




	@Override
	public String show_ranking() {
		// TODO �Զ����ɵķ������
		return null;
	}
    
    //--------------------------show_me�ӿ�------------------------------
    
    
    
    
    
    
    
    
    //��������������������������������������������getter and setter��������������������������������������������
	
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

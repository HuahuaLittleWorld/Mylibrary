package myLibray;

import java.util.ArrayList;
import java.util.HashMap;
public class data {
	//�ݲؼ����ͼ���б�
	static ArrayList<book> libOfBook_CS= new ArrayList<book>();
	//�ݲ��������ͼ���б�
	static ArrayList<book> libOfbook_Liberal_arts=new ArrayList<book>();
	//ͼ���ϣ��
	static HashMap<Integer, book> lib =new HashMap<Integer, book>();
	//ͼ���ʼ����
	static {
		//�������
		book temp= new book("java���������̳�", "978_7-115-54747-1", "�������Ա", 59.80, "�����ʵ������", true,2);
		libOfBook_CS.add(temp);
		lib.put(temp.hashCode()%100000, temp);
		book tem= new book("java���������̳�2", "978_7-115-54747-2", "�������Ա", 59.80, "�����ʵ������", true,2);
		libOfBook_CS.add(tem);
		lib.put(tem.hashCode()%100000, tem);
		book tep= new book("java���������̳�3", "978_7-115-54747-3", "�������Ա", 54.80, "�����ʵ������", true,2);
		libOfBook_CS.add(tep);
		lib.put(tep.hashCode()%100000, tep);
		book tmp= new book("java���������̳�4", "978_7-115-54747-4", "С����", 59.80, "�����ʵ������", true,2);
		libOfBook_CS.add(tmp);
		lib.put(tmp.hashCode()%100000, tmp);
		book tp= new book("java���������̳�", "978_7-115-54747-5", "������", 59.80, "���ӿƼ���ѧ������", true,2);
		libOfBook_CS.add(tp);
		lib.put(tp.hashCode()%100000, tp);
		book te= new book("Python���������̳�", "978_7-115-54747-6", "�������Ա", 59.80, "�廪��ѧ������", true,2);
		libOfBook_CS.add(te);
		lib.put(te.hashCode()%100000, te);
		book t1= new book("C���������̳�", "978_7-115-54747-8", "�������Ա", 59.80, "��ɽ��ѧ������", true,2);
		libOfBook_CS.add(t1);
		lib.put(t1.hashCode()%100000, t1);
		book t2= new book("C#���������̳�", "978_7-115-54747-9", "������", 59.80, "���ϴ�ѧ������", true,2);
		libOfBook_CS.add(t2);
		lib.put(t2.hashCode()%100000, t2);
		book t3= new book("GO���Ի��������̳�", "978_7-115-54747-10", "����", 59.80, "����ʦ����ѧ������", true,2);
		libOfBook_CS.add(t3);
		lib.put(t3.hashCode()%100000, t3);
		book t4= new book("Arduino���������̳�", "978_7-115-54747-11", "����", 59.80, "�ױڸ��г�����", true,2);
		libOfBook_CS.add(t4);
		lib.put(t4.hashCode()%100000, t4);
		book test= new book("test����book     ", "978_7-115-54747-11", "����", 59.80, "�ױڸ��г�����", true,2);
		libOfBook_CS.add(test);
		lib.put(test.hashCode()%100000, test);
		//���������
		book temp1=new book("�߶��Ǻ�","899-2-112-321-332","����",59.90,"�Ϻ����ֳ�����",true,3);
		libOfbook_Liberal_arts.add(temp1);
		lib.put(temp1.hashCode()%100000, temp1);
		book temp2=new book("����Ϧʰ","899-3-112-321-332","³Ѹ",19.90,"������ѧ������",true,3);
		libOfbook_Liberal_arts.add(temp2);
		lib.put(temp2.hashCode()%100000, temp2);
		book temp3=new book("��Q����","892-2-112-321-332","³Ѹ",39.90,"�������������",true,3);
		libOfbook_Liberal_arts.add(temp3);
		lib.put(temp3.hashCode()%100000, temp3);
		book temp4=new book("���","829-2-112-321-332","����",55.90,"�»�����������",true,3);
		libOfbook_Liberal_arts.add(temp4);
		lib.put(temp4.hashCode()%100000, temp4);
		book temp5=new book("�����","899-4-112-321-332","ɯʿ����",52.90,"�Ϻ����ֳ�����",true,3);
		libOfbook_Liberal_arts.add(temp5);
		lib.put(temp5.hashCode()%100000, temp5);
		book temp6=new book("�����","899-2-112-321-332","˾����",59.90,"�Ϻ����ֳ�����",true,3);
		libOfbook_Liberal_arts.add(temp6);
		lib.put(temp6.hashCode()%100000, temp6);
		book temp7=new book("���ҵ�����","899-2-112-321-332","���",69.90,"�Ϻ����ֳ�����",true,3);
		libOfbook_Liberal_arts.add(temp7);
		lib.put(temp7.hashCode()%100000, temp7);
		book temp8=new book("���Ĺ�ֹ","899-2-112-321-332","�����",49.90,"������ճ�����",true,3);
		libOfbook_Liberal_arts.add(temp8);
		lib.put(temp8.hashCode()%100000, temp8);
		book temp9=new book("��¥��","899-1-112-321-332","��ѩ��",56.90,"�������ճ�����",true,3);
		libOfbook_Liberal_arts.add(temp9);
		lib.put(temp9.hashCode()%100000, temp9);
		book temp10=new book("����ɽ����","892-2-112-321-332","������",52.90,"�Ϻ����ֳ�����",true,3);
		libOfbook_Liberal_arts.add(temp10);
		lib.put(temp10.hashCode()%100000, temp10);
	}
	
	
	//��ʼѧ���б�����
	static ArrayList<user> user_resited=new ArrayList<user>();
	//��ϣ��
	static HashMap<String, user> user_resiteMap=new HashMap<String, user>();
	static{
     //����ע��                  ����     �Ա� ����  �ֻ���         ����             �˻���
	 user st0=new bachelor("��˧��","��",20,"17639247585","huba20020402","202003024036");
	 user_resited.add(st0);
	 user_resiteMap.put(st0.getUser(), st0);
	 user st1=new bachelor("������","��",20,"17639247585","flr2020","202003024037");
	 user_resited.add(st1);
	 user_resiteMap.put(st1.getUser(), st1);
	 user st2=new master("������","��",20,"17639247585","773524","202003024038");
	 user_resited.add(st2);
	 user_resiteMap.put(st2.getUser(), st2);
	 user st3=new master("��һ��","��",20,"17639247585","zsc20020402","202003024039");
	 user_resited.add(st3);
	 user_resiteMap.put(st3.getUser(), st3);
	 user st4=new doctor("������","��",20,"17639247585","fl20020402","202003024040");
	 user_resited.add(st4);
	 user_resiteMap.put(st4.getUser(), st4);
	 user st5=new doctor("���Ӻ�","Ů",20,"17639247585","888888","202003024041");
	 user_resited.add(st5);
	 user_resiteMap.put(st5.getUser(), st5);
	 user test1=new teacher("����","��",20,"17639247585","2","2");
	 user_resited.add(test1);
	 user_resiteMap.put(test1.getUser(), test1);
	 user test2=new bachelor("������","Ů",20,"17639247585","1","1");
	 user_resited.add(test2);
	 user_resiteMap.put(test2.getUser(), test2);
	 user test3=new master("test_master","��",20,"17639247585","3","3");
	 user_resited.add(test3);
	 user_resiteMap.put(test3.getUser(), test3);
	}
	
    //��ʼ����Ա�б�����
	static ArrayList<administrator> adm_resited=new ArrayList<administrator>();
    static {
    	//�������Ա����䣬�ֻ����룬��¼���룬���ţ�
    	 administrator ad0=new administrator("������","��",40,"17639242341","111111","100001");
    	 adm_resited.add(ad0);
    	 administrator ad1=new administrator("����","��",30,"17539242341","122222","100002");
    	 adm_resited.add(ad1);
    	 administrator ad2=new administrator("������","��",43,"17639432341","133333","100003");
    	 adm_resited.add(ad2);
    	 administrator ad3=new administrator("����","��",42,"17639762341","144444","100004");
    	 adm_resited.add(ad3);
    	 administrator ad4=new administrator("����","Ů",31,"17632342341","155555","100005");
    	 adm_resited.add(ad4);
    	 administrator ad5=new administrator("�߾�","Ů",34,"17639627441","166666","100006");
    	 adm_resited.add(ad5);
    	 administrator ad6=new administrator("test_adm","Ů",34,"17639627441","21","21");
    	 adm_resited.add(ad6); 
    }
	//�����ݿ�
    static ArrayList<person> all_user=new ArrayList<person>();
    static {
    	all_user.addAll(adm_resited);
    	all_user.addAll(user_resited);
    }
	
}

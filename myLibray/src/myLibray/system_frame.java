package myLibray;

import java.util.Scanner;

/*
 * system_frame ����ֻΪ��������߼�
 * ������ϣ���С������仯������뽩����
 * ʹ����ṹ��λ����нṹ���õ�������󹹼ܶ����������Ĳ�ζ���
 */
public class system_frame extends libray_Interface {
	//���ö�̬��¼��¼��
	static private person log_er;
	//����������û��������ԶԱ�
	static private person adm=new administrator(null, null, 0, null, null, null);
	static private person doctor=new doctor(null, null, 0, null, null, null);
	static private person master=new master(null, null, 0, null, null, null);
	static private person teacher= new teacher(null, null, 0, null, null, null);
	static private person bachelor=new bachelor(null, null, 0, null, null, null);  
	//��¼
	boolean loging() {
		// TODO �Զ����ɵķ������
        return super.logn();
	}
	//����
	static void operation() {
		//���ڼ�¼ѡ��
		Scanner sc=new Scanner(System.in);
		while(true) {
			int op;
			if(log_er instanceof administrator ){
					//����Աѡ�񵥽���
					my_GUI.adm_meau();
					System.out.println("�������Ա����");
					op=sc.nextInt();
					switch(op) {
						//�ϼ�ͼ��
						case 1:{
							add_book();
						}
						break;
						//�¼�ͼ��
						case 2:{
							sub_book();
						}
						break;
						//�鿴ͼ������
						case 3:{
							view_book();
						}
						break;
						//�鿴���߽�������ͳ�������
						case 4:{
							view_reader_analyze();
						}
						break;
						//ע������˻�
						case 5:{
							register_new_user();
						}
						break;
						//ע�������˻�
						case 6:{
							logout_user();
						}
						break;
						//�޸Ķ�����Ϣ
						case 7:{
							alter_user_datail();
						}
						break;
						//�޸��鼮���
						case 8:{
							alter_book_datail();
						}
						break;
						//�鿴ʱ��
						case 9:{
							view_time();
						}
						break;
						//�鿴������¼
						case 10:{
							view_log();
						}
						break;
						//�鿴�����ʼ�
						case 11:{
							log_inform();
						}
						break;
						case 12:{
							System.out.println("���˳���¼");
							return ;
						}
						default:{
							System.out.println("��������ȷ�Ĳ���");
							break;
						}
					}
			}
			//�û�����
			if(log_er instanceof user) {
				my_GUI.stu_meau();
				op=sc.nextInt();
				switch(op) {
					//���ͼ��
					case 1:{
						view_book();
					}
					break;
					//����ͼ��
					case 2:{
						borrowing_book();
					}
					break;
					//�黹ͼ��
					case 3:{
						return_book();
					}
					break;
					//�鿴������Ϣ
					case 4:{
						view_profile();
					}
					break;
					//�鿴�����ʼ�
					case 5:{
						log_inform();
					}
					break;
					//�˳���¼
					case 6:{
						System.out.println("���˳���¼");
						return ;
					}
					default:{
						System.out.println("��������ȷ�Ĳ���");
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

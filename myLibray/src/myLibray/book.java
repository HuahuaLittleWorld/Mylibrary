package myLibray;

/*
 * ͼ�����л�����������Ϣ
 * ����****����*****������*****ISBN******�ݲ�����*****�۸�
 */
public class book implements show_me ,Comparable<book>{
   //����
   private String titleOfBook;
   //����
   private String authorOfBook;
   //ISBN
   private String isbnOfBook;
   //�۸�
   private double priceOfBook;
   //������
   private String pressOfBook;
   //�Ƿ�ɽ�
   private boolean isLendOfbook=true;
   //�ݲ�����
   private int inventoryOfBook;
   //����ͼ��Ľ��Ĵ���
   private int Max_borrow_number=0;
   
   
   
   
   
   /*
    * ���췽��
    */
   
protected book(String titleOfBook,String isbnOfBook, String authorOfBook, double priceOfBook, String pressOfBook,
		boolean isLendOfbook, int inventoryOfBook) {
	super();
	this.titleOfBook = titleOfBook;
	this.authorOfBook = authorOfBook;
	this.isbnOfBook = isbnOfBook;
	this.priceOfBook = priceOfBook;
	this.pressOfBook = pressOfBook;
	this.isLendOfbook = isLendOfbook;
	this.inventoryOfBook = inventoryOfBook;
}
   public book() {
	// TODO �Զ����ɵĹ��캯�����
	
}
   
   //����
   @Override
	public int compareTo(book o) {
		// TODO �Զ����ɵķ������
		return o.Max_borrow_number-this.Max_borrow_number;
	}
   
   
   
   
   
   
   
   
   /*
    * getter & setter ����
    */
   

   protected void setMax_borrow_number(int max_borrow_number) {
	Max_borrow_number = max_borrow_number;
   }
    

	
	protected String getTitleOfBook() {
		return titleOfBook;
	}
	protected void setTitleOfBook(String titleOfBook) {
		this.titleOfBook = titleOfBook;
	}
	protected String getAuthorOfBook() {
		return authorOfBook;
	}
	protected void setAuthorOfBook(String authorOfBook) {
		this.authorOfBook = authorOfBook;
	}
	protected String getIsbnOfBook() {
		return isbnOfBook;
	}
	protected void setIsbnOfBook(String isbnOfBook) {
		this.isbnOfBook = isbnOfBook;
	}
	protected double getPriceOfBook() {
		return priceOfBook;
	}
	protected void setPriceOfBook(double priceOfBook) {
		this.priceOfBook = priceOfBook;
	}
	protected String getPressOfBook() {
		return pressOfBook;
	}
	protected void setPressOfBook(String pressOfBook) {
		this.pressOfBook = pressOfBook;
	}
	protected boolean isLendOfbook() {
		return isLendOfbook;
	}
	protected void setLendOfbook(boolean isLendOfbook) {
		this.isLendOfbook = isLendOfbook;
	}
	protected int getInventoryOfBook() {
		return inventoryOfBook;
	}
	protected void setInventoryOfBook(int inventoryOfBook) {
		this.inventoryOfBook = inventoryOfBook;
	}
	
	public int getMax_borrow_number() {
		// TODO �Զ����ɵķ������
		return 0;
	}
	//--------------------------------------------
	@Override
	//-----------���з���-------------------
	//չʾ�Լ��Ĺݲر��
	public String show_degree() {
		// TODO �Զ����ɵķ������
		Integer code=this.hashCode()%100000;//ȡ��λ��ϣ����Ϊ�ݲر���
		return code.toString();
	}
	
	
	
	@Override
	public String show_introduce() {
		// TODO �Զ����ɵķ������
		if(isLendOfbook)
		//                   						����            ������               ������            ISBN             ���                   �۸�             �Ƿ��ϼ�
		return show_degree()  +"\t"+  titleOfBook+"\t\t"+authorOfBook+"\t\t"+pressOfBook+"\t\t"+isbnOfBook+"\t"+inventoryOfBook+"\t"+priceOfBook+"\t"+isLendOfbook;
		return null;
	}
	
	public String show_ranking() {
		// TODO �Զ����ɵķ������
		//                 �ݲر��                             ����               ������              �ݲؿ��                  ��������
		return show_degree()+"\t"+titleOfBook+"\t"+authorOfBook+"\t"+pressOfBook+"\t"+inventoryOfBook+"\t"+Max_borrow_number;
	}
	
	
	
	

}

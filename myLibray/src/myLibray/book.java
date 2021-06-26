package myLibray;

/*
 * 图书类中基本包含的信息
 * 书名****作者*****出版社*****ISBN******馆藏数量*****价格
 */
public class book implements show_me ,Comparable<book>{
   //书名
   private String titleOfBook;
   //作者
   private String authorOfBook;
   //ISBN
   private String isbnOfBook;
   //价格
   private double priceOfBook;
   //出版社
   private String pressOfBook;
   //是否可借
   private boolean isLendOfbook=true;
   //馆藏数量
   private int inventoryOfBook;
   //各自图书的借阅次数
   private int Max_borrow_number=0;
   
   
   
   
   
   /*
    * 构造方法
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
	// TODO 自动生成的构造函数存根
	
}
   
   //排序
   @Override
	public int compareTo(book o) {
		// TODO 自动生成的方法存根
		return o.Max_borrow_number-this.Max_borrow_number;
	}
   
   
   
   
   
   
   
   
   /*
    * getter & setter 方法
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
		// TODO 自动生成的方法存根
		return 0;
	}
	//--------------------------------------------
	@Override
	//-----------特有方法-------------------
	//展示自己的馆藏编号
	public String show_degree() {
		// TODO 自动生成的方法存根
		Integer code=this.hashCode()%100000;//取六位哈希码作为馆藏编码
		return code.toString();
	}
	
	
	
	@Override
	public String show_introduce() {
		// TODO 自动生成的方法存根
		if(isLendOfbook)
		//                   						书名            作者名               出版社            ISBN             库存                   价格             是否上架
		return show_degree()  +"\t"+  titleOfBook+"\t\t"+authorOfBook+"\t\t"+pressOfBook+"\t\t"+isbnOfBook+"\t"+inventoryOfBook+"\t"+priceOfBook+"\t"+isLendOfbook;
		return null;
	}
	
	public String show_ranking() {
		// TODO 自动生成的方法存根
		//                 馆藏编号                             作者               出版社              馆藏库存                  最大借阅量
		return show_degree()+"\t"+titleOfBook+"\t"+authorOfBook+"\t"+pressOfBook+"\t"+inventoryOfBook+"\t"+Max_borrow_number;
	}
	
	
	
	

}

package LibrarySystem;

public class Book {
   //私有成员变量
   private String id;
   private String name;//书名
   private String author;//作者
   private String pubdata;//出版日期
   private int store;//库存数量
   private int price;//价格
   //构造方法，初始化实例对象
	public Book(String id, String name, String author, String pubdata, int store, int price) {
		this.id = id;
		this.name = name;
		this.author = author;
		this.pubdata = pubdata;
		this.store = store;
		this.price = price;
	}
	//每个属性的getter和setter方法
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPubdata() {
		return pubdata;
	}
	public void setPubdata(String pubdata) {
		this.pubdata = pubdata;
	}
	public int getStore() {
		return store;
	}
	public void setStore(int store) {
		this.store = store;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
}




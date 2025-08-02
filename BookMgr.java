package LibrarySystem;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookMgr {	
	//单例模式设计，声明一个静态，私有的BookMgr类型变量
	//存储类的唯一实例,类加载时直接创建类的唯一实例
     private static BookMgr instance=new BookMgr();
     // 使用 HashMap 存储书籍，键为 ID
     private final Map<String, Book> bookMap = new HashMap<>();
 
     //私有构造方法，禁止外部实例化
     private BookMgr() {
    	 addBook(new Book("1","java核心技术","Cay S.Horstmann","1978-03-25",25,50));
    	 addBook(new Book("2","Effective java","Joshua Bloch","1979-04-26",30,40));
    	 addBook(new Book("3","python编程入门到实践","Eric Matthes","1968-11-07",30,30));
    	 }
     //获取BookMgr对象
     public static BookMgr getInstance() {
    	return instance;
     }
     //图书入库（在库图书增加数量）
     public void inBook(String bookid,int num) {	
    	 if (bookid == null || bookid.isEmpty() || num <= 0) {
             System.out.println("输入信息不合法，请检查图书 ID 和入库数量！");
             return;
         }
         Book book = getById(bookid); // 先找书是否存在
         if (book != null) {
             book.setStore(book.getStore() + num);
             System.out.println("入库成功，当前库存为：" + book.getStore());
         } else {
             System.out.println("无此图书，入库失败！");
         }
     }
     //新增图书（原库中无此图书）
     public boolean addBook(Book b) {

    	 if(getById(b.getId())!=null){//应该确保图书是新的，原来里面没有
    		 System.out.print("图书已存在！！");
    		 return false;
    	  }
    	 bookMap.put(b.getId(), b);
    	 return true;
     }
     //已有图书出库
     public boolean outBook(String bookid,int num) {
    	 if (bookid == null || bookid.isEmpty() || num <= 0) {
             System.out.println("输入信息不合法，请检查图书 ID 和入库数量！");
             return false;
         }
    	 Book book=getById(bookid);
    	 if(book!=null) {
    		 book.setStore(book.getStore()-num);
    		 System.out.println("出库成功！当前库存为："+book.getStore()); 
    		 return true;
    	 }
    	 else {
    		 System.out.println("出库失败，无此图书！");
    		 return false;
    	 }

     }
     //查询所有图书
     public List<Book> getAll(){
    	return new ArrayList<>(bookMap.values());
     }
     //根据Id查找图书
     public Book getById(String bookid){
    	 return bookMap.get(bookid);
 
     }
     //计算总价，
     //返回值为0，表示数量不足
     //返回值为-1，表示无此Id图书
     public double checkout(String bookid,int num) {
    	 Book book=getById(bookid);
    	 if(book==null)   return -1;
    	 int count=book.getStore(); 
    	 if(count< num)   return 0;
    	 book.setStore(count - num);
    	 return book.getPrice()*num;
     }
     //获得所有附赠品名称
     public List<String> getEXNames() {
         return EXFactory.getAllEX();
     }  
     //购买附赠品
     public EX buyEX(int exCode) {
         return EXFactory.create(exCode);
     }
}


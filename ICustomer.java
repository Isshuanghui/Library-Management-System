package LibrarySystem;
import java.util.List;

public interface ICustomer {
	
 List<Book>  findBooks();//查询图书方法

 Book buyBookById(String id);//购买图书方法
 double checkout(String bookid,int num);//计算价格
 
 List<String> getEXInfo(); //附赠品查询方法
 EX buyEX(int exCode); // 附赠品购买方法
}

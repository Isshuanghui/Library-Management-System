package LibrarySystem;
//管理员权限接口


import java.util.List;

public interface IAdmin {
	void inBook(String bookid, int num);//入库方法，
	boolean outBook(String outId,int num);//出库方法，
	boolean addBook(Book book);//新增图书方法，
	List<Book> findAllBooks();//查询图书方法
}

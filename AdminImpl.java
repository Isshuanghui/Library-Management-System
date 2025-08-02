package LibrarySystem;


import java.util.List;

public  class AdminImpl implements IAdmin{
	private BookMgr bm=BookMgr.getInstance(); 
	//入库方法
	@Override
	public void inBook(String bookid, int num) {
		bm.inBook(bookid,num);	
	}
	//出库方法
	@Override
	public boolean outBook(String bookid, int num) {
		return bm.outBook(bookid,num);
	}
	//新增图书方法
	@Override
	public boolean addBook(Book book) {
		return bm.addBook(book);
	}
	//查询图书方法
	@Override
	public List<Book> findAllBooks() {
		return bm.getAll();
	}

}


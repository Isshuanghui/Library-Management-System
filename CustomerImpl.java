package LibrarySystem;
//实现类（必须重写接口中的所有方法）


import java.util.List;

public  class CustomerImpl implements ICustomer {
  private BookMgr bm=BookMgr.getInstance(); 
 //查询图书方法
    @Override
	public List<Book> findBooks() {
		return bm.getAll();
	}
 //购买图书方法
	@Override
	public Book buyBookById(String id) {
		return bm.getById(id);
	}
	@Override
	public double checkout(String bookid, int num) {
		return bm.checkout(bookid,num);
	}
 //购买附赠品信息方法
   @Override
   public EX buyEX(int exCode) {
       return bm.buyEX(exCode);
   }
  //查询附赠品信息方法
   @Override
   public List<String> getEXInfo() {
      return bm.getEXNames();
   }
}
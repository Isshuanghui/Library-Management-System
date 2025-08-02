package LibrarySystem;

import java.util.List;
import java.util.Scanner;

public class MainTest {
    private static BookMgr bookMgr = BookMgr.getInstance();
    private static IAdmin admin = new AdminImpl();
    private static ICustomer customer = new CustomerImpl();
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {    	
        System.out.println("----------------欢迎光临图书馆系统---------------");
        GetStringInPut("请输入你的名字：");
        System.out.println("1.Admin    2.Customer");
        while (true) {        	
        	int role = GetIntInPut("请选择你的身份: ");
            switch (role) {
                case 1:
                    adminMenu();
                    return;
                case 2:
                    customerMenu();
                    return;
                default:
                    System.out.println("无效选项，请重新选择！");
            }
        }
    }	   
    private static void adminMenu() {
    	System.out.println("----------------管理员界面---------------");
    	while(true) {
	    	System.out.println("1.图书入库 2.图书出库 3.新增图书 4.查看图书 0.退出系统");
	    	int option=GetIntInPut("请选择你的操作：");
	    	switch(option) {
	    	case 1: InBook(); break;
	    	case 2: OutBook();break;
	    	case 3: NewBook();break;
	    	case 4: SeeBook();break;
	    	case 0: System.out.println("系统已退出！"); return;
	    	default:
                System.out.println("无效选项，请重新选择！");
	    	}	    	
    	}   	
    }
    private static void customerMenu() {
    	System.out.println("----------------顾客界面---------------");
    	boolean hasbuy=false;
    	while(true) {
	    	System.out.println("1.查看图书 2.购买图书 3.查询附赠品 4.购买附赠品 0.退出系统");
	    	int option=GetIntInPut("请选择你的操作：");
	    	switch(option) {
	    	case 1: SeeBook();break;
	    	case 2: hasbuy=BuyBook(); break;
	    	case 3: SeeGift(); break;
	    	case 4: if(hasbuy) BuyGift();
	    			else System.out.println("请先购买图书再购买附赠品！");
	    			break;
	    	case 0: System.out.println("系统已退出！"); return;         
	    	default:
                System.out.println("无效选项，请重新选择！");
	    	}
	    	
    	}
    } 
    //获取输入操作
    private static int GetIntInPut(String prompt) {
    	System.out.println(prompt);  	
    	int input=sc.nextInt();
    	sc.nextLine();
    	return input;  	
    }
    private static String GetStringInPut(String prompt) {
    	System.out.println(prompt);
    	return sc.nextLine();
    }
    //图书入库
    private static void InBook() {
    	String inID=GetStringInPut("请输入图书ID：");
    	int inNum=GetIntInPut("请输入入库数量：");
    	admin.inBook(inID,inNum);
    }
    //图书出库
    private static void OutBook() {
    	String outID=GetStringInPut("请输入图书ID：");
    	int outNum=GetIntInPut("请输入出库数量：");
    	admin.outBook(outID,outNum);
    }
    //新增图书
    private static void NewBook() {
    	    String id=GetStringInPut("请输入新增图书ID：");
    	    String name=GetStringInPut("请输入新增图书书名：");
    	    String author=GetStringInPut("请输入新增图书作者：");
    	    String pubdata=GetStringInPut("请输入新增图书出版日期：");
    	    int store=GetIntInPut("请输入新增图书数量：");
    	    int price=GetIntInPut("请输入新增图书价格：");
    	    Book b=new Book(id,name,author,pubdata,store,price);//定义好一本书
    	    boolean addresult=admin.addBook(b);
    	    System.out.println(addresult ? "添加成功！" : "添加失败（ID 已存在）");
    }
    //查看图书
    private static void SeeBook() {
    	System.out.println("当前所有图书清单:");
    	List<Book> books=admin.findAllBooks();//admin.方法只能得到图书列表，不能输出，所以需要格外输出
    	books.forEach(b->System.out.printf(
    			"ID:%-3s 书名:%s 作者:%s 出版日期:%s 库存:%-3d 价格:%d元\n",
    			b.getId(),b.getName(),b.getAuthor(),b.getPubdata(),b.getStore(),b.getPrice()
    			));  	
    }
    //购买图书,计算总价,返回值为0，表示数量不足,返回值为-1，表示无此Id图书
    private static boolean BuyBook() {
    	String buyid=GetStringInPut("请输入购买图书ID：");
    	int num=GetIntInPut("请输入购买图书数量：");
    	Double buyresult=customer.checkout(buyid,num);
    	if(buyresult==0)
    		{System.out.println("购买失败！！此书库存不足");return false;}
    	else if(buyresult==-1)
    		{System.out.println("购买失败！！无此ID图书");return false;}
    	else {
    		System.out.printf("购买成功！总价为：%.2f元",buyresult);
    		System.out.print("\n");
    		return true;
    	}
    	
    }
    //查询附赠品
    private static void SeeGift() {
    	System.out.println("当前所有附赠品清单：");
    	List<String> list=customer.getEXInfo();
    	for(String item:list)
    		System.out.print(item+" ");
    	System.out.print("\n");
    }
    //购买附赠品
    private static void BuyGift() {
    	int buyid=GetIntInPut("请输入附赠品编号(1.CD 2.Bag 3.Pen)：");
    	EX gift = customer.buyEX(buyid);
        if (gift != null) 
            System.out.printf("获得附赠品：%s（价值%.2f 元）\n", gift.getEx_name(), gift.getPrice());
        else 
            System.out.println("无效的附赠品编号！");        
    }   
}
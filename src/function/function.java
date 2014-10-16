package function;

import java.sql.*;
import java.util.ArrayList;

import com.opensymphony.xwork2.ActionSupport;

public class function  extends ActionSupport
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ArrayList<BookDetail> bookdetails;

	private static ResultSet result;
	
	private String AuthorID;
	private String Name = "";
	private String Age;
	private String Country;
	
	private String ISBN;
	private String Title;
//	private String AuthorID;
	private String Publisher;
	private String PublishDate;
	private String Price;
	
	public String list() throws SQLException
	{
		
		return "display";
	}
	
	public String execute() throws SQLException
	{	
		String sql;
		Connection connection = Connect();
		bookdetails = new ArrayList<BookDetail>();
		// statement用来执行SQL语句
		Statement statement = connection.createStatement();
		// 要执行的SQL语句
		
		//查询数据
		if(Name.equals(""))
			sql = "select * from book";
		else
		{
			sql = "select AuthorID from author where Name = '";
			sql += Name + "'";
			result = statement.executeQuery(sql);
			while(result.next())
			{
				AuthorID = result.getString("AuthorID");
			}	
			sql = "select * from book where AuthorID = '"+AuthorID+"'";
		}
		
		// 执行SQL语句并返回结果集
		result = statement.executeQuery(sql);
		bookdetails.clear();
		while(result.next()) {
			// 输出结果
			BookDetail bookdetail = new BookDetail();
			
			bookdetail.setISBN(result.getString("ISBN"));
			bookdetail.setTitle(result.getString("Title"));
			bookdetail.setAuthorID(result.getString("AuthorID"));
			bookdetail.setPublisher(result.getString("Publisher"));
			bookdetail.setPublishDate(result.getString("PublishDate"));
			bookdetail.setPrice(result.getString("Price"));
			
			bookdetails.add(bookdetail);
		}
		// 关闭结果集
		result.close();
		// 关闭连接
		connection.close();	
		return "display_success";
	}
	
	public String Alter_prepare() throws SQLException
	{
		return "Alter_prepare";
	}
	
	public String Alter() throws SQLException
	{
		String sql;
		Connection connection = Connect();
		bookdetails = new ArrayList<BookDetail>();
		// statement用来执行SQL语句
		Statement statement = connection.createStatement();
		// 要执行的SQL语句
		
		//查询数据
		
		sql = "update book set Title = '"+Title+"',AuthorID = '"+AuthorID+"',Publisher = '"+Publisher+"', PublishDate = '"+PublishDate+"',Price = '"+Price+"' where ISBN = '"+ISBN+"'";
		statement.executeUpdate(sql);
		
		sql = "select * from book";
		// 执行SQL语句并返回结果集
		result = statement.executeQuery(sql);
		bookdetails.clear();
		while(result.next()) {
			// 输出结果
			BookDetail bookdetail = new BookDetail();
			
			bookdetail.setISBN(result.getString("ISBN"));
			bookdetail.setTitle(result.getString("Title"));
			bookdetail.setAuthorID(result.getString("AuthorID"));
			bookdetail.setPublisher(result.getString("Publisher"));
			bookdetail.setPublishDate(result.getString("PublishDate"));
			bookdetail.setPrice(result.getString("Price"));
			
			bookdetails.add(bookdetail);
		}
		// 关闭结果集
		result.close();
		// 关闭连接
		connection.close();	
		return "Alter_success";
	}
	public String Delete() throws SQLException
	{
		String sql;
		Connection connection = Connect();
		bookdetails = new ArrayList<BookDetail>();
		// statement用来执行SQL语句
		Statement statement = connection.createStatement();
		// 要执行的SQL语句
		
		//查询数据
		sql = "delete from book where ISBN='"+ISBN+"'";
		statement.executeUpdate(sql);
		
		sql = "select * from book";
		// 执行SQL语句并返回结果集
		result = statement.executeQuery(sql);
		bookdetails.clear();
		while(result.next()) {
			// 输出结果
			BookDetail bookdetail = new BookDetail();
			
			bookdetail.setISBN(result.getString("ISBN"));
			bookdetail.setTitle(result.getString("Title"));
			bookdetail.setAuthorID(result.getString("AuthorID"));
			bookdetail.setPublisher(result.getString("Publisher"));
			bookdetail.setPublishDate(result.getString("PublishDate"));
			bookdetail.setPrice(result.getString("Price"));
			
			bookdetails.add(bookdetail);
		}
		// 关闭结果集
		result.close();
		// 关闭连接
		connection.close();	
		return "Delete_success";
	}
	public String Addbook() throws SQLException
	{
		String sql;
		Connection connection = Connect();
		bookdetails = new ArrayList<BookDetail>();
		// statement用来执行SQL语句
		Statement statement = connection.createStatement();
		// 要执行的SQL语句
		
		sql = "select * from book where ISBN = '"+ISBN+"'";
		result = statement.executeQuery(sql);
		if (result.next() == false)
		{
			sql = "insert into book values ('"+ISBN+"','"+Title+"','"+AuthorID+"','"+Publisher+"','"+PublishDate+"','"+Price+"')";
			statement.executeUpdate(sql);
			
			sql = "select * from author where AuthorID = '"+AuthorID+"'";
			result = statement.executeQuery(sql);
			
			if (result.next() == false)
			{
				sql = "insert into author values ('"+AuthorID+"','"+Name+"','"+Age+"','"+Country+"')";
				statement.executeUpdate(sql);
			}
			else
			{
				System.out.println("作者已存在");
			}
			
		}
		else
		{
			System.out.println("书籍已存在");
		}
		
		
		sql = "select * from book";
		// 执行SQL语句并返回结果集
		result = statement.executeQuery(sql);
		bookdetails.clear();
		while(result.next()) {
			// 输出结果
			BookDetail bookdetail = new BookDetail();
			
			bookdetail.setISBN(result.getString("ISBN"));
			bookdetail.setTitle(result.getString("Title"));
			bookdetail.setAuthorID(result.getString("AuthorID"));
			bookdetail.setPublisher(result.getString("Publisher"));
			bookdetail.setPublishDate(result.getString("PublishDate"));
			bookdetail.setPrice(result.getString("Price"));
			
			bookdetails.add(bookdetail);
		}
		// 关闭结果集
		result.close();
		// 关闭连接
		connection.close();	
		return "Add_New_success";
	}

	public String GetDetail() throws SQLException
	{
		String sql;
		Connection connection = Connect();
		// statement用来执行SQL语句
		Statement statement = connection.createStatement();
		// 要执行的SQL语句
		
		//查询数据
		sql = "select * from book where ISBN = '"+ISBN+"'";
		// 执行SQL语句并返回结果集
		result = statement.executeQuery(sql);
		while(result.next()) {
			// 输出结果	
			ISBN = result.getString("ISBN");
			Title = result.getString("Title");
			AuthorID = result.getString("AuthorID");
			Publisher = result.getString("Publisher");
			PublishDate = result.getString("PublishDate");
			Price = result.getString("Price");
		}
		
		sql = "select * from author where AuthorID = '"+AuthorID+"'";
		// 执行SQL语句并返回结果集
		result = statement.executeQuery(sql);
		while(result.next()) {
			// 输出结果	
			AuthorID = result.getString("AuthorID");
			Name = result.getString("Name");
			Age = result.getString("Age");
			Country = result.getString("Country");
		}
		
		// 关闭结果集
		result.close();
		// 关闭连接
		connection.close();	
		return "GetDetail_success";
	}
	
	public Connection Connect()
	{
		Connection connection = null;
		try {
			// 加载驱动程序
			Class.forName("com.mysql.jdbc.Driver");
			// URL指向要访问的数据库名test
			String url = "jdbc:mysql://w.rdc.sae.sina.com.cn:3307/app_hwjbookdb";	
			// MySQL配置时的用户名
			String user = "kx2ly2mm1n";
			// MySQL配置时的密码
			String password = "4mk202ijxy2yjyi51hy423j5k52jh0ili12341x3";
			// 连续数据库
			connection = DriverManager.getConnection(url, user, password);
			if(!connection.isClosed())
				System.out.println("Succeeded connecting to the Database!");
			return connection;
		
		} catch(ClassNotFoundException e) {
			System.out.println("Sorry,can`t find the Driver!");
			System.out.println(e);
			e.printStackTrace();
			return connection;
		} catch(SQLException e) {
			System.out.println("Sorry,can`t find the Driver!");
			e.printStackTrace();
			return connection;
		} catch(Exception e) {
			System.out.println("Sorry,can`t find the Driver!");
			e.printStackTrace();
			return connection;
		}
	}

	public static ResultSet getResult() {
		return result;
	}

	public static void setResult(ResultSet result) {
		function.result = result;
	}

	public String getAuthorID() {
		return AuthorID;
	}

	public void setAuthorID(String authorID) {
		AuthorID = authorID;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getAge() {
		return Age;
	}

	public void setAge(String age) {
		Age = age;
	}

	public String getCountry() {
		return Country;
	}

	public void setCountry(String country) {
		Country = country;
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getPublisher() {
		return Publisher;
	}

	public void setPublisher(String publisher) {
		Publisher = publisher;
	}

	public String getPublishDate() {
		return PublishDate;
	}

	public void setPublishDate(String publishDate) {
		PublishDate = publishDate;
	}

	public String getPrice() {
		return Price;
	}

	public void setPrice(String price) {
		Price = price;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public ArrayList<BookDetail> getBookdetails() {
		return bookdetails;
	}

	public void setBookdetails(ArrayList<BookDetail> bookdetails) {
		this.bookdetails = bookdetails;
	}
}
class BookDetail
{
	private String ISBN;
	private String Title;
	private String AuthorID;
	private String Publisher;
	private String PublishDate;
	private String Price;
	public String getISBN() {
		return ISBN;
	}
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getAuthorID() {
		return AuthorID;
	}
	public void setAuthorID(String authorID) {
		AuthorID = authorID;
	}
	public String getPublisher() {
		return Publisher;
	}
	public void setPublisher(String publisher) {
		Publisher = publisher;
	}
	public String getPublishDate() {
		return PublishDate;
	}
	public void setPublishDate(String publishDate) {
		PublishDate = publishDate;
	}
	public String getPrice() {
		return Price;
	}
	public void setPrice(String price) {
		Price = price;
	}
}
class UserDetail
{
	private String AuthorID;
	private String Name;
	private String Age;
	private String Country;
	public String getAuthorID() {
		return AuthorID;
	}
	public void setAuthorID(String authorID) {
		AuthorID = authorID;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getAge() {
		return Age;
	}
	public void setAge(String age) {
		Age = age;
	}
	public String getCountry() {
		return Country;
	}
	public void setCountry(String country) {
		Country = country;
	}
}
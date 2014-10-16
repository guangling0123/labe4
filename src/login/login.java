package login;
import com.opensymphony.xwork2.ActionSupport;

public class login extends ActionSupport
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private String password;
	public String getName()
	{
		return name;
	}
	public void setName(String name) 
	{
		this.name = name;
	}
	public String setPassword()
	{
		return password;
	}
	public void setPassword(String password)
	{
		this.password = password;
	}
	public String execute()
	{
		if(name.equals("root")&&password.equals("1234"))
		{
			return "success";
		}
		else
		{
			return "failure";
		}
	}
	public String back()
	{
		return "back";
	}
}

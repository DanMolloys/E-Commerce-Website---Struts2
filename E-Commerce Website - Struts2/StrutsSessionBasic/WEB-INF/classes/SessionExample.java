import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;
import com.opensymphony.xwork2.ActionSupport;


public class SessionExample extends ActionSupport implements SessionAware
{
    private String username;
    private String password;
    private String bids;
    private String items;


	private Map<String, Object> session;
    
    
    public SessionExample() {
    	
    }
    
    public String register() {
    	String outcome = "failure";
    	Connection connection = null;
    	
    	try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecom?serverTimezone=UTC", "root", "root");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	PreparedStatement createUser = null;
		
			//sql statement
			try {
				createUser = connection.prepareStatement("INSERT into user " + "(username, password)" + " VALUES (?, ?)");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				createUser.setString(1, username);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				createUser.setString(2, password);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				int rowsUpdated = createUser.executeUpdate();
				outcome = "success";
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				createUser.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return outcome;
		
    }
    
    public String getUsername() {
        return this.username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	public String getBids() {
		return bids;
	}

	public void setBids(String bids) {
		this.bids = bids;
	}

	public String getItems() {
		return items;
	}

	public void setItems(String items) {
		this.items = items;
	}

    
    public void setSession(Map map) {
        session = map;
    }
}
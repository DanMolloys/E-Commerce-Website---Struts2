import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;
import com.opensymphony.xwork2.ActionSupport;


public class Bids extends ActionSupport implements SessionAware
{
    private String item;
    private String amount;
    private String bidder;
    private Map<String, Object> session;
    
    
    public Bids() {
    	
    }
    
    public String createBid() {
    	String outcome = "failure";
    	Connection connection = null;
    	
    	try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecom?serverTimezone=UTC", "root", "root");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	PreparedStatement createUser = null;
    	PreparedStatement getUser = null;
		
			//sql statement
			try {
				createUser = connection.prepareStatement("INSERT into bids " + "(item, amount, bidder)" + " VALUES (?, ?, ?)");
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				createUser.setString(1, item);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				createUser.setString(2, amount);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				createUser.setString(3, bidder);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
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
    
    public String biddingIn() {
		String outcome = "failure";
		
		Connection connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecom?serverTimezone=UTC", "root", "root");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		Statement statement = null;
		try {
			statement = connection.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ResultSet rs = null;
		try {
			rs = statement.executeQuery("select * from bids");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			while (rs.next()) {
				if ((rs.getString(1).equalsIgnoreCase(item) && (rs.getString(2).equalsIgnoreCase(amount) && (rs.getString(3).equalsIgnoreCase(bidder))))){
					outcome = "success";
					session.put("currentUser", rs.getString(3));
					
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return outcome;
	}
	

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getBidder() {
		return bidder;
	}

	public void setBidder(String bidder) {
		this.bidder = bidder;
	}

	@Override
	public void setSession(Map map) {
		// TODO Auto-generated method stub
		session = map;
	}
}
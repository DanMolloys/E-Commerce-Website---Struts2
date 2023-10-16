import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;
import com.opensymphony.xwork2.ActionSupport;


public class Items extends ActionSupport implements SessionAware
{
    private String items;
    private String bids;
    private String bidder;
    private String owner;
    private Map<String, Object> session;
    
    
    public Items() {
    	
    }
    
    public String createItem() {
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
				createUser = connection.prepareStatement("INSERT into items " + "(items, bids, bidder, owner)" + " VALUES (?, ?, ?, ?)");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				createUser.setString(1, items);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				createUser.setString(2, bids);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				createUser.setString(3, bidder);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				createUser.setString(4, owner);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//String currentBid;
			//currentBid = ((PreparedStatement) session).setString(3, bidder);
			
			
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
    
    public String itemsIn() {
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
			rs = statement.executeQuery("select * from items");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			while (rs.next()) {
				if ((rs.getString(1).equalsIgnoreCase(items) && (rs.getString(2).equalsIgnoreCase(bids) && (rs.getString(3).equalsIgnoreCase(bidder) && (rs.getString(4).equalsIgnoreCase(owner)))))){
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
	


	public String getItems() {
		return items;
	}

	public void setItems(String items) {
		this.items = items;
	}

	public String getBids() {
		return bids;
	}

	public void setBids(String bids) {
		this.bids = bids;
	}

	public String getBidder() {
		return bidder;
	}

	public void setBidder(String bidder) {
		this.bidder = bidder;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	@Override
	public void setSession(Map map) {
		// TODO Auto-generated method stub
		session = map;
	}
}
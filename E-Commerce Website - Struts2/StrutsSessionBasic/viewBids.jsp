

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="/struts-tags" prefix="s" %>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ecom login</title>
    </head>
    <body>
	Logged in as: <s:property value ="#session.currentUser"/></br>
	<h1>All bids on items:</h1>
		<%
			Connection connection = null;
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecom?serverTimezone=UTC", "root", "root");
			
			Statement statement = null;
			statement = connection.createStatement();
			
			ResultSet rs = null;
			rs = statement.executeQuery("select * from bids");	
		%>
		
		<TABLE BORDER="1">
		<tr>
		<th>item</th><th>bid</th><th>bidder</th>
		</tr>
		
		<% while(rs.next()){ %>
		<TR bgcolor="#DEB887">
		<td><%=rs.getString(1) %></td>
		<td><%=rs.getString(2) %></td>
		<td><%=rs.getString(3) %></td>
		</tr>
		<% } %>
		</TABLE>
		
	</body>
</html>
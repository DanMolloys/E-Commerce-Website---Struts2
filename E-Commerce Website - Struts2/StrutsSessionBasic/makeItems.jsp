

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="/struts-tags" prefix="s" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ecom</title>
    </head>
    <body>
	Logged in as: <s:property value ="#session.currentUser"/></br>
    <h1>Make bid below!! </h1>
        <s:form action="makeItems" >
            <s:textfield name="items" label="Item: " />
			<s:textfield name="bid" label="Amount: " />
			<s:textfield name="bidder" label="Logged ins username: " />
			<s:textfield name="owner" label="Owner: " />
            <s:submit />
        </s:form>
		
    </body>
</html>



<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="/struts-tags" prefix="s" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ECommerce home page</title>
    </head>
    <body>
    <h1>Selcet an option</h1>
	
	Welcome - Logged in as: <s:property value ="#session.currentUser"/></br>
	<p>
	
	<br><button onclick="location.href=''" type = "button"> view my profile </button>
	<br><button onclick="location.href=''" type = "button"> view others profiles </button>
	<br><button onclick="location.href='viewAlls.jsp'" type = "button"> view all users </button>
	<br><button onclick="location.href='makeItems.jsp'" type = "button"> add item for sale </button>
	<br><button onclick="location.href='viewItems.jsp'" type = "button"> view items for sale </button>
	<br><button onclick="location.href='makeBids.jsp'" type = "button"> make bid </button>
	<br><button onclick="location.href=''" type = "button"> view my bid </button>
	<br><button onclick="location.href='viewBids.jsp'" type = "button"> view all bids on an item </button>
	
	</p>
	</body>
</html>
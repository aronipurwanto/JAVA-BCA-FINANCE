<!DOCTYPE html>
<html>
	<head>
		<title>Output JSP</title>
	</head>
	<body>
		<h1>Output JSP</h1>
		<label>ID :<%= request.getParameter("id") %></label> <br/>
		<label>Code :<%= request.getParameter("code") %></label> <br/>
		<label>Name :<%= request.getParameter("name") %></label> <br/>
		<label>Current Time: <%= java.util.Calendar.getInstance().getTime()%></label>
	</body>
</html>

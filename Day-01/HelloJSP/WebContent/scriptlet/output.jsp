<!DOCTYPE html>
<html>
	<head>
		<title>Output JSP</title>
	</head>
	<body>
		<%
		Integer id = Integer.parseInt(request.getParameter("id"));
		String code = request.getParameter("code");
		String name = request.getParameter("name");
		%>
		<h1>Output JSP</h1>
		<label>ID : <% out.print(id); %></label> <br/>
		<label>Code : <% out.print(code); %></label> <br/>
		<label>Name : <% out.print(name); %></label> <br/>
	</body>
</html>

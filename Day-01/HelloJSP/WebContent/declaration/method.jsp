<html>
	<head>
		<title>Method JSP</title>
	</head>
	<body>
		<h1>Method JSP</h1>
		<%! 
		int summary(int x, int y)
		{
			return x+y;	
		}
		%>
		<p> Summary (50+60) :<%= summary(50, 60) %></p>
	</body>
</html>

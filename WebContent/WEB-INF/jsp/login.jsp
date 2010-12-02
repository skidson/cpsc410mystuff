<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<%@ include file="/WEB-INF/jsp/include.jsp" %>
<title>MyStuff - Login</title>
</head>

<body>

	<div id="wrap">
		
		<div id="header">			
			<h1 id="logo-text"><a href="home.htm">MyStuff</a></h1>
			<p id="slogan">Your one-stop shop for media information...</p>
		</div> <!-- header -->
		
		<div  id="menu">
			<ul>
				<li id="current"><a href="home.htm">Home</a></li>
				<li><a href="media.htm">Media</a></li>
				<li><a href="friends.htm">Friends</a></li>
				<li><a href="mailbox.htm">Mailbox</a></li>
				<li><a href="account.htm">Account</a></li>	
			</ul>
		</div> <!--  menu -->	
		
			
		<div id="content-wrap">

			<div id="main">
				<h2>Login</h2>
				<center>
				<table><tr>
					<c:if test="${not empty param.error}">
						<font color="red">Login error: ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}</font>
					</c:if>
					<form method="POST" action="<c:url value="/j_spring_security_check" />">			
						<label>Username:</label><input type="text" size = "30" name="j_username" />
						<label>Password:</label><input type="password" size="30" name="j_password" /> <br />
						<a href="register.htm?error=false">Register</a>
						<br />
						<label><input type="checkbox" name="_spring_security_remember_me" /> Remember me</label>
						<center><input class="button" value="          Login          " type="submit" /></center>
					</form>		
				</tr></table>
				</center>
			</div> <!--  main -->
		</div> <!-- content-wrap -->	
				
	<div id="footer">
		<%@ include file="/WEB-INF/jsp/footer.jsp" %>
	</div>	

</div>

</body>
</html>
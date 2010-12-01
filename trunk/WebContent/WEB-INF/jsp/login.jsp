<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<%@ include file="/WEB-INF/jsp/include.jsp" %>
<title>MyStuff - Login</title>
</head>

<body>
	<div id="wrap">
		
		<div id="header">			
			<%@ include file="/WEB-INF/jsp/header.jsp" %>
		</div> <!-- header -->
		
		<div  id="menu">
			<ul>
				<li id="current"><a href="home.htm">Home</a></li>
				<li><a href="media.htm">Media</a></li>
				<li><a href="friends.htm">Friends</a></li>
				<li><a href="account.htm">Account</a></li>
				<li><a href="support.htm">Support</a></li>
				<li class="last"><a href="about.htm">About</a></li>		
			</ul>
		</div> <!--  menu -->	
		
			
		<div id="content-wrap">
		
			<div id="sidebar">
			</div>	
		
			<div id="main">
				<h3>Login</h3> <br />
				<center>
				<table><tr>
					<form:form method="post" action="login.htm">			
					<p>			
					<form:label path="username">Username</form:label>
					<form:input path="username" type="text" size="30" />
					<form:label path="password">Password</form:label>
					<form:input path="password" type="password" size="30" /> <br />
					<a href="recoverPassword.htm">Forgot your password?</a> | <a href="register.htm">Register</a>
					<br />	<br />	
					<center><input class="button" value="          Login          " type="submit" /></center>
					</p>		
					</form:form>				
				</tr></table>
				</center>
			</div> <!--  main -->
	</div> <!-- content-wrap -->	
				
	<!--footer starts here-->
	<div id="footer">
		<%@ include file="/WEB-INF/jsp/footer.jsp" %>
	</div>	

</div>

</body>
</html>
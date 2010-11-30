<%@ include file="/WEB-INF/jsp/include.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<html>

<head>
<style type="text/css">
	<%@include file="/images/stylesheet.css" %>
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>MyStuff - Login</title>
	
</head>

<body>
<!-- wrap starts here -->
	<div id="wrap">
		
		<!--header -->
		<div id="header">			
				
			<h1 id="logo-text"><a href="home.html">MyStuff</a></h1>		
			<p id="slogan">Your one-stop shop for media information...</p>		
			
			<div id="header-links">
			<p>
				<a href="login.html">login</a> | 		
			</p>		
		</div>		
						
	</div>
	
	<!-- menu -->	
	<div  id="menu">
		<ul>
			<li id="current"><a href="home.html">Home</a></li>
			<li><a href="media.html">Media</a></li>
			<li><a href="friends.html">Friends</a></li>
			<li><a href="account.html">Account</a></li>
			<li><a href="support.html">Support</a></li>
			<li class="last"><a href="about.html">About</a></li>		
		</ul>
	</div>					
		
	<!-- content-wrap starts here -->
	<div id="content-wrap">
			
		<div id="sidebar">
				
			<ul class="sidemenu">
				${sidebar}						
			</ul>						
							
		</div>
			
		<div id="main">
			<h3>Login</h3> <br />
			<center>
			<table><tr>
				<form:form method="post" action="login.html">			
				<p>			
				<form:label path="username">Username</form:label>
				<form:input path="username" type="text" size="30" />
				<form:label path="password">Password</form:label>
				<form:input path="password" type="password" size="30" /> <br />
				<a href="#">Forgot your password?</a> | <a href="app/register">Register</a>
				<br />	<br />	
				<center><input class="button" value="          Login          " type="submit" /></center>
				</p>		
				</form:form>				
			</tr></table>
			</center>
		</div>
	
	<!-- content-wrap ends here -->	
	</div>
				
	<!--footer starts here-->
	<div id="footer">
		
		<p>
		&copy; 2010 <strong>University of British Columbia</strong> | 
		<b>CPSC 410</b> | 
		<b>template:</b> <a href="http://www.styleshout.com/">styleshout</a>
  			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  			</p>
			
	</div>	

<!-- wrap ends here -->
</div>

</body>
</html>
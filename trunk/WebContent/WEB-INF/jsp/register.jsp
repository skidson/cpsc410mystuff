<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<%@ include file="/WEB-INF/jsp/include.jsp" %>
<title>MyStuff - Register</title>
</head>

<body>
	<div id="wrap">
		
		<div id="header">			
			<h1 id="logo-text"><a href="home.htm">MyStuff</a></h1>
			<p id="slogan">Your one-stop shop for media information...</p>
		</div> <!-- header -->
		
		<div  id="menu">
			<ul>
				<li><a href="home.htm">Home</a></li>
				<li><a href="media.htm">Media</a></li>
				<li><a href="friends.htm">Friends</a></li>
				<li><a href="mailbox.htm">Mailbox</a></li>
				<li id="current"><a href="account.htm">Account</a></li>	
			</ul>
		</div>		
		
		<div id="content-wrap">
				
			<div id="main">
				<h3>Register</h3>
				<table><form method="POST" action="register.htm">
					<tr><td>First name: <font color="red">*</font></td><td><input type="text" size="30" name="in_firstName" /></td></tr>
					<tr><td>Last name: <font color="red">*</font></td><td><input type="text" size="30" name="in_lastName" /></td></tr>
					<tr><td>E-mail address: <font color="red">*</font></td><td><input type="text" size="30" name="in_email" /></td></tr>
					<tr><td>Username: <font color="red">*</font></td><td><input type="text" size="30" name="in_username" /></td></tr>
					<tr><td>Password: <font color="red">*</font></td><td><input type="password" size="30" name="in_password" /></td></tr>
					<tr><td>Confirm password: <font color="red">*</font></td><td><input type="password" size="30" name="in_confirmPassword" /></td></tr>
					<tr><td>Country: <font color="red">*</font></td><td><input type="text" size="30" name="in_country" /></td></tr>
					<tr><td><input class="button" value="          Create Account          " type="submit" /></td></tr>
				</form></table>
			</div> <!-- main -->
		
		</div> <!-- content-wrap -->
					
		<div id="footer">
			<%@ include file="/WEB-INF/jsp/footer.jsp" %>
		</div>	<!-- footer -->

	</div> <!-- wrap -->

</body>
</html>
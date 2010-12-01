<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<%@ include file="/WEB-INF/jsp/include.jsp" %>
<title>MyStuff - Home</title>
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
				<li id="current"><a href="account.htm">Account</a></li>	
			</ul>
		</div>		
		
		<div id="content-wrap">
		
			<div id="sidebar">
				<%@ include file="/WEB-INF/jsp/sidebar.jsp" %>
			</div> <!-- sidebar -->		
				
			<div id="main">
				<h3>Register</h3> <br />
				<table><p>
					<label>First name: <font color="red">*</font> <input type="text" size="30" name="in_firstName" /></label>
					<label>Last name: <font color="red">*</font> <input type="text" size="30" name="in_lastName" /></label>
					<label>E-mail address: <font color="red">*</font> <input type="text" size="30" name="in_email" /></label>
					<label>Username: <font color="red">*</font> <input type="text" size="30" name="in_username" /></label>
					<label>Password: <font color="red">*</font> <input type="text" size="30" name="in_password" /></label>
					<label>Country: <font color="red">*</font> <input type="text" size="30" name="in_country" /></label>
				</p></table>
			</div> <!-- main -->
		
		</div> <!-- content-wrap -->
					
		<div id="footer">
			<%@ include file="/WEB-INF/jsp/footer.jsp" %>
		</div>	<!-- footer -->

	</div> <!-- wrap -->

</body>
</html>
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
				<h2>Register</h2><br />
				<center><table>
					<h1><font color="green">Registration successful!</font></h1><br />
					<a href="login.jsp"><button>Proceed to login</button></a>
				</table></center>
			</div> <!-- main -->
		
		</div> <!-- content-wrap -->
					
		<div id="footer">
			<%@ include file="/WEB-INF/jsp/footer.jsp" %>
		</div>	<!-- footer -->

	</div> <!-- wrap -->

</body>
</html>
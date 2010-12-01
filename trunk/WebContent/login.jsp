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
				<c:if test="${not empty param.error}">
					<font color="red">
					Login error. <br />
					Reason : ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
					</font>
				</c:if>
				<table><tr>
					<form method="POST" action="<c:url value="/j_spring_security_check" />">
					<table>
					<tr>
					<td align="right">Username</td>
					<td><input type="text" name="j_username" /></td>
					</tr>
					<tr>
					<td align="right">Password</td>
					<td><input type="password" name="j_password" /></td>
					</tr>				
				<tr>
<td align="right">Remember me</td>
<td><input type="checkbox" name="_spring_security_remember_me" /></td>
</tr>
<tr>
<td colspan="2" align="right">
<input type="submit" value="Login" />
<input type="reset" value="Reset" />
</td>
</tr>
</table>
</form>
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
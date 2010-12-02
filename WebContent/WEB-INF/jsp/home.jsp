<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<%@ include file="/WEB-INF/jsp/include.jsp" %>
<title>MyStuff - Home</title>
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
				<li><a href="mailbox.htm">Mailbox</a></li>
				<li><a href="account.htm">Account</a></li>	
			</ul>
		</div>		
		
		<div id="content-wrap">
		
			<div id="sidebar">
				<%@ include file="/WEB-INF/jsp/sidebar.jsp" %>
			</div> <!-- sidebar -->		
				
			<div id="main">
				<h4>Home</h4>
				<br  />
				<center><b>${messageAlert}</b></center>
				<h2>News Feed</h2> 
				<c:forEach items="${eventList}" var="event">
					<p class="post-footer">${event.description}</p>
				</c:forEach>
			</div> <!-- main -->
		
		</div> <!-- content-wrap -->
					
		<div id="footer">
			<%@ include file="/WEB-INF/jsp/footer.jsp" %>
		</div>	<!-- footer -->

	</div> <!-- wrap -->

</body>
</html>
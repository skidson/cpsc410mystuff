<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<%@ include file="/WEB-INF/jsp/include.jsp" %>
<title>MyStuff - Search</title>
</head>

<body>
	<div id="wrap">
		
		<div id="header">			
			<%@ include file="/WEB-INF/jsp/header.jsp" %>
		</div> <!-- header -->
		
		<div  id="menu">
			<ul>
				<li><a href="home.htm">Home</a></li>
				<li id="current"><a href="media.htm">Media</a></li>
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
				<h3> Search Results</h3>
				<c:if test="${useResult == 0}" >
				<c:forEach items="${resultsList}" var="movie">
					<h2><a href="viewMedia.htm?itemID=${movie.itemID}"> ${movie.title} </a><div style="float:right">${movie.rating}/10</div></h2>
					<table><tr><td width="100px"><img src="${movie.image}" width="95%" height="10%"></td><td>${movie.genre}</td></tr></table>
					<p class="post-footer align-right">					
					<a href="#" class="readmore">Information</a>
					<a href="addMedia.htm?itemID=${movie.itemID}"><button>Add to Library</button></a>
					</p>
				</c:forEach>
				</c:if>
				<c:if test="${useResult == 1}" >
				<c:forEach items="${resultsList}" var="user">
					<h2><a href="profile.htm?userID=${user.userID}"> ${user.firstName} ${user.lastName } </a><div style="float:right"><a href="">Send Friend Request</a></div></h2>
				</c:forEach>
				</c:if>
			</div> <!-- main -->
		
		</div> <!-- content-wrap -->
					
		<div id="footer">
			<%@ include file="/WEB-INF/jsp/footer.jsp" %>
		</div>	<!-- footer -->

	</div> <!-- wrap -->

</body>
</html>
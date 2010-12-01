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
				<h3>Search</h3> <br />
				<table><tr><form method="POST" action="search.htm">
					<center><input type="text" size="40" name="searchQuery" />
					<select name="dropdown_media" size="1">
						<option value="movies">Movies</option>
						<option value="songs">Songs</option>
						<option value="users">Users</option>
					</select>
					<input class="button" value=" Search " type="submit" /></center>
				</form></tr></table>
				
				<c:forEach items="${resultsList}" var="movie">
					<h2>${movie.title}<div style="float:right">${movie.rating}/10</div></h2>
					<table><tr><td width="100px"><img src="${movie.image}" width="95%" height="10%"></td><td>${movie.genre}</td></tr></table>
					<p class="post-footer align-right">					
					<a href="#" class="readmore">Information</a>
					<a href="#" class="comments">Comments (7)</a>
					</p>
				</c:forEach>
				
			</div> <!-- main -->
		
		</div> <!-- content-wrap -->
					
		<div id="footer">
			<%@ include file="/WEB-INF/jsp/footer.jsp" %>
		</div>	<!-- footer -->

	</div> <!-- wrap -->

</body>
</html>
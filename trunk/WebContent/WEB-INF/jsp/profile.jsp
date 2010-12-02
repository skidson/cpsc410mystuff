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
				<li><a href="home.htm">Home</a></li>
				<li><a href="media.htm">Media</a></li>
				<li id="current"><a href="friends.htm">Friends</a></li>
				<li><a href="mailbox.htm">Mailbox</a></li>
				<li><a href="account.htm">Account</a></li>	
			</ul>
		</div>		
		
		<div id="content-wrap">
		
			<div id="sidebar">
				<%@ include file="/WEB-INF/jsp/sidebar.jsp" %>
			</div> <!-- sidebar -->		
				
			<div id="main">
				<h4>Welcome to ${person.username}'s Profile! </h4>
				<table><tr><td>Name : ${person.firstName} ${person.lastName}</td></tr>
				<tr><td> Country : ${person.country}</td></tr>
				</table>
				
				<c:forEach items="${user.friends}" var="friend">
					<c:choose>
					 <c:when test="${friend == person.userID}" >
						<td> You are friends with ${person.firstName} !</td>
						<c:forEach items="${fullMovieList}" var="movie">
						<h2><a href="viewMedia.htm?itemID=${movie.itemID}"> ${movie.title} </a><div style="float:right">${movie.rating}/10</div></h2>
						<table><tr><td width="100px"><img src="${movie.image}" width="95%" height="10%"></td><td>${movie.genre}</td></tr></table>
						<p class="post-footer align-right">					
						<a href="viewMedia.htm?itemID=${movie.itemID}" class="readmore">Information</a>
						<a href="addMedia.htm?itemID=${movie.itemID}"><button>Add to Library</button></a>
						</p>
					</c:forEach>
					</c:when>
					<c:otherwise>				
					<h2><a href="viewMedia.htm?itemID=${movie.itemID}"> ${movie.title} </a><div style="float:right">${movie.rating}/10</div></h2>
					<table><tr><td width="100px"><img src="${movie.image}" width="95%" height="10%"></td><td>${movie.genre}</td></tr></table>
					</c:otherwise>
					</c:choose>
				</c:forEach>
				
			</div> <!-- main -->
		
		</div> <!-- content-wrap -->
					
		<div id="footer">
			<%@ include file="/WEB-INF/jsp/footer.jsp" %>
		</div>	<!-- footer -->

	</div> <!-- wrap -->

</body>
</html>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<%@ include file="/WEB-INF/jsp/include.jsp" %>
<title>MyStuff - Media</title>
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
				<h4>Media</h4> <br />			
					<h2>${movie.title}<div style="float:right">${movie.rating}/10</div></h2>
					<table>
						<tr><td width="200px"><img src="${movie.image}" width="99%" height="20%"></td><td>${movie.genre}</td></tr>
						<tr><td colspan="2"><center>${trailer}</center></td></tr>
					</table>
					<p class="post-footer align-right">					
						<a href="addComment.htm?itemID=${movie.itemID}">Add Comment</a>
						<a href="addMedia.htm?itemID=${movie.itemID}"><button>Add to Library</button></a>
					</p>
					
					<c:forEach items="${comments}" var="comment">
					<h2><div style="float:right">${comment.authorName}</div></h2>
					<table><tr><td width="100px">${comment.text}</td></tr></table>
					<p class="post-footer align-right">					
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
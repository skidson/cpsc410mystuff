<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<%@ include file="/WEB-INF/jsp/include.jsp" %>
<title>MyStuff - Mailbox</title>
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
				<li><a href="friends.htm">Friends</a></li>
				<li id="current"><a href="mailbox.htm">Mailbox</a></li>
				<li><a href="account.htm">Account</a></li>
			</ul>
		</div>		
		
		<div id="content-wrap">
		
			<div id="sidebar">
				<%@ include file="/WEB-INF/jsp/sidebar.jsp" %>
			</div> <!-- sidebar -->
				
			<div id="main">
				<h4>Reply</h4> <br />
				<form method="POST" action="sendMessage.htm">
					<table>
						<div style="padding-left:50px"><font color="#808080">
							${message.text}
						</font></div>
						<tr><td colspan="2"><center><textarea name="in_text"></textarea></center></td></tr>
						<tr><td colspan="2"><center><input class="button" value="       Send       " type="submit" /></center></td></tr>
					</table>
				</form>
			</div> <!-- main -->
		
		</div> <!-- content-wrap -->
					
		<div id="footer">
			<%@ include file="/WEB-INF/jsp/footer.jsp" %>
		</div>	<!-- footer -->

	</div> <!-- wrap -->

</body>
</html>
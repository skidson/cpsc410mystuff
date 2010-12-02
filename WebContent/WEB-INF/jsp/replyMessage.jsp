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
				<h4>Mailbox</h4> <br />
				<table>
				<c:forEach items="${messageList}" var="message">
					<p class="post-footer"><a href="#" class="readmore">${message.subject}</a>
						<span style="float:right"><b>${message.senderName}</b></span>
					</p>
						<span style="float:right">
						<a href="replyMessage.htm?messageID=${message.messageID}"><button>Reply</button></a>
						<a href="deleteMessage.htm?messageID=${message.messageID}"><button>Delete</button></a>
						</span>
						<div style="padding-left:50px"><font color="#808080"><i>
							${message.text}
						</i></font></div>
				</c:forEach>
				</table>
			</div> <!-- main -->
		
		</div> <!-- content-wrap -->
					
		<div id="footer">
			<%@ include file="/WEB-INF/jsp/footer.jsp" %>
		</div>	<!-- footer -->

	</div> <!-- wrap -->

</body>
</html>
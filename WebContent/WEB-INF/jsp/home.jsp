<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<html>

<head>
<style type="text/css">
	<%@include file="/WEB-INF/images/stylesheet.css" %>
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">


<title>MyStuff - Home</title>
	
</head>

<body>
<!-- wrap starts here -->
<div id="wrap">
		
		<!--header -->
		<div id="header">			
				
			<h1 id="logo-text"><a href="index.html">MyStuff</a></h1>		
			<p id="slogan">Your one-stop shop for media information...</p>		
			
			<div id="header-links">
			<p><a href="#">logout</a></p>		
		</div>		
						
		</div>
		
		<!-- menu -->	
		<div  id="menu">
			<ul>
				<li id="current"><a href="/home.do">Home</a></li>
				<li><a href="index.html">Media</a></li>
				<li><a href="index.html">Friends</a></li>
				<li><a href="index.html">Account</a></li>
				<li><a href="index.html">Support</a></li>
				<li class="last"><a href="index.html">About</a></li>		
			</ul>
		</div>					
			
		<!-- content-wrap starts here -->
		<div id="content-wrap">
				
			<div id="sidebar">
			
				<h3>Search</h3>	
				<form action="#" class="searchform">
					<p>
					<input name="search_query" class="textbox" type="text" />
  					<input name="search" class="button" value="Search" type="submit" />
					</p>			
				</form>	
					
				<h3>Notices</h3>
				<ul class="sidemenu">				
					<li>9:45pm - Jeff likes men</li>
					<li>12:30am - Server Maintenance</li>				
				</ul>						
								
			</div>
				
			<div id="main">
				<h3>News Feed</h3> <br />
				
			</div>
		
		<!-- content-wrap ends here -->	
		</div>
					
		<!--footer starts here-->
		<div id="footer">
			
			<p>
			&copy; 2010 <strong>University of British Columbia</strong> | 
			<b>CPSC 410</b> | 
			<b>template:</b> <a href="http://www.styleshout.com/">styleshout</a>
   			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			
   			</p>
				
		</div>	

<!-- wrap ends here -->
</div>

</body>
</html>
Banelings
<% String Code;
   String Client_ID;
   String Client_Secret;
   String Access_Token;
   
Code = request.getParameter("code");
Client_ID = "107113259361459";
Client_Secret = "837fc885c421d59c0647e6ba1b26dc44";
Access_Token = request.getParameter("access_token");

	if ((request.getParameter("access_token") != null))
	    {
		out.print(Code);
		out.print(Client_ID);
		out.print(Client_Secret);
		out.print(Access_Token);
			
	    }
	 else if ((request.getParameter("code") != null))
   	 	{
		
		out.print(Code);
		out.print(Client_ID);
		out.print(Client_Secret);
		out.print(Access_Token);
		response.setStatus(301);
		response.setHeader( "Location", "https://graph.facebook.com/oauth/access_token?client_id=" + "107113259361459" +
									"&redirect_uri=http://localhost:8080/fuck/jsp/redirect.jsp?oauth_redirect&" +
		    						"client_secret=" + "837fc885c421d59c0647e6ba1b26dc44" +
		    						"&code=" + request.getParameter("code"));
		response.setHeader( "Connection", "close" );
		}
	
%>



<%//  JAVA:

//response.setStatus(301);
//response.setHeader( "Location", "http://www.google.com/" );
//response.setHeader( "Connection", "close" );
%>

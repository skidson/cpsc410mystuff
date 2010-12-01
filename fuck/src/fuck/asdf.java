package fuck;

import java.util.HashMap;
import java.lang.*;
import com.netflix.api.NetflixAPIException;
import com.netflix.api.NetflixAPIResponse;
import com.netflix.api.client.APIEndpoints;
import com.netflix.api.client.NetflixAPIClient;
public class asdf {
	
	public asdf(){		
	}
	
	public static void main(String[] args){
		String myConsumerKey = "gw84wgje7uxwd796njyzmqr5";
			String myConsumerSecret = "pWWcsY6xEF";
			System.out.println("MFER1");
		 NetflixAPIClient apiClient = new NetflixAPIClient(myConsumerKey, myConsumerSecret);
		 System.out.println("MFER2");
		 String uri = APIEndpoints.MOVIE_URI + "/512381";
		  String details = null;
		  try
		  {
			  System.out.println("MFER4 ur mom");
			  details = apiClient.makeConsumerSignedApiCall(uri, null, NetflixAPIClient.GET_METHOD_TYPE).getResponseBody();
			  System.out.println(details);
		  }
		  catch (Exception nae)
		  {
		    System.out.println("MFER");
		  }

	}
}

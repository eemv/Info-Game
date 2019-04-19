package aiss.model.resources;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.apache.commons.httpclient.HttpConnection;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpParams;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import aiss.model.igdb.Game;

public class IGDBResource {
	 private static final Logger log = Logger.getLogger(SpotifyResource.class.getName());

	    private final String userKey = "52d6ccf6c9252094bad3790904e8ad03";
	    private final String baseURL = "https://api-v3.igdb.com";
	    
	    
	    @SuppressWarnings("deprecation")
		public Game getGame(String query) {
	    	String urlGame = baseURL + "/game";
	    	
	    	
	    	
	    	DefaultHttpClient client = new DefaultHttpClient();
	    	
	    	HttpClient httpclient = HttpClient.newHttpClient();
	    	HttpPost httpPost = new HttpPost(urlGame);
	    	httpPost.addHeader("user-key", userKey);
	    	HttpParams params;
	    	params.setParameter("where name =", URLEncoder.encode(query, "UTF-8"));
	    	params.setParameter("fields", "*");
	    	httpPost.setParams((org.apache.http.params.HttpParams) params);
	    	HttpResponse response = (HttpResponse) client.execute(httpPost);

	    	response.get

	    	return 
	    }
}

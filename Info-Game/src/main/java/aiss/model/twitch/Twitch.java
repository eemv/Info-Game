package aiss.model.twitch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.net.URLEncoder;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;

public class Twitch implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String access_token;
	private String refresh_token;
	private String scope;
	private final String baseURL = "https://api.twitch.tv/kraken/";
	
	public Twitch(String string, String string2, String string3) throws IOException {
		this.access_token = string;
		this.refresh_token = string2;
		this.scope = string3;
	}
	public StreamSearch requestStreams(String query) throws IOException{
		String url = baseURL + "search/streams?query=" + URLEncoder.encode(query, "UTF-8")+"&limit=5";
		HttpClient client = HttpClientBuilder.create().build();
		HttpGet request = new HttpGet(url);

		// add request header
		request.addHeader("Client-ID", " 3u7g0x9c0bcoz644h5ryrjiqsqqgsf");
		request.addHeader("Authorization", " OAuth "+ access_token);
		HttpResponse response = client.execute(request);

		System.out.println("Response Code : "
		                + response.getStatusLine().getStatusCode());

		BufferedReader rd = new BufferedReader(
			new InputStreamReader(response.getEntity().getContent()));

		StringBuffer result = new StringBuffer();
		String line = "";
		while ((line = rd.readLine()) != null) {
			result.append(line);
		}
		String james = result.toString();
		System.out.println(james);
		ObjectMapper mapper = new ObjectMapper();
		mapper.setPropertyNamingStrategy(PropertyNamingStrategy.CAMEL_CASE_TO_LOWER_CASE_WITH_UNDERSCORES);
		StreamSearch tc = null;
		tc = mapper.readValue(james, StreamSearch.class);
		System.out.println(tc);
		return tc;
	}
	public TwitchChannel requestChannel(String token) throws IOException{
		String url = "https://api.twitch.tv/kraken/channel";
		HttpClient client = HttpClientBuilder.create().build();
		HttpGet request = new HttpGet(url);

		// add request header
		request.addHeader("Client-ID", " 3u7g0x9c0bcoz644h5ryrjiqsqqgsf");
		request.addHeader("Authorization", " OAuth "+token);
		HttpResponse response = client.execute(request);

		System.out.println("Response Code : "
		                + response.getStatusLine().getStatusCode());

		BufferedReader rd = new BufferedReader(
			new InputStreamReader(response.getEntity().getContent()));

		StringBuffer result = new StringBuffer();
		String line = "";
		while ((line = rd.readLine()) != null) {
			result.append(line);
		}
		String james = result.toString();
		System.out.println(james);
		ObjectMapper mapper = new ObjectMapper();
		mapper.setPropertyNamingStrategy(PropertyNamingStrategy.CAMEL_CASE_TO_LOWER_CASE_WITH_UNDERSCORES);
		TwitchChannel tc = null;
		tc = mapper.readValue(james, TwitchChannel.class);
		System.out.println(tc.getDisplayName());
		return tc;
	}

	public String getAccess_token(){
		return access_token;
	}
	
	public String getRefresh_token(){
		return refresh_token;
	}
	
	public String getScope(){
		return scope;
	}
	
	
	public void setAccess_token(String access_token){
		this.access_token = access_token;
	}
	
	public void setRefresh_token(String refresh_token){
		this.refresh_token = refresh_token;
	}
	
	public void setScope(String scope){
		this.scope = scope;
	}
	

}
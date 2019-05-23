package aiss.model.resources;

import java.io.IOException;
import java.util.logging.Logger;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.restlet.data.ChallengeResponse;
import org.restlet.data.ChallengeScheme;
import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;

import com.google.api.client.json.Json;

public class YoutubeRateResource {
	private static final Logger log = Logger.getLogger(YoutubeRateResource.class.getName());
	final String uriRate = "https://www.googleapis.com/youtube/v3/videos/rate";
	private final String access_token;
	
	public YoutubeRateResource(String access_token) {
		this.access_token=access_token;
	}
	
	public Boolean like(String videoId) throws ClientProtocolException, IOException {

		try {
			String uri = uriRate + "?id=" + videoId + "&rating=like";
	        CloseableHttpClient httpclient = HttpClients.createDefault();
			HttpPost httpPost = new HttpPost(uri);		
			httpPost.addHeader("Authorization", "Bearer " + access_token);
			httpPost.addHeader("Accept", "application/json");
			CloseableHttpResponse response2 = httpclient.execute(httpPost);
			log.warning(response2.toString());
			return true;
		} catch (ResourceException re) {
			log.warning(re.getMessage());
			return false;
		}
}
	public Boolean dislike(String videoId) throws ClientProtocolException, IOException {

		try {
			String uri = uriRate + "?id=" + videoId + "&rating=dislike";
	        CloseableHttpClient httpclient = HttpClients.createDefault();
			HttpPost httpPost = new HttpPost(uri);		
			httpPost.addHeader("Authorization", "Bearer " + access_token);
			httpPost.addHeader("Accept", "application/json");
			CloseableHttpResponse response2 = httpclient.execute(httpPost);
			log.warning(response2.toString());
			return true;
		} catch (ResourceException re) {
			log.warning(re.getMessage());
			return false;
		}
}
}

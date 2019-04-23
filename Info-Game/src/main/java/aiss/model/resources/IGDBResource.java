package aiss.model.resources;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.net.http.HttpClient;
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

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import aiss.model.igdb.Game;

public class IGDBResource {
	 private static final Logger log = Logger.getLogger(IGDBResource.class.getName());

	    private final String userKey = "52d6ccf6c9252094bad3790904e8ad03";
	    private final String baseURL = "https://api-v3.igdb.com";
	    
	    
	  
		public Game getGame(String query) throws UnirestException {
	    	
	    	HttpResponse<JsonNode> jsonResponse = Unirest.post("https://api-v3.igdb.com/games")
	    			  .header("user-key", userKey)
	    			  .header("Accept", "application/json")
	    			  .body("fields age_ratings,aggregated_rating,aggregated_rating_count,alternative_names,artworks,bundles,category,collection,cover,created_at,dlcs,expansions,external_games,first_release_date,follows,franchise,franchises,game_engines,game_modes,genres,hypes,involved_companies,keywords,multiplayer_modes,name,parent_game,platforms,player_perspectives,popularity,pulse_count,rating,rating_count,release_dates,screenshots,similar_games,slug,standalone_expansions,status,storyline,summary,tags,themes,time_to_beat,total_rating,total_rating_count,updated_at,url,version_parent,version_title,videos,websites;")
	    			  .asJson();
	    	jsonResponse.getBody().getClass().cast(Game.class);
	    	
//	    	DefaultHttpClient client = new DefaultHttpClient();
//	    	
//	    	HttpClient httpclient = HttpClient.newHttpClient();
//	    	HttpPost httpPost = new HttpPost(urlGame);
//	    	httpPost.addHeader("user-key", userKey);
//	    	HttpParams params;
//	    	params.setParameter("where name =", URLEncoder.encode(query, "UTF-8"));
//	    	params.setParameter("fields", "*");
//	    	httpPost.setParams((org.apache.http.params.HttpParams) params);
//	    	HttpResponse response = (HttpResponse) client.execute(httpPost);

	    	

	    	return  null; 
	    }
}

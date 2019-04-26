package aiss.model.resources;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;

import aiss.model.reddit.Post;
import aiss.model.reddit.RedditSearch;

public class RedditResource {
	private final String access_token;
	private static final String uriGames = "https://www.reddit.com/r/gaming/search.json";
	private static final Logger log = Logger.getLogger(RedditResource.class.getName());
	
	   public RedditResource(String access_token) {
	        this.access_token = access_token;
	    }

	public RedditSearch<Post> getPosts(String q) {
		String uri = "";
		RedditSearch<Post> result = null;
		ClientResource cr = null;
		
		try {
			String query = URLEncoder.encode(q, "UTF-8");
			uri = uriGames + "?q=" + query + "&limit=5&restrict_sr=true";
			log.log(Level.FINE, "Reddit search URI: " + uri);
		}catch(UnsupportedEncodingException e) {
			log.warning("Error encoding the query");
			log.warning(e.getMessage());
			return null;
		}
					
		try {
			cr = new ClientResource(uri);
			result = cr.get(RedditSearch.class);
		}catch (ResourceException e) {
			log.warning("Error retrieving posts from Reddit: " + cr.getResponse().getStatus());
		}
		
		return result;
}
}

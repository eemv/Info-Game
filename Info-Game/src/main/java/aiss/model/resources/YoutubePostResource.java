package aiss.model.resources;


import java.util.logging.Logger;

import org.restlet.data.ChallengeResponse;
import org.restlet.data.ChallengeScheme;
import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;

public class YoutubePostResource {
	
	private static final Logger log = Logger.getLogger(YoutubePostResource.class.getName());
	final String uriComment = "https://www.googleapis.com/youtube/v3/commentThreads";
	private final String access_token;
	
	public YoutubePostResource(String access_token) {
		this.access_token=access_token;
	}
	
	public String createComment(String comment, String videoId) {

		try {
			String uri = uriComment + "?part=snippet";
			log.warning("a");
			ClientResource cr = new ClientResource(uri);
			ChallengeResponse chr = new ChallengeResponse(ChallengeScheme.HTTP_OAUTH_BEARER);
	        chr.setRawValue(access_token);
	        cr.setChallengeResponse(chr);
	        String json = "{" + "snippet" + ":{"+"videoId" + ":" + videoId + ",topLevelComment" + ":{" 
	        + "snippet" + ":{" + "textOriginal" + ":" + comment + "}}}}";
	        log.warning(json);
	        cr.post(json, String.class);
	        
	        
			return comment;
		} catch (ResourceException re) {
			log.warning(re.getMessage());
			return "none";
		}
}
}

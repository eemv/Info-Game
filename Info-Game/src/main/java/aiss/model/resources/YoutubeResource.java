package aiss.model.resources;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.logging.Logger;

import org.restlet.data.ChallengeResponse;
import org.restlet.data.ChallengeScheme;
import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;

import aiss.model.youtube.VideoSearch;

public class YoutubeResource {
	private static final Logger log = Logger.getLogger(TwitchResource.class.getName());
	private final String access_token;
    private final String baseURL = "https://www.googleapis.com/youtube/v3";

    public YoutubeResource(String access_token) {
        this.access_token = access_token;
    }
    
 public VideoSearch searchVideos(String query) throws UnsupportedEncodingException {
    	String queryFormatted = "&q=" + URLEncoder.encode(query, "UTF-8");
    	String URLSearchVideos = baseURL + "/search?part=snippet&maxResults=3" + queryFormatted + "&type=video";
    	ClientResource cr = new ClientResource(URLSearchVideos);  
    	ChallengeResponse chr = new ChallengeResponse(ChallengeScheme.HTTP_OAUTH_BEARER);
        chr.setRawValue(access_token);
        cr.setChallengeResponse(chr);
    	
        VideoSearch videos = null;
        try {
            videos = cr.get(VideoSearch.class);
            return videos;

        } catch (ResourceException re) {
            log.warning("Error when retrieving YT videos: " + cr.getResponse().getStatus());
            log.warning(URLSearchVideos);
            return null;
        }
    	
    }
}

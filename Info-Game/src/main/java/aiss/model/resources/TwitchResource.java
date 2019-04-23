package aiss.model.resources;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;
import java.util.logging.Logger;

import org.restlet.data.ChallengeResponse;
import org.restlet.data.ChallengeScheme;
import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;

import aiss.model.spotify.Playlists;
import aiss.model.twitch.Stream;
import aiss.model.twitch.StreamSearch;

public class TwitchResource {
	private static final Logger log = Logger.getLogger(TwitchResource.class.getName());
	private final String access_token;
    private final String baseURL = "https://api.twitch.tv/kraken/";

    public TwitchResource(String access_token) {
        this.access_token = access_token;
    }
    
 public StreamSearch searchStreams(String query) throws UnsupportedEncodingException {
    	
    	String queryFormatted = "?game=" + URLEncoder.encode(query, "UTF-8");
    	String URLSearchStreams = baseURL + "/search/streams" + queryFormatted + "?limit=5";
    	ClientResource cr = new ClientResource(URLSearchStreams);  
    	ChallengeResponse chr = new ChallengeResponse(ChallengeScheme.HTTP_OAUTH_BEARER);
        chr.setRawValue(access_token);
        cr.setChallengeResponse(chr);
    	
        StreamSearch streams = null;
        try {
            streams = cr.get(StreamSearch.class);
            return streams;

        } catch (ResourceException re) {
            log.warning("Error when retrieving Twitch streams: " + cr.getResponse().getStatus());
            log.warning(URLSearchStreams);
            return null;
        }
    	
    }
}

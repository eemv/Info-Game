package aiss.model.resources;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;
import java.util.logging.Logger;

import org.restlet.data.ChallengeResponse;
import org.restlet.data.ChallengeScheme;
import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;

import aiss.model.twitch.Game;
import aiss.model.twitch.GameSearch;
import aiss.model.twitch.StreamSearch;

public class TwitchResource {
	private static final Logger log = Logger.getLogger(TwitchResource.class.getName());
	private final String access_token;
	private static final String TWITCH_API_KEY = "3u7g0x9c0bcoz644h5ryrjiqsqqgsf";
    private final String baseURL = "https://api.twitch.tv/kraken/";
    
//    public TwitchResource() {
//       
//    }
    
    public TwitchResource(String access_token) {
        this.access_token = access_token;
    }
    public StreamSearch searchStreams2(String query) throws UnsupportedEncodingException {
    	String uri = baseURL + "search/streams?query=" + URLEncoder.encode(query, "UTF-8");
    	ClientResource cr= new ClientResource(uri);
    	cr.setAttribute("Client-ID", TWITCH_API_KEY);
    	StreamSearch result = cr.get(StreamSearch.class);
    	return result;
    }
	

 public StreamSearch searchStreams(String query) throws UnsupportedEncodingException {
    	
	 
	 //Necesitamos tomar la ID del juego antes de pedir sus streams
    	String queryFormatted = "?name=" + URLEncoder.encode(query, "UTF-8");
    	String URLSearchGame = baseURL + "/games" + queryFormatted;
    	
    	ClientResource cr = new ClientResource(URLSearchGame);  
    	ChallengeResponse chr = new ChallengeResponse(ChallengeScheme.HTTP_OAUTH_BEARER);
        chr.setRawValue(access_token);
        cr.setChallengeResponse(chr);
    	
        GameSearch games = null;
        try {
            games = cr.get(GameSearch.class);
            List<Game> lista = games.getData();
            Game juego = lista.get(0);
            String URLSearchStreams = baseURL + "/streams?game_id=" + juego.getId() + "?limit=5";
            ClientResource cr1 = new ClientResource(URLSearchStreams);  
        	ChallengeResponse chr1 = new ChallengeResponse(ChallengeScheme.HTTP_OAUTH_BEARER);
            chr1.setRawValue(access_token);
            cr1.setChallengeResponse(chr1);
            StreamSearch streams = cr1.get(StreamSearch.class);
            return streams;

        } catch (ResourceException re) {
            log.warning("Error when retrieving Twitch streams: " + cr.getResponse().getStatus());
            log.warning(URLSearchGame);
            return null;
        }
    	
    }
}

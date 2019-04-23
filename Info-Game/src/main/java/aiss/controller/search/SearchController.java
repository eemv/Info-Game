package aiss.controller.search;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aiss.model.resources.SpotifyResource;
import aiss.model.resources.TwitchResource;
import aiss.model.spotify.Playlists;
import aiss.model.twitch.StreamSearch;



/**
 * Servlet implementation class SearchController
 */
public class SearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private static final Logger log = Logger.getLogger(SearchController.class.getName());
	 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchController() {
        super();
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		
		String query = request.getParameter("searchQuery");
		RequestDispatcher rd = null;
		

				log.log(Level.FINE, "Searching for Spotify playlists that contain " + query);
				String accessToken = (String) request.getSession().getAttribute("Spotify-token");
//				String accessTokenTW = (String) request.getSession().getAttribute("Twitch-token");
				
		        if(query != null  && query != "") {
		        	if (accessToken != null && !"".equals(accessToken)) {
		        		log.log(Level.FINE, "Searching for Spotify playlists that containn " + query);
		        		SpotifyResource spResource = new SpotifyResource(accessToken);
//		        		TwitchResource twResource = new TwitchResource(accessTokenTW);
		        		Playlists spotifyResults = spResource.searchPlaylist(query);
//		        		StreamSearch twitchResults = twResource.searchStreams(query);
		        		
		        		if (spotifyResults!=null){
		        			log.log(Level.FINE, "La playlist no es null");
		  
		        			rd = request.getRequestDispatcher("/success.jsp");
		        			request.setAttribute("playlists", spotifyResults.getPlaylists().getItems());
		        		} else {
		        			log.log(Level.SEVERE, "Spotify object: " + spotifyResults);
		        			rd = request.getRequestDispatcher("/error.jsp");
		        		}
//		        		if (twitchResults!=null){
//		        			log.log(Level.FINE, "Los streams no son null");
//		        			rd = request.getRequestDispatcher("/success.jsp");
//		        			request.setAttribute("streams", twitchResults.getStreams());
//		        		} else {
//		        			log.log(Level.SEVERE, "Twitch object: " + twitchResults);
//		        			rd = request.getRequestDispatcher("/error.jsp");
//		        		}
//		        		 "Spotify": {
//		        	        "tokenUrl": "https://accounts.spotify.com/api/token ",
//		        	        "clientId": "7b3a8ef6db4b47d59177f2d406e9be9e",
//		        	        "clientSecret": "b28a27b870834929926d190128178289",
//		        	        "authorizationFormUrl": "https://accounts.spotify.com/authorize",
//		        	        "scopes": ["playlist-read-private","playlist-modify-private","playlist-modify-public"]
//		        	    },
//		        	    "Twitch": {
//		        	        "tokenUrl": "https://api.twitch.tv/kraken/",
//		        	        "clientId": "3u7g0x9c0bcoz644h5ryrjiqsqqgsf",
//		        	        "clientSecret": "6z7xayco6bzhpeow9f13sr627mquyz",
//		        	        "authorizationFormUrl": "https://id.twitch.tv/oauth2/validate",
//		        	        "scopes": ["channel_stream","channel_subscriptions","channel_read"]
//		        	    },"IGDB": {
//		        	        "tokenUrl": "https://www.igdb.com/oauth/token.json",
//		        	        "clientId": "",
//		        	        "clientSecret": "",
//		        	        "authorizationFormUrl": "https://www.igdb.com/oauth/authorize",
//		        	        "scopes": "public"
//		        	    }
		        		rd.forward(request, response);

		        	} else {
		        		log.info("Trying to access Spotify without an access token, redirecting to OAuth servlet");
		        		request.getRequestDispatcher("/AuthController/Spotify").forward(request, response);
		        	}
		        	
		        }else {
		        	request.getRequestDispatcher("/success.jsp");
		        }
		    
		    }
				
				
		
//		// Search for movies in OMDb
//		log.log(Level.FINE, "Searching for OMDb movies that contain " + query);
//		OMDbResource omdb = new OMDbResource();
//		MovieSearch omdbResults = omdb.getMovies(query);
//
//		log.log(Level.FINE, "Searching for flickr photos that contain " + query);
//		FlickrResource flickr = new FlickrResource();
//		PhotoSearch flickrResults = flickr.getFlickrPhotos(query);
//		
//		if (omdbResults!=null && flickrResults!=null ){
//			rd = request.getRequestDispatcher("/success.jsp");
//			request.setAttribute("movies", omdbResults.getSearch());
//			request.setAttribute("photos", flickrResults.getPhotos());	
//		} else {
//			log.log(Level.SEVERE, "OMDb object: " + omdbResults);
//			rd = request.getRequestDispatcher("/error.jsp");
//		}
//		rd.forward(request, response);
//	}
		
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
}

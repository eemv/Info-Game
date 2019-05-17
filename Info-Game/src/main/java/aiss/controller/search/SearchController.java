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
import aiss.model.resources.WikipediaResource;
import aiss.model.resources.YoutubeResource;
import aiss.model.spotify.Playlists;
import aiss.model.twitch.StreamSearch;
import aiss.model.twitch.Twitch;
import aiss.model.wikipedia.WikipediaTitle;
import aiss.model.youtube.VideoSearch;



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
		
		 
				Twitch twitch =  (Twitch) request.getSession().getAttribute("twitch");
				String accessToken = (String) request.getSession().getAttribute("Spotify-token");
				String accessTokenTW = twitch.getAccess_token();
				String accessTokenYT = (String) request.getSession().getAttribute("Youtube-token");
				
				log.log(Level.FINE, accessToken);
				log.log(Level.FINE, accessTokenTW);
				log.log(Level.FINE, accessTokenYT);
		        if(query != null  && query != "") {
		        	
		        		log.log(Level.FINE, "Searching for Spotify playlists that containn " + query);
		        		SpotifyResource spResource = new SpotifyResource(accessToken);
		        	
		        		Playlists spotifyResults = spResource.searchPlaylist(query);
		        				        		
		        		if (spotifyResults!=null){
		        			log.log(Level.FINE, "La playlist no es null");
		  
		        			rd = request.getRequestDispatcher("/success.jsp");
		        			request.setAttribute("playlists", spotifyResults.getPlaylists().getItems());
		        		} else {
		        			log.log(Level.SEVERE, "Spotify object: " + spotifyResults);
		        			rd = request.getRequestDispatcher("/error.jsp");
		        		}
		        		
		        		if (accessTokenTW != null && !"".equals(accessTokenTW)) {
		        		
		        		StreamSearch s=twitch.requestStreams(query);
		        		
		        		if (s!=null){
			        		log.log(Level.FINE, "Los streams no es null");
			  
			        		rd = request.getRequestDispatcher("/success.jsp");
			        		request.setAttribute("streams", s.getStreams());
			        	} else {
			        		log.log(Level.SEVERE, "Twitch object: " + s);
			        		rd = request.getRequestDispatcher("/error.jsp");
			        	}
		        		
		        		log.log(Level.FINE, "Buscando información del videojuego " + query);
			    		WikipediaResource wiki = new WikipediaResource();
			    		WikipediaTitle wikiResults = wiki.getWiki(query);
			    		
			    		if (wikiResults!=null){
			    			log.log(Level.FINE, "La informacion no es null " );
			    			rd = request.getRequestDispatcher("/success.jsp");
			    			request.setAttribute("wiki",aux(wikiResults.getParse().getWikitext().getT()));
			    			
			    		} else {
			    			log.log(Level.SEVERE, "Wiki objects: " + wikiResults);
			    			rd = request.getRequestDispatcher("/error.jsp");
			    }
		        	
		           	if (accessTokenYT != null && !"".equals(accessTokenYT)) {
		        		log.log(Level.FINE, "Searching for Youtube videos that containn " + query);
		        		YoutubeResource ytResource = new YoutubeResource(accessTokenYT);
		        	
		        		VideoSearch ytResults = ytResource.searchVideos(query);
		        				        		
		        		if (ytResults!=null){
		        			log.log(Level.FINE, "Los videos no es null");
		  
		        			rd = request.getRequestDispatcher("/success.jsp");
		        			request.setAttribute("videos", ytResults.getItems());
		        		} else {
		        			log.log(Level.SEVERE, "YT object: " + ytResults);
		        			rd = request.getRequestDispatcher("/error.jsp");
		        		}
		        		
		        	
		        }else {
		        	request.getRequestDispatcher("/success.jsp");
		        }
		        	}	
		     }
		        	rd.forward(request, response);
		 }
	       	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	private String aux(String s) {
		String[] trozos=s.split("es un", 2);
		trozos[1]=trozos[1].replace("[", "");
		trozos[1]=trozos[1].replace("]", "");
		while(trozos[1].contains("<ref") && trozos[1].contains("</ref>")) {
			String[] aux=trozos[1].split("<ref", 2);
			String[] aux2=aux[1].split("</ref>", 2);
			trozos[1]=aux[0].concat(aux2[1]);
		}
		trozos[1]=trozos[1].replace("{{", "");
		trozos[1]=trozos[1].replace("}}", "");
		String res=trozos[1].substring(0, 1000);
		res=res.concat("...");
		String r = res.substring(0, 1).toUpperCase();
		res=res.concat(r);
		return res;
	}
}

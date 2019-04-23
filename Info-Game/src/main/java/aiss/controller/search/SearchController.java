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
import aiss.model.spotify.Playlists;



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
		        
				
		        if(query != null  && query != "") {
		        	if (accessToken != null && !"".equals(accessToken)) {

		        		SpotifyResource spResource = new SpotifyResource(accessToken);
		        		Playlists spotifyResults = spResource.searchPlaylist(query);
		        		if (spotifyResults!=null){
		        			rd = request.getRequestDispatcher("/success.jsp");
		        			request.setAttribute("playlists", spotifyResults.getItems());
		        		} else {
		        			log.log(Level.SEVERE, "Spotify object: " + spotifyResults);
		        			rd = request.getRequestDispatcher("/error.jsp");
		        		}
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

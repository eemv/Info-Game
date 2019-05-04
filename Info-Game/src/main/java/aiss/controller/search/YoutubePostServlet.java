package aiss.controller.search;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aiss.model.resources.YoutubePostResource;

public class YoutubePostServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	private static final Logger log = Logger.getLogger(YoutubePostServlet.class.getName());
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		doGet(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String videoId = request.getParameter("videoId");
		String comment = request.getParameter("comment");
		String accessTokenYT = (String) request.getSession().getAttribute("Youtube-token");
				
		// Add song to playlist
		YoutubePostResource a = new YoutubePostResource(accessTokenYT);
		if(a.createComment(comment,videoId)!=null);
		boolean success=true;
		
		if (success) {
			request.setAttribute("message", "Comment added successfully");
			log.log(Level.FINE, "Todo bien");
		}
		else {
			request.setAttribute("message", "The comment could not be added");
			log.log(Level.FINE, "Todo mal");
		}
		
		request.getRequestDispatcher("/login.jsp").forward(request, response);

	}
}

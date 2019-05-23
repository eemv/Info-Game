package aiss.controller.search;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aiss.model.resources.YoutubeRateResource;

public class YoutubeRateServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	private static final Logger log = Logger.getLogger(YoutubeRateServlet.class.getName());
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String videoId = request.getParameter("videoId");
		String likedislike = request.getParameter("likedislike");
		String accessTokenYT = (String) request.getSession().getAttribute("Youtube-token");
				
		YoutubeRateResource a = new YoutubeRateResource(accessTokenYT);
		boolean success = false;
		log.log(Level.WARNING, likedislike);
		if(likedislike.equals("like")) {
		log.log(Level.WARNING, "hola");
		if(a.like(videoId)==true) {
			log.log(Level.WARNING, "hola2");
		success=true;
		}
		if (success) {
			request.setAttribute("message", "Like realizado");
			log.log(Level.FINE, "Todo bien");
		}
		else {
			request.setAttribute("message", "Like fallido");
			log.log(Level.FINE, "Todo mal");
			request.getRequestDispatcher("/error.jsp").forward(request, response);
		}
		}else if (likedislike.equals("dislike")) {
			log.log(Level.WARNING, "adios");
			if(a.dislike(videoId)==true) {
				success=true;
				}
				if (success) {
					request.setAttribute("message", "Dislike realizado");
					log.log(Level.FINE, "Todo bien");
					request.getRequestDispatcher("/login.jsp").forward(request, response);
				}
				else {
					request.setAttribute("message", "Dislike fallido");
					log.log(Level.FINE, "Todo mal");
					request.getRequestDispatcher("/error.jsp").forward(request, response);
				}
				
		}
		request.getRequestDispatcher("/login.jsp").forward(request, response);
	}
}

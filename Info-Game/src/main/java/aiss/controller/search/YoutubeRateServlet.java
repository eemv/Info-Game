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
		String accessTokenYT = (String) request.getSession().getAttribute("Youtube-token");
				
		YoutubeRateResource a = new YoutubeRateResource(accessTokenYT);
		if(a.like(videoId)==true);
		boolean success=true;
		
		if (success) {
			request.setAttribute("message", "Like realizado");
			log.log(Level.FINE, "Todo bien");
		}
		else {
			request.setAttribute("message", "Like fallido");
			log.log(Level.FINE, "Todo mal");
		}
		
		request.getRequestDispatcher("/login.jsp").forward(request, response);

	}
}

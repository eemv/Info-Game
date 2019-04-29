package aiss.controller.search;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TwitchLogInServlet
 */
public class TwitchLogInServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String redirectURL = "https://api.twitch.tv/kraken/oauth2/authorize?response_type=code&client_id=3u7g0x9c0bcoz644h5ryrjiqsqqgsf&redirect_uri=http://info-game-mashup.appspot.com/TwitchCallback&scope=channel_editor+channel_read&state=200";
		response.sendRedirect(redirectURL);
	}

}
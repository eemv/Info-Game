package resources;

import static org.junit.Assert.assertNotNull;

import java.io.UnsupportedEncodingException;
import java.util.logging.Level;

import javax.servlet.http.HttpServletRequest;

import org.junit.Test;

import aiss.model.resources.SpotifyResource;
import aiss.model.spotify.Playlists;

public class SpotifyResourceTest {
	@Test
	public void testSpotify(HttpServletRequest request) throws UnsupportedEncodingException {
		
	String accessToken = "BQBeh5NdyHfoRWV0C7x0123IB";
	String query = "Doom";
	SpotifyResource spResource = new SpotifyResource(accessToken);
	
	Playlists spotifyResults = spResource.searchPlaylist(query);
	assertNotNull("noseque", spotifyResults);
	}
}

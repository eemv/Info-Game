package resources;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.UnsupportedEncodingException;
import java.util.logging.Level;

import javax.servlet.http.HttpServletRequest;

import org.junit.Test;

import aiss.model.resources.SpotifyResource;
import aiss.model.spotify.Playlists;

public class SpotifyResourceTest {
	@Test
	public void testSpotify() throws UnsupportedEncodingException {
		
	String accessToken = "";
	String query = "Doom";
	SpotifyResource spResource = new SpotifyResource(accessToken);
	
	Playlists spotifyResults = spResource.searchPlaylist(query);
	assertNotNull("noseque", spotifyResults);
	
	}
	
	@Test
	public void testSpotify2() throws UnsupportedEncodingException {
		
	String accessToken = "";
	String query = "Doom";
	SpotifyResource spResource = new SpotifyResource(accessToken);
	
	Playlists spotifyResults = spResource.searchPlaylist(query);
	assertTrue("La busqueda esta vacia", !(spotifyResults.getPlaylists().getItems().isEmpty()));
	}
}

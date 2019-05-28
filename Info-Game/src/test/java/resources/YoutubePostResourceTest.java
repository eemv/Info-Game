package resources;

import static org.junit.Assert.assertNotNull;

import java.io.UnsupportedEncodingException;

import org.junit.Test;

import aiss.model.resources.YoutubeResource;
import aiss.model.youtube.VideoSearch;

public class YoutubePostResourceTest {
	@Test
	public void testYoutube() throws UnsupportedEncodingException {
		
	String accessToken = "";
	String query = "Comentario";
	YoutubeResource ytResource = new YoutubeResource(accessToken);
	
	VideoSearch ytResults = ytResource.searchVideos(query);
	assertNotNull("noseque", ytResults);
	}
}

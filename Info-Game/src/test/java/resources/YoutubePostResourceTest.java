package resources;

import static org.junit.Assert.assertNotNull;

import java.io.UnsupportedEncodingException;

import org.junit.Test;

import aiss.model.resources.YoutubeResource;
import aiss.model.youtube.VideoSearch;

public class YoutubePostResourceTest {
	@Test
	public void testYoutube() throws UnsupportedEncodingException {
		
	String accessToken = "ya29.GlsMB9Ke9wbmdq9DBf0J0k6Wou8et3EdjDCvSY-jT_j0EbiYVSo_EV4hGFkGnJB3blRuo-O4uHogi0BGHVlFTJdvb5IDlqnd0-PJnqN_NfXuqBozA7tlbxKoZ5ZR";
	String query = "Comentario";
	YoutubeResource ytResource = new YoutubeResource(accessToken);
	
	VideoSearch ytResults = ytResource.searchVideos(query);
	assertNotNull("noseque", ytResults);
	}
}

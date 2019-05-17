package resources;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.UnsupportedEncodingException;

import org.junit.Test;

import aiss.model.resources.YoutubeResource;
import aiss.model.youtube.VideoSearch;

public class YoutubeResourceTest {
	@Test
	public void testYoutube() throws UnsupportedEncodingException {
		
	String accessToken = "ya29.GlsMB6gkp18-29JqtialLj338NrmTOHtuCiE-VNcf9jUvf_eq4b_SK1K8R5LsDYHG61YdHZYU9bXscweD8zI533SkQ2s619LopsPDGAbE2ylalllIjs7ZFIHIvP4";
	String query = "Doom";
	YoutubeResource ytResource = new YoutubeResource(accessToken);
	
	VideoSearch ytResults = ytResource.searchVideos(query);
	assertNotNull("noseque", ytResults);
	}
	@Test
	public void testYoutube2() throws UnsupportedEncodingException {
		
	String accessToken = "ya29.GlsMB6gkp18-29JqtialLj338NrmTOHtuCiE-VNcf9jUvf_eq4b_SK1K8R5LsDYHG61YdHZYU9bXscweD8zI533SkQ2s619LopsPDGAbE2ylalllIjs7ZFIHIvP4";
	String query = "Doom";
	YoutubeResource ytResource = new YoutubeResource(accessToken);
	
	VideoSearch ytResults = ytResource.searchVideos(query);
	assertTrue("La busqueda esta vacia", !(ytResults.getItems().isEmpty()));	}
}

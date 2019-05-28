package resources;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Test;

import aiss.model.resources.Twitch;
import aiss.model.twitch.StreamSearch;

public class TwitchTest {
	@Test
	public void testTwitch() throws IOException {
		Twitch twitch = new Twitch(""
				, "", "channel_read");
		StreamSearch s=twitch.requestStreams("Doom");
		assertNotNull("La busqueda retorno null", s );
	}
	@Test
	public void testTwitch2() throws IOException {
		Twitch twitch = new Twitch(""
				, "", "channel_read");
		StreamSearch s=twitch.requestStreams("Doom");
		assertTrue("La busqueda esta vacia", !(s.getStreams().isEmpty()));
		
	}
}

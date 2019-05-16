package resources;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;

import org.junit.Test;

import aiss.model.resources.WikipediaResource;
import aiss.model.wikipedia.WikipediaTitle;

public class WikipediaResourceTest {
	final String query = "Doom";
	
	@Test
	public void testWikipedia() throws UnsupportedEncodingException {
		WikipediaResource wr = new WikipediaResource();
		WikipediaTitle wikiResults = wr.getWiki(query);
		assertNotNull("La busqueda retorno null", wikiResults);
	}
	@Test
	public void testWikipedia2() throws UnsupportedEncodingException {
		WikipediaResource wr = new WikipediaResource();
		WikipediaTitle wikiResults = wr.getWiki(query);
		assertNotEquals("La busqueda esta vacia", 0, wikiResults.toString().length());
	}
}
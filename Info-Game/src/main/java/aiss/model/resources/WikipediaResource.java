package aiss.model.resources;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;

import aiss.model.wikipedia.SearchWikipedia;
import aiss.model.wikipedia.WikipediaTitle;

public class WikipediaResource {
	
	private static final String URL_SEARCH =  "https://es.wikipedia.org/w/api.php?action=query&list=search&srsearch=";
	
	public WikipediaTitle getWiki(String query) throws UnsupportedEncodingException {
		ClientResource cr = null;
		ClientResource cr2 = null;
		SearchWikipedia m = null;
		WikipediaTitle res = null;
		try {
			cr = new ClientResource(URL_SEARCH+URLEncoder.encode(query, "UTF-8")+"&utf8=&format=json");
			m = cr.get(SearchWikipedia.class);
			String primerID=m.getQuery().getSearch().get(0).getTitle();
			cr2 = new ClientResource("https://es.wikipedia.org/w/api.php?action=parse&format=json&page=" + primerID + "&prop=wikitext");
			res= cr2.get(WikipediaTitle.class);
		}catch (ResourceException e) {
			System.err.println("Error al querer obtener la información: " + cr.getResponse().getStatus());
		}
		return res;
	}
}
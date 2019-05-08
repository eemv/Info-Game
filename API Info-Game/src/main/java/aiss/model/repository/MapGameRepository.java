package aiss.model.repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import aiss.model.Game;
import aiss.model.resources.SpotifyResource;
import aiss.model.spotify.SpotifySearch;

public class MapGameRepository implements GameRepository{

	//Map<String, Playlist> playlistMap;
	Map<String, Game> gameMap;
	private static MapGameRepository instance=null;
	//private int index=0;			// Index to create playlists and songs' identifiers.
	private final String access_token = "";
	
	public static MapGameRepository getInstance() {
		
		if (instance==null) {
			instance = new MapGameRepository();
			instance.init();
		}
		
		return instance;
	}
	
public void init() {

//		playlistMap = new HashMap<String,Playlist>();
//		gameMap = new HashMap<String,Game>(); 
//		SpotifyResource  dsPlaylist = new SpotifyResource(access_token);
		
		// Create games
		Game DarkSouls = new Game();
		DarkSouls.setTitle("DarkSouls");
		List<String> DSplaylist = new ArrayList<String>();
		DSplaylist.add("Dark Souls 3 Soundtrack");
		DSplaylist.add("Dark Souls Trilogy Soundtrack");
		DSplaylist.add("Dark Souls OST");
		//DarkSouls.setPlaylists(dsPlaylist.searchPlaylist("DarkSouls"));
		DarkSouls.setPlaylists(DSplaylist);
		List<String> DSdirectos = new ArrayList<String>();
		DSdirectos.add("http://www.twitch.tv/onty");
		DSdirectos.add("http://www.twitch.tv/powerBazinga");
		DSdirectos.add("http://www.twitch.tv/darklordsen");
		DarkSouls.setDirectos(DSdirectos);
		List<String> DSvideos = new ArrayList<String>();
		DSvideos.add("Why is Dark Souls 1 A Masterpiece?!");
		DSvideos.add("Dark Souls Part 1");
		DSvideos.add("Dark Souls Chaos Randomizer");
		DarkSouls.setVideos(DSvideos );
		DarkSouls.setDescripcion("Es un videojuego de rol de acción, desarrollado por la empresa "
				+ "From Software para las plataformas PlayStation 3, Xbox 360 y Microsoft Windows,"
				+ " distribuido por Namco Bandai Games. Anteriormente conocido como Project Souls,"
				+ " es el segundo videojuego de la serie Souls.");
		addGame(DarkSouls);
	}

	public void addGame(Game g) {
		String title = g.getTitle();	
		gameMap.put(title,g);
	}

	public Collection<Game> getAllGames() {
		return gameMap.values();
	}

	public Game getGame(String gameTitle) {
		return gameMap.get(gameTitle);
	}

	public void updateGame(Game g) {
		Game game = gameMap.get(g.getTitle());
		game.setTitle(g.getTitle());
		game.setPlaylists(g.getPlaylists());
		game.setDirectos(g.getDirectos());
		game.setVideos(g.getVideos());
		game.setDescripcion(g.getDescripcion());
		gameMap.put(g.getTitle(),g);
		
	}

	public void deleteGame(String gameTitle) {
		gameMap.remove(gameTitle);
		
	}

	}

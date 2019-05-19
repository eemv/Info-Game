package aiss.model.repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import aiss.model.Game;

public class MapGameRepository implements GameRepository{

	Map<String, Game> gameMap;
	private static MapGameRepository instance=null;
	
	public static MapGameRepository getInstance() {
		
		if (instance==null) {
			instance = new MapGameRepository();
			instance.init();
		}
		
		return instance;
	}
	
public void init() {
		
		// Create games
	Game DarkSouls = new Game();
	DarkSouls.setTitle("DarkSouls");
	List<String> DSplaylist = new ArrayList<String>();
	DSplaylist.add("Dark Souls 3 Soundtrack");
	DSplaylist.add("Dark Souls Trilogy Soundtrack");
	DSplaylist.add("Dark Souls OST");
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
	
	Game Fifa = new Game();
	Fifa.setTitle("FIFA 2020");
	List<String> FIFAplaylist = new ArrayList<String>();
	DSplaylist.add("FIFA Soundtrack");
	DSplaylist.add("FIFA 2020 Soundtrack");
	DSplaylist.add("FIFA BEST SONGS");
	Fifa.setPlaylists(FIFAplaylist);
	List<String> FIFAdirectos = new ArrayList<String>();
	DSdirectos.add("http://www.twitch.tv/DjMario");
	DSdirectos.add("http://www.twitch.tv/streamerFIFA");
	DSdirectos.add("http://www.twitch.tv/EA");
	Fifa.setDirectos(FIFAdirectos);
	List<String> FIFAvideos = new ArrayList<String>();
	DSvideos.add("Fifa Liga con el Rayo Vallecano");
	DSvideos.add("El mejor delantero centro del juego");
	DSvideos.add("Abro 100 sobres y pasa esto | FIFA");
	Fifa.setVideos(FIFAvideos );
	Fifa.setDescripcion("FIFA es una saga de videojuegos de fútbol publicados anualmente por Electronic Arts "
			+ "bajo el sello de EA Sports. Cuando la saga comenzó a finales de 1993 se destacó por ser "
			+ "el primero en tener una licencia oficial de la FIFA."
			+ " Las últimas ediciones de la saga contienen muchas licencias exclusivas y los equipos de ligas"
			+ " de todo el mundo, como la Premier League y la Football League inglesa, "
			+ "Serie A italiana, Bundesliga alemana, La Liga Primera División de España, "
			+ "Selecciones Nacionales, entre otras ligas más que han ido agregando a lo largo de "
			+ "estos últimos años, lo que permite el uso real de los estadios, cánticos del público,"
			+ " nombres reales de los jugadores y sus semejanzas en cómo juegan dentro del campo, etc. ");
	addGame(Fifa);
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

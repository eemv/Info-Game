package aiss.api.resources;

import java.util.Collection;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import aiss.model.Game;
import aiss.model.repository.GameRepository;
import aiss.model.repository.MapGameRepository;

@Path("/games")
public class GameResource {

	public static GameResource _instance=null;
	GameRepository repository;
	
	private GameResource(){
		repository=MapGameRepository.getInstance();
	}
	
	public static GameResource getInstance()
	{
		if(_instance==null)
			_instance=new GameResource();
		return _instance; 
	}
	
	@GET
	@Produces("application/json")
	public Collection<Game> getAll()
	{
		return repository.getAllGames();
	}
	
	
	@GET
	@Path("/{title}")
	@Produces("application/json")
	public Game get(@PathParam("title") String gameTitle){
		 return repository.getGame(gameTitle);
	}
	
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public Response addGame(@Context UriInfo uriInfo, Game game) {
		return _instance.addGame(uriInfo, game);
	}
	
	
	@PUT
	@Consumes("application/json")
	public Response updateGame(Game game) {
		return _instance.updateGame(game);
	}
	
	@DELETE
	@Path("/{title}")
	public Response removeGame(@PathParam("title") String gameTitle) {
		return _instance.removeGame(gameTitle);
	}
	
}

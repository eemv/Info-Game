package aiss.api.resources;

import java.net.URI;
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
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import org.jboss.resteasy.spi.BadRequestException;

import aiss.model.Game;
import aiss.model.repository.GameRepository;
import aiss.model.repository.MapGameRepository;
import javassist.NotFoundException;

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
	public Game get(@PathParam("title") String gameTitle) throws NotFoundException{
		Game game = repository.getGame(gameTitle);
		if(game == null) {
			throw new NotFoundException("El juego "+ gameTitle+" no ha sido encontrado");
		}
		 return game;
	}
	
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public Response addGame(@Context UriInfo uriInfo, Game game) {
		repository.addGame(game);
		if (game.getTitle() == null || "".equals(game.getTitle())) {
			throw new BadRequestException("El título del juego no debe ser null o vacío");
		}if (game.getPlaylists() == null || game.getPlaylists().isEmpty()) {
			throw new BadRequestException("La playlist del juego no debe ser null o vacía");
		}if (game.getDirectos() == null || game.getDirectos().isEmpty()) {
			throw new BadRequestException("Los directos del juego no deben ser null o vacíos");
		}if (game.getVideos() == null || game.getVideos().isEmpty()) {
			throw new BadRequestException("Los vídeos del juego no deben ser null o vacíos");
		}if (game.getDescripcion() == null || "".equals(game.getDescripcion())) {
			throw new BadRequestException("La descripción del juego no debe ser null o vacía");
		}	
		UriBuilder ub = uriInfo.getAbsolutePathBuilder().path(this.getClass(),"get");
		URI uri = ub.build(game.getTitle());
		ResponseBuilder resp = Response.created(uri);
		resp.entity(game);
		return resp.build();
	}
	
	
	@PUT
	@Consumes("application/json")
	public Response updateGame(Game game) throws NotFoundException {
		Game oldGame = repository.getGame(game.getTitle());
		if (oldGame == null) {
			throw new NotFoundException("El juego con titulo "+ game.getTitle()+" no fue encontrado");
		}
		if (game.getTitle() != null) {
			oldGame.setTitle(game.getTitle());
		}if (game.getPlaylists() != null) {
			oldGame.setPlaylists(game.getPlaylists());
		}if (game.getVideos() != null) {
			oldGame.setVideos(game.getVideos());
		}if (game.getDirectos() != null) {
			oldGame.setDirectos(game.getDirectos());
		}if (game.getDescripcion() != null) {
			oldGame.setDescripcion(game.getDescripcion());
		}
		return Response.noContent().build();
	}
	
	@DELETE
	@Path("/{title}")
	public Response removeGame(@PathParam("title") String gameTitle) throws NotFoundException {
		Game gameRemoved = repository.getGame(gameTitle);
		if(gameRemoved == null) {
			throw new NotFoundException("El juego con titulo "+ gameTitle +" no fue encontrada");
		}else {
			repository.deleteGame(gameTitle);
		}
		return Response.noContent().build();
	}
	
}

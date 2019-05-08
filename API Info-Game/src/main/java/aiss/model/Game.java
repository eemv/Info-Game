package aiss.model;

import java.util.List;

import aiss.model.reddit.SearchWikipedia;
import aiss.model.spotify.Playlists;
import aiss.model.spotify.SpotifySearch;
import aiss.model.twitch.StreamSearch;
import aiss.model.youtube.VideoSearch;

public class Game {

	private String title;
	private List<String> playlist;
	private List<String> directos;
	private List<String> videos;
	private String descripcion;
	
	
	
	public Game() {
		super();
	}

	public Game(String title, List<String> playlist, List<String> directos, List<String> videos,
			String descripcion) {
		super();
		this.title = title;
		this.playlist = playlist;
		this.directos = directos;
		this.videos = videos;
		this.descripcion = descripcion;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public List<String> getPlaylists() {
		return playlist;
	}
	public void setPlaylists(List<String> playlist) {
		this.playlist = playlist;
	}
	public List<String> getDirectos() {
		return directos;
	}
	public void setDirectos(List<String> directos) {
		this.directos = directos;
	}
	public List<String> getVideos() {
		return videos;
	}
	public void setVideos(List<String> videos) {
		this.videos = videos;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	


}

package aiss.model.repository;

import java.util.Collection;

import aiss.model.Game;

public interface GameRepository {

	// Songs
	public void addGame(Game g);
	public Collection<Game> getAllGames();
	public Game getGame(String gameTitle);
	public void updateGame(Game g);
	public void deleteGame(String gameTitle);
	
//	// Playlists
//	public void addPlaylist(Playlist p);
//	public Collection<Playlist> getAllPlaylists();
//	public Playlist getPlaylist(String playlistId);
//	public void updatePlaylist(Playlist p);
//	public void deletePlaylist(String playlistId);
//	public Collection<Song> getAll(String playlistId);
//	public void addSong(String playlistId, String songId);
//	public void removeSong(String playlistId, String songId); 

	
	
	
	

}

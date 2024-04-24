package com.kodnest.tunehub.service;

import java.util.List;

import com.kodnest.tunehub.entity.Song;

public interface SongService {

	void saveSong(Song song);

	boolean snameExists(String sname);

	List<Song> fetchAllSongs();

}

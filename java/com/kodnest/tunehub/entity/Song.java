package com.kodnest.tunehub.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
@Entity
public class Song {
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private int sid;
	private String sname;
	private String artist;
	private String genre;
	private String link;
	
	@ManyToMany
	private List<Playlist> playlists;
	
	public Song() {
		super();
	}

	public Song(int sid, String sname, String artist, String genre, String link, List<Playlist> playlists) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.artist = artist;
		this.genre = genre;
		this.link = link;
		this.playlists = playlists;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public List<Playlist> getPlaylists() {
		return playlists;
	}

	public void setPlaylists(List<Playlist> playlists) {
		this.playlists = playlists;
	}

	@Override
	public String toString() {
		return "Song [sid=" + sid + ", sname=" + sname + ", artist=" + artist + ", genre=" + genre + ", link=" + link
				+ ", playlists=" + playlists + "]";
	}
	
	
}

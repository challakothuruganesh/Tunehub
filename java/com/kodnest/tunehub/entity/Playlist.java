package com.kodnest.tunehub.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
@Entity
public class Playlist {
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private int pid;
	private String pname;
	
	@ManyToMany
	private List<Song> songs;
	

	public Playlist() {
		super();
	}


	public Playlist(int pid, String pname, List<Song> songs) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.songs = songs;
	}


	public int getPid() {
		return pid;
	}


	public void setPid(int pid) {
		this.pid = pid;
	}


	public String getPname() {
		return pname;
	}


	public void setPname(String pname) {
		this.pname = pname;
	}


	public List<Song> getSongs() {
		return songs;
	}


	public void setSongs(List<Song> songs) {
		this.songs = songs;
	}


	@Override
	public String toString() {
		return "Playlist [pid=" + pid + ", pname=" + pname + ", songs=" + songs + "]";
	}

	
	

}

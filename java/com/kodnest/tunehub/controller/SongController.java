package com.kodnest.tunehub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.kodnest.tunehub.entity.Song;
import com.kodnest.tunehub.service.SongService;

@Controller
public class SongController {
	@Autowired
	SongService songService;

	@PostMapping("/addsongs")
	public String saveSong(@ModelAttribute Song song) {
		String sname = song.getSname();
		boolean snameExists = songService.snameExists(sname);
		if(snameExists==false) {
			songService.saveSong(song);
			System.out.println("User added successfully");
		}
		else {
			System.out.println("Duplicate user");
		}
		return "song";
	}
	
	@GetMapping("/viewsongs")
	public String viewSongs(Model model) {
		List <Song> songslist= songService.fetchAllSongs();
		model.addAttribute("songs", songslist);
		System.out.println(songslist);
		return "viewsongs";
		
	}
}

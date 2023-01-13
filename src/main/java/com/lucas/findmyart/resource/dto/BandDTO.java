package com.lucas.findmyart.resource.dto;

import java.util.List;

import com.lucas.findmyart.model.entities.Band;
import com.lucas.findmyart.model.entities.Genre;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class BandDTO {
	
	private String username;
	private String email;
	private String name;
	private String profilePhotoToken;
	private String about;
	
	private List<String> genres;
	
	public BandDTO(Band band) {
		this.username = band.getUsername();
		this.email = band.getEmail();
		this.name = band.getName();
		this.profilePhotoToken = band.getProfilePhotoToken();
		this.about = band.getAbout();
		this.genres = band.getGenres()
				.stream().map(Genre::getGenre).toList();
	}
	
}

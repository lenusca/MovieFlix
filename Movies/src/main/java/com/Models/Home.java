package com.Models;

import java.util.ArrayList;
import java.util.List;

public class Home {
	public List<Movie> topmovies = new ArrayList<>();
	public List<Serie> topseries = new ArrayList<>();
	
	public Home() {
		// TODO Auto-generated constructor stub
	}

	public List<Movie> getTopmovies() {
		return topmovies;
	}

	public void setTopmovies(List<Movie> topmovies) {
		this.topmovies = topmovies;
	}

	public List<Serie> getTopmseries() {
		return topseries;
	}

	public void setTopmseries(List<Serie> topmseries) {
		this.topseries = topmseries;
	}

	@Override
	public String toString() {
		return "Home [topmovies=" + topmovies + ", topseries=" + topseries + "]";
	}
	
	
}

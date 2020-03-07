package com.dbcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

import com.Models.ListSeries;
import com.Models.Movie;
import com.Models.Search;
import com.Models.Serie;
import com.restclient.CallRestService;

@Component
@ComponentScan({"com.restclient"})
@EnableScheduling
public class MainController {
	@Autowired
	CallRestService restService;
	
	@Autowired
	MovieRepository movieRepository;
	
	@Autowired
	SearchRepository moviesRepository;
	
	@Autowired
	SerieRepository serieRepository;
	
	//Adicionar a base dados
	//Um filme
	public void addMovie (String id) {
		Movie movie = restService.getMovie(id);
		movieRepository.save(movie);
		System.out.println("Movie "+movie.Title+" added");
	}
	
	//Vários filmes
	public void addMovies() {
		Search []movies = restService.getMovies();
		for(int j=0; j<movies.length; j++) {
			for(int i=0; i<movies[j].Search.length; i++) {
				if(!movies[j].Search[i].Poster.equals("N/A")) {
					movieRepository.save(movies[j].Search[i]);
					System.out.println("Filme " +movies[j].Search[i].Title + " adicionado");
				}
				
			}
		}	
	}
	//Uma série
	public void addSerie(String id) {
		Serie serie = restService.getSerie(id);
		serieRepository.save(serie);
		System.out.println("Serie "+serie.Title+" added");
		
	}
	
	//Várias séries
	public void addSeries() {
		ListSeries []series = restService.getSeries();
		for(int j=0; j<series.length; j++) {
			for(int i=0; i<series[j].Search.length; i++) {
				if(!series[j].Search[i].Poster.equals("N/A")) {
					System.out.println(series[j].Search[i].Poster);
					serieRepository.save(series[j].Search[i]);
					System.out.println("Série " +series[j].Search[i].Title + " adicionado");
				}
				
			}
		}
	}
}

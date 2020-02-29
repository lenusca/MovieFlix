package com.restclient;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;

import com.Models.ListSeries;
import com.Models.Movie;
import com.Models.Search;
import com.Models.Serie;

@Component
public class CallRestService{
	
	static RestTemplate restTemplate = new RestTemplate();
	

	public Movie getMovie(){
		//buscar filme especifico
		ResponseEntity<Movie>response = restTemplate.exchange("http://www.omdbapi.com/?t=Frozen&type=movie&apikey=a593ebbd", HttpMethod.GET, null, new ParameterizedTypeReference<Movie>(){});
		Movie m = response.getBody();
		
		return m;
	}
	
	public Search[] getMovies() {
		String []movietitles = {"love", "movie", "dog", "fast", "follow", "pirates", "war", "Frozen", "star", "life"};
		Search []movie = new Search[movietitles.length];
		for(int i=0; i<movietitles.length; i++) {
			ResponseEntity<Search>response = restTemplate.exchange("http://www.omdbapi.com/?s="+movietitles[i]+"&type=movie&apikey=a593ebbd", HttpMethod.GET, null, new ParameterizedTypeReference<Search>(){});
			Search search = response.getBody();
			movie[i]=search;
		}
		return movie;
	}
	
	public Serie getSerie() {
		ResponseEntity<Serie>response = restTemplate.exchange("http://www.omdbapi.com/?t=Awkward&type=series&apikey=a593ebbd", HttpMethod.GET, null, new ParameterizedTypeReference<Serie>(){});
		Serie serie = response.getBody();
		System.out.print(serie);
		return serie;
	}
	
	public ListSeries[] getSeries() {
		String []serietitles = {"love", "horror", "history", "fast", "awkward", "romance", "war", "about", "star", "life", "family", "crime"};
		ListSeries[]series = new ListSeries[serietitles.length];
		for(int i=0; i<serietitles.length; i++) {
			ResponseEntity<ListSeries>response = restTemplate.exchange("http://www.omdbapi.com/?s="+serietitles[i]+"&type=series&apikey=a593ebbd", HttpMethod.GET, null, new ParameterizedTypeReference<ListSeries>(){});
			ListSeries search = response.getBody();
			series[i]=search;
		}
		return series;
	}
	
}

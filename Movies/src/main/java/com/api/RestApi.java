package com.api;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.Models.Home;
import com.Models.Movie;
import com.Models.UserMovies;
import com.Models.Search;
import com.Models.Serie;
import com.Models.UserSeries;
import com.dbcontroller.MainController;
import com.dbcontroller.MovieRepository;
import com.dbcontroller.SearchRepository;
import com.dbcontroller.SerieRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.*;
@Component
@RestController
public class RestApi {
	
	// criar a minha propria para por na web 
	static RestTemplate restTemplate = new RestTemplate();
	@Autowired
	MovieRepository movieRepository;
	
	@Autowired
	SearchRepository moviesRepository;
	
	@Autowired
	SerieRepository serieRepository;
	
	@Autowired
	MainController mainController = new MainController();
	
	//PROCURAR NA BASE DADOS 
	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping(value="/Search/", method = RequestMethod.GET)
	public ResponseEntity<Home> Search(@RequestParam("name") String name) {
		System.out.print("AQUI"+name);
		Home search = new Home();
		//MOVIE//
		Iterable<Movie> movie = movieRepository.findAll();
		List<Movie> c = new ArrayList<Movie>();
		movie.forEach(e -> c.add(e));
		
		for(int i = 0; i<c.size(); i++) {
			if(c.get(i).Title.toLowerCase().contains(name.toLowerCase())) {
				search.topmovies.add(c.get(i));
			}
		}
		//SERIE//
		Iterable<Serie> serie = serieRepository.findAll();
		List<Serie> c1 = new ArrayList<Serie>();
		serie.forEach(e -> c1.add(e));
		for(int i = 0; i<c1.size(); i++) {
			if(c1.get(i).Title.toLowerCase().contains(name.toLowerCase())) {
				search.topseries.add(c1.get(i));
			}
		}
		
		return new ResponseEntity<Home>(search, HttpStatus.OK);		
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping(value="/Top/", method = RequestMethod.GET)
	public ResponseEntity<Home> TopMovies() {
			
		Iterable<Movie> movie = movieRepository.findAll();
		List<Movie> c = new ArrayList<Movie>();
		movie.forEach(e -> c.add(e));
		
		Iterable<Serie> serie = serieRepository.findAll();
		List<Serie> c1 = new ArrayList<Serie>();
		serie.forEach(e -> c1.add(e));
		
		// guardar o top 3 de series e movies
		Home top = new Home();
		Random rand = new Random();
		///////SERIE/////////
		top.topseries.add(0, c1.get(rand.nextInt(c1.size())));
		top.topseries.add(1, c1.get(rand.nextInt(c1.size())));
		top.topseries.add(2, c1.get(rand.nextInt(c1.size())));
		///////MOVIE/////////
		top.topmovies.add(0, c.get(rand.nextInt(c.size())));
		top.topmovies.add(1, c.get(rand.nextInt(c.size())));
		top.topmovies.add(2, c.get(rand.nextInt(c.size())));
		return new ResponseEntity<Home>(top, HttpStatus.OK);		
	}
	
	////////////////////////////////////////////////////////////////////MOVIES///////////////////////////////////////////////////////////////
	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping(value="/Movies/", method = RequestMethod.GET)
	public ResponseEntity<List<Movie>> Movies() {
			
		Iterable<Movie> movie = movieRepository.findAll();
		List<Movie> c = new ArrayList<Movie>();
		movie.forEach(e -> c.add(e));
		
			System.out.println(c);
		return new ResponseEntity<List<Movie>>(c, HttpStatus.OK);		
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping(value="/Movie/", method = RequestMethod.GET)
	public ResponseEntity<Optional<com.Models.Movie>> Movie(@RequestParam("id") String id) {
		Optional<com.Models.Movie> movie = movieRepository.findById(id);
		int user = movie.get().user;
		
		mainController.addMovie(id);
		Optional<com.Models.Movie> movie1 = movieRepository.findById(id);
		movie1.get().user=user;
		movieRepository.save(movie1.get());

		return new ResponseEntity<Optional<com.Models.Movie>>(movie1, HttpStatus.OK);		
	}
	/////////////////////////////////USER///////////////////////////////////////////
	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping(value="/UserMovies/", method = RequestMethod.GET)
	public ResponseEntity<UserMovies> UserMovies() {
			
		Iterable<Movie> movie = movieRepository.findAll();
		List<Movie> c = new ArrayList<Movie>();
		movie.forEach(e -> c.add(e));
		UserMovies userData = new UserMovies();
		for(int i = 0; i<c.size(); i++) {
			if(c.get(i).user == 1) {
				userData.usermovies.add(c.get(i));
				userData.runtime += Integer.parseInt(c.get(i).Runtime.replace(" min", ""));
				int months = (int)userData.runtime/(31*24*60);
				userData.months = String.format("%02d", months);
				int days = (int)((double)userData.runtime%(31*24*60)/(60*24));
				userData.days = String.format("%02d", days);
				int hours = (int) ((double)userData.runtime%(31*24*60)%(60*24)/60);
				userData.hours = String.format("%02d", hours);
				if(c.get(i).Genre.contains("Comedy")) {
					userData.Comedy = userData.Comedy + 1;
				}
				if(c.get(i).Genre.contains("Animation")) {
					userData.Animation = userData.Animation + 1;
				}
				if(c.get(i).Genre.contains("Romance")) {
					userData.Romance = userData.Romance + 1;
				}
				if(c.get(i).Genre.contains("Drama")) {
					userData.Drama = userData.Drama + 1;
				}
				if(c.get(i).Genre.contains("Horror")) {
					userData.Horror = userData.Horror + 1;
				}
				if(c.get(i).Genre.contains("Adventure")) {
					userData.Adventure = userData.Adventure + 1;
				}
				if(c.get(i).Genre.contains("Crime")) {
					userData.Crime = userData.Crime + 1;
				}
				if(c.get(i).Genre.contains("Action")) {
					userData.Action = userData.Action + 1;
				}
				if((int)Double.parseDouble(c.get(i).imdbRating) < 2.5) {
					userData.imdbRating2 = userData.imdbRating2 + 1;
				}
				
				if((int)Double.parseDouble(c.get(i).imdbRating) >= 2.5 && (int)Double.parseDouble(c.get(i).imdbRating) < 4.5) {
					userData.imdbRating4 = userData.imdbRating4 + 1;
				}
				
				if((int)Double.parseDouble(c.get(i).imdbRating) >= 4.5 && (int)Double.parseDouble(c.get(i).imdbRating) < 7.5) {
					userData.imdbRating6 = userData.imdbRating6 + 1;
				}
				
				if((int)Double.parseDouble(c.get(i).imdbRating) >= 7.5 && (int)Double.parseDouble(c.get(i).imdbRating) < 8.5) {
					userData.imdbRating8 = userData.imdbRating8 + 1;
				}
				
				if((int)Double.parseDouble(c.get(i).imdbRating) >= 8.5) {
					userData.imdbRating10 = userData.imdbRating10 + 1;
				}
			}
		}
		return new ResponseEntity<UserMovies>(userData, HttpStatus.OK);		
	}

	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping(value="/addMovieFavorites/", method = RequestMethod.GET)
	public ResponseEntity<Optional<com.Models.Movie>> addMovieUser(@RequestParam("id") String id) {
		//mainController.addMovie(id);
		Optional<com.Models.Movie> movie = movieRepository.findById(id);
		// adicionar o utilizador aquele filme
		movie.get().user = 1;
		movieRepository.save(movie.get());

		return new ResponseEntity<Optional<com.Models.Movie>>(movie, HttpStatus.OK);		
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping(value="/removeMovieFavorites/", method = RequestMethod.GET)
	public ResponseEntity<Optional<com.Models.Movie>> removeMovieUser(@RequestParam("id") String id) {
		//mainController.addMovie(id);
		Optional<com.Models.Movie> movie = movieRepository.findById(id);
		// remover o utilizador aquele filme
		movie.get().user=0;
		mainController.addMovie(id);
		System.out.println(movie);
		return new ResponseEntity<Optional<com.Models.Movie>>(movie, HttpStatus.OK);		
	}
	////////////////////////////////////////////////////////////////////SERIES///////////////////////////////////////////////////////////////
	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping(value="/Series/", method = RequestMethod.GET)
	public ResponseEntity<List<Serie>> Series() {
			
		Iterable<Serie> serie = serieRepository.findAll();
		List<Serie> c = new ArrayList<Serie>();
		serie.forEach(e -> c.add(e));
		
		System.out.println(c);
		return new ResponseEntity<List<Serie>>(c, HttpStatus.OK);		
	}

	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping(value="/Serie/", method = RequestMethod.GET)
	public ResponseEntity<Optional<com.Models.Serie>> Serie(@RequestParam("id") String id) {
		Optional<com.Models.Serie> serie = serieRepository.findById(id);
		int user = serie.get().user;
		mainController.addSerie(id);
		
		Optional<com.Models.Serie> serie1 = serieRepository.findById(id);
		serie1.get().user=user;
		serieRepository.save(serie1.get());
		return new ResponseEntity<Optional<com.Models.Serie>>(serie1, HttpStatus.OK);		
	}
	
    /////////////////////////////////USER///////////////////////////////////////////
	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping(value="/UserSeries/", method = RequestMethod.GET)
	public ResponseEntity<UserSeries> UserSeries() {
			
		Iterable<Serie> serie = serieRepository.findAll();
		List<Serie> c = new ArrayList<Serie>();
		serie.forEach(e -> c.add(e));
		// para guardar as séries que tem utilizador
		UserSeries userData = new UserSeries();
		for(int i = 0; i<c.size(); i++) {
			
			if(c.get(i).user == 1) {
				userData.userseries.add(c.get(i));
				if(c.get(i).totalSeasons.equals("N/A")) {
					userData.runtime += Integer.parseInt(c.get(i).Runtime.replace(" min", ""))*10;
				}
				else {
					userData.runtime += Integer.parseInt(c.get(i).Runtime.replace(" min", ""))*Integer.parseInt(c.get(i).totalSeasons)*10;
				}
				
				
				int months = (int)userData.runtime/(31*24*60);
				userData.months = String.format("%02d", months);
				int days = (int)((double)userData.runtime%(31*24*60)/(60*24));
				userData.days = String.format("%02d", days);
				int hours = (int) ((double)userData.runtime%(31*24*60)%(60*24)/60);
				userData.hours = String.format("%02d", hours);
				if(c.get(i).Genre.contains("Comedy")) {
					userData.Comedy = userData.Comedy + 1;
				}
				if(c.get(i).Genre.contains("Animation")) {
					userData.Animation = userData.Animation + 1;
				}
				if(c.get(i).Genre.contains("Romance")) {
					userData.Romance = userData.Romance + 1;
				}
				if(c.get(i).Genre.contains("Drama")) {
					userData.Drama = userData.Drama + 1;
				}
				if(c.get(i).Genre.contains("Horror")) {
					userData.Horror = userData.Horror + 1;
				}
				if(c.get(i).Genre.contains("Adventure")) {
					userData.Adventure = userData.Adventure + 1;
				}
				if(c.get(i).Genre.contains("Crime")) {
					userData.Crime = userData.Crime + 1;
				}
				if(c.get(i).Genre.contains("Action")) {
					userData.Action = userData.Action + 1;
				}
				if((int)Double.parseDouble(c.get(i).imdbRating) < 2.5) {
					userData.imdbRating2 = userData.imdbRating2 + 1;
				}
				
				if((int)Double.parseDouble(c.get(i).imdbRating) >= 2.5 && (int)Double.parseDouble(c.get(i).imdbRating) < 4.5) {
					userData.imdbRating4 = userData.imdbRating4 + 1;
				}
				
				if((int)Double.parseDouble(c.get(i).imdbRating) >= 4.5 && (int)Double.parseDouble(c.get(i).imdbRating) < 7.5) {
					userData.imdbRating6 = userData.imdbRating6 + 1;
				}
				
				if((int)Double.parseDouble(c.get(i).imdbRating) >= 7.5 && (int)Double.parseDouble(c.get(i).imdbRating) < 8.5) {
					userData.imdbRating8 = userData.imdbRating8 + 1;
				}
				
				if((int)Double.parseDouble(c.get(i).imdbRating) >= 8.5) {
					userData.imdbRating10 = userData.imdbRating10 + 1;
				}
			}	
		}
		return new ResponseEntity<UserSeries>(userData, HttpStatus.OK);		
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping(value="/addSerieFavorites/", method = RequestMethod.GET)
	public ResponseEntity<Optional<com.Models.Serie>> addSerieFavorites(@RequestParam("id") String id) {
		//
		System.out.println(id);
		
		Optional<com.Models.Serie> serie = serieRepository.findById(id);
		// adicionar ao utilizador
		serie.get().user = 1;
		serieRepository.save(serie.get());
		System.out.println(id);
		return new ResponseEntity<Optional<com.Models.Serie>>(serie, HttpStatus.OK);		
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping(value="/removeSerieFavorites/", method = RequestMethod.GET)
	public ResponseEntity<Optional<com.Models.Serie>> removeSerieFavorites(@RequestParam("id") String id) {
		//mainController.addSerie(id);	
		Optional<com.Models.Serie> serie = serieRepository.findById(id);
		// adicionar ao utilizador
		serie.get().user = 0;
		mainController.addSerie(id);
		System.out.println(serie);
		return new ResponseEntity<Optional<com.Models.Serie>>(serie, HttpStatus.OK);		
	}
	

}

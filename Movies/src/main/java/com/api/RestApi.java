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

import com.Models.Movie;
import com.Models.Search;
import com.Models.Serie;
import com.dbcontroller.MainController;
import com.dbcontroller.MovieRepository;
import com.dbcontroller.SearchRepository;
import com.dbcontroller.SerieRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
	@RequestMapping(value="/UserMovies/", method = RequestMethod.GET)
	public ResponseEntity<List<Movie>> UserMovies() {
			
		Iterable<Movie> movie = movieRepository.findAll();
		List<Movie> c = new ArrayList<Movie>();
		movie.forEach(e -> c.add(e));
		List<Movie> user = new ArrayList<Movie>();
		for(int i = 0; i<c.size(); i++) {
			if(c.get(i).user == 1) {
				user.add(c.get(i));
			}
		}
			System.out.println(c);
		return new ResponseEntity<List<Movie>>(user, HttpStatus.OK);		
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
	@RequestMapping(value="/UserSeries/", method = RequestMethod.GET)
	public ResponseEntity<List<Serie>> UserSeries() {
			
		Iterable<Serie> serie = serieRepository.findAll();
		List<Serie> c = new ArrayList<Serie>();
		serie.forEach(e -> c.add(e));
		// para guardar as séries que tem utilizador
		List<Serie> user = new ArrayList<Serie>();
		for(int i = 0; i<c.size(); i++) {
			if(c.get(i).user == 1) {
				user.add(c.get(i));
			}
		}
		return new ResponseEntity<List<Serie>>(user, HttpStatus.OK);		
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

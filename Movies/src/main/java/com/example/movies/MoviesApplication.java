package com.example.movies;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.client.RestTemplate;

import com.Models.Movie;
import com.api.RestApi;
import com.dbcontroller.MainController;
import com.restclient.CallRestService;

@SpringBootApplication
@ComponentScan({"com.dbcontroller", "com.api"})
@EnableJpaRepositories({"com.dbcontroller"})
@EntityScan({"com.Models"})
public class MoviesApplication {
	private static final Logger log = LoggerFactory.getLogger(MoviesApplication.class);

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(MoviesApplication.class, args);
		MainController maincontroller = context.getBean(MainController.class);
		maincontroller.addMovies(); //listar todos os filmes
		//maincontroller.addMovie(); // detalhes de um filme especifico
		maincontroller.addSeries(); //listar todos as séries
		//maincontroller.addSerie(); //detalhes especificos de uma série
		RestApi restapi = context.getBean(RestApi.class);

	}
		
	
	}



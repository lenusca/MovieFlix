package com.Models;

import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Search {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int id;
	public Movie[] Search ;
	public String totalResults;
	public String Response;
	
	@Override
	public String toString() {
		return "Search [Search=" + Arrays.toString(Search) + ", totalResults=" + totalResults + ", Response=" + Response
				+ "]";
	}


	public Search() {
		// TODO Auto-generated constructor stub
	}


	public String getTotalResults() {
		return totalResults;
	}



	public Movie[] getSearch() {
		return Search;
	}



	public void setSearch(Movie[] search) {
		Search = search;
	}



	public void setTotalResults(String totalResults) {
		this.totalResults = totalResults;
	}



	public String getResponse() {
		return Response;
	}



	public void setResponse(String response) {
		Response = response;
	}

}

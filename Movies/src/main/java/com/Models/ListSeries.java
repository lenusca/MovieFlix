package com.Models;

import java.util.Arrays;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class ListSeries {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int id;
	public Serie[] Search ;
	public String totalResults;
	public String Response;
	public ListSeries() {
		// TODO Auto-generated constructor stub
	}


	public String getTotalResults() {
		return totalResults;
	}
	
	public Serie[] getSearch() {
		return Search;
	}



	public void setSearch(Serie[] search) {
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


	@Override
	public String toString() {
		return "ListSeries [Search=" + Arrays.toString(Search) + ", totalResults=" + totalResults + ", Response="
				+ Response + "]";
	}
	
	
}

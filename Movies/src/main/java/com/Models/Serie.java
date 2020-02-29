package com.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Serie {
	@Id
	public String imdbID;
	public String Title;
    public String Year;
    public String Rated;
    public String Released;
    public String Runtime;
    public String Genre;
    public String Director;
    public String Writer;
    public String Actors;
    public String Plot;
    public String Language;
    public String Country;
    public String Awards;
    public String Poster;
    public String Metascore;
    @JsonProperty("imdbRating")
    public String imdbRating;
    @JsonProperty("imdbVotes")
    public String imdbVotes;  
    public String Type;
    public String totalSeasons;
    public String Response;
	public Serie() {
		// TODO Auto-generated constructor stub
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getRated() {
		return Rated;
	}
	public void setRated(String rated) {
		Rated = rated;
	}
	public String getYear() {
		return Year;
	}
	public void setYear(String year) {
		Year = year;
	}
	public String getReleased() {
		return Released;
	}
	public void setReleased(String released) {
		Released = released;
	}
	public String getRuntime() {
		return Runtime;
	}
	public void setRuntime(String runtime) {
		Runtime = runtime;
	}
	public String getGenre() {
		return Genre;
	}
	public void setGenre(String genre) {
		Genre = genre;
	}
	public String getDirector() {
		return Director;
	}
	public void setDirector(String director) {
		Director = director;
	}
	public String getWriter() {
		return Writer;
	}
	public void setWriter(String writer) {
		Writer = writer;
	}
	public String getActors() {
		return Actors;
	}
	public void setActors(String actors) {
		Actors = actors;
	}
	public String getPlot() {
		return Plot;
	}
	public void setPlot(String plot) {
		Plot = plot;
	}
	public String getLanguage() {
		return Language;
	}
	public void setLanguage(String language) {
		Language = language;
	}
	public String getCountry() {
		return Country;
	}
	public void setCountry(String country) {
		Country = country;
	}
	public String getAwards() {
		return Awards;
	}
	public void setAwards(String awards) {
		Awards = awards;
	}
	public String getPoster() {
		return Poster;
	}
	public void setPoster(String poster) {
		Poster = poster;
	}
	public String getMetascore() {
		return Metascore;
	}
	public void setMetascore(String metascore) {
		Metascore = metascore;
	}
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}
	public String getResponse() {
		return Response;
	}
	public void setResponse(String response) {
		Response = response;
	}
	public String getTotalSeasons() {
		return totalSeasons;
	}
	public void setTotalSeasons(String totalSeasons) {
		this.totalSeasons = totalSeasons;
	}
	@Override
	public String toString() {
		return "Serie [  Title=" + Title + ", Year=" + Year + ", Rated=" + Rated + ", Released=" + Released
				+ ", Runtime=" + Runtime + ", Genre=" + Genre + ", Director=" + Director + ", Writer=" + Writer
				+ ", Actors=" + Actors + ", Plot=" + Plot + ", Language=" + Language + ", Country=" + Country
				+ ", Awards=" + Awards + ", Poster=" + Poster + ", Metascore=" + Metascore + ", imdbRating="
				+ imdbRating + ", imdbVotes=" + imdbVotes + ", imdbID=" + imdbID + ", Type=" + Type + ", totalSeasons="
				+ totalSeasons + ", Response=" + Response + "]";
	}
	

}

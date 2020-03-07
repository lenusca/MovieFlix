package com.Models;

import java.util.*;

public class UserMovies {
	public int runtime;
	public String months, days, hours;
	public List<Movie> usermovies = new ArrayList<>();
	public int Comedy, Animation, Romance, Drama, Horror, Adventure, Crime, Action;
	public int imdbRating2, imdbRating4, imdbRating6, imdbRating8, imdbRating10;
	public UserMovies() {
		// TODO Auto-generated constructor stub
	}
	
	public List<Movie> getUsermovies() {
		return usermovies;
	}

	public void setUsermovies(List<Movie> usermovies) {
		this.usermovies = usermovies;
	}

	public int getComedy() {
		return Comedy;
	}

	public void setComedy(int comedy) {
		Comedy = comedy;
	}

	public int getAnimation() {
		return Animation;
	}

	public void setAnimation(int animation) {
		Animation = animation;
	}

	public int getRomance() {
		return Romance;
	}

	public void setRomance(int romance) {
		Romance = romance;
	}

	public int getDrama() {
		return Drama;
	}

	public void setDrama(int drama) {
		Drama = drama;
	}

	public int getHorror() {
		return Horror;
	}

	public void setHorror(int horror) {
		Horror = horror;
	}

	public int getAdventure() {
		return Adventure;
	}

	public void setAdventure(int adventure) {
		Adventure = adventure;
	}

	public int getCrime() {
		return Crime;
	}

	public void setCrime(int crime) {
		Crime = crime;
	}
	

	public int getAction() {
		return Action;
	}

	public void setAction(int action) {
		Action = action;
	}

	public int getImdbRating2() {
		return imdbRating2;
	}

	public void setImdbRating2(int imdbRating2) {
		this.imdbRating2 = imdbRating2;
	}

	public int getImdbRating4() {
		return imdbRating4;
	}

	public void setImdbRating4(int imdbRating4) {
		this.imdbRating4 = imdbRating4;
	}

	public int getImdbRating6() {
		return imdbRating6;
	}

	public void setImdbRating6(int imdbRating6) {
		this.imdbRating6 = imdbRating6;
	}

	public int getImdbRating8() {
		return imdbRating8;
	}

	public void setImdbRating8(int imdbRating8) {
		this.imdbRating8 = imdbRating8;
	}

	public int getImdbRating10() {
		return imdbRating10;
	}

	public void setImdbRating10(int imdbRating10) {
		this.imdbRating10 = imdbRating10;
	}

	public int getRuntime() {
		return runtime;
	}

	public void setRuntime(int runtime) {
		this.runtime = runtime;
	}
	
	

	public String getMonths() {
		return months;
	}

	public void setMonths(String months) {
		this.months = months;
	}

	public String getDays() {
		return days;
	}

	public void setDays(String days) {
		this.days = days;
	}

	public String getHours() {
		return hours;
	}

	public void setHours(String hours) {
		this.hours = hours;
	}

	@Override
	public String toString() {
		return "UserMovies [runtime=" + runtime + ", months=" + months + ", days=" + days + ", hours=" + hours
				+ ", usermovies=" + usermovies + ", Comedy=" + Comedy + ", Animation=" + Animation + ", Romance="
				+ Romance + ", Drama=" + Drama + ", Horror=" + Horror + ", Adventure=" + Adventure + ", Crime=" + Crime
				+ ", Action=" + Action + ", imdbRating2=" + imdbRating2 + ", imdbRating4=" + imdbRating4
				+ ", imdbRating6=" + imdbRating6 + ", imdbRating8=" + imdbRating8 + ", imdbRating10=" + imdbRating10
				+ "]";
	}

	

	
	

	

	
	
	
	
}

package moviesDatabase;
import java.util.*;

public class Movie {
	private ArrayList<Actor> actors;
	private String name;
	private double rating;
	
	/**
	 * Get list of actors that this movie features
	 * @return
	 */
	public ArrayList<Actor> getActors() {
		return actors;
	}
	
	/**
	 * set the list of actors that this movie features
	 * @param actors
	 */
	public void setActors(ArrayList<Actor> actors) {
		this.actors = actors;
	}
	
	/**
	 * Get the name of the movie this object refers to
	 * @return
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Set the name of the movie this object refers to
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Get the rating of this movie (returns a double)
	 * @return
	 */
	public double getRating() {
		return rating;
	}
	
	/**
	 * Set the rating of this movie (as a double)
	 * @param rating
	 */
	public void setRating(double rating) {
		this.rating = rating;
	}
	
	
	/**
	 * Construct movie object
	 * @param rating
	 * @param name
	 * @param actors
	 */
	public Movie(double rating, String name, ArrayList<Actor> actors) {
		this.rating = rating;
		this.name = name;
		this.actors = actors;
	}
}

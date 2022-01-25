package moviesDatabase;
import java.util.*;

public class MovieDatabase {
	private ArrayList<Movie> movieList;
	private ArrayList<Actor> actorList;
	
	/**
	 * Construct a new MovieDatabase and create empty
	 * movie list and actor list
	 */
	public MovieDatabase() {
		this.movieList = new ArrayList<>();
		this.actorList = new ArrayList<>();
		
	}
	
	/**
	 * Get movie list from object
	 * @return
	 */
	public ArrayList<Movie> getMovieList() {
		return movieList;
	}

	/**
	 * Set movie list from object
	 * @param movieList
	 */
	public void setMovieList(ArrayList<Movie> movieList) {
		this.movieList = movieList;
	}
	
	/**
	 * Get actor list from object
	 * @return
	 */
	public ArrayList<Actor> getActorList() {
		return actorList;
	}

	/**
	 * Set actor list from object
	 * @param actorList
	 */
	public void setActorList(ArrayList<Actor> actorList) {
		this.actorList = actorList;
	}
	
	public void addMovie(String name, String[] actors) {
		
		//if movie with same name already in database, return and do nothing
		for(Movie movie : this.movieList) {
			if(movie.getName().equals(name)) return;
		}
		
		
		//define arraylist for movie actors
		ArrayList<Actor> newMovieActors = new ArrayList<>();
		
		
		//add new actors to actor list
		for(int i = 0; i<actors.length; i++) {
			Actor currentActor = null;
			boolean includes = false;
			//iterate through current actor list
			for(Actor act : this.actorList) {
				//if the current actors name is in the list,
				//set includes = true
				if(act.getName().equals(actors[i])) {
					//set current actor equal to found actor object
					currentActor = act;
					break;
				}
			}
			//if actor not in list, make new actor object and add it to list
			if(currentActor == null) {
				//use empty movie list for now
				ArrayList<Movie> movies = new ArrayList<>();
				Actor newActor = new Actor(actors[i], movies);
				actorList.add(newActor);
				//set current actor equal to newly created actor
				currentActor = newActor;
			}
			
			//push currentActor onto newMovieActors list
			newMovieActors.add(currentActor);
		}
		
		//TODO must convert string array of actors into actor objects
		
		//TODO must ensure movie is not already in database
		Movie tmp = new Movie(0.0, name, newMovieActors);
		
	}
	
	public void addRating(String name, double rating) {
		
	}
	
	public void updateRating(String name, double newRating) {
		
	}
	
	public String getBestActor() {
		
	}
	
	public String getBestMovie() {
		
	}
	
	public static void main(String[] args) {
		MovieDatabase movieDB = new MovieDatabase();
		
	}

}

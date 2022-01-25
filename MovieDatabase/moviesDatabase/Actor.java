package moviesDatabase;
import java.util.*;

public class Actor {
	private String name;
	private ArrayList<Movie> movies;
	
	/**
	 * Get the name of the Actor this object refers to
	 * @return
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Set the Actor name this object refers to
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * return the movies that feature this actor
	 * @return
	 */
	public ArrayList<Movie> getMovies() {
		return movies;
	}
	
	/**
	 * Set the list of movies this actor is featured in
	 * @param movies
	 */
	public void setMovies(ArrayList<Movie> movies) {
		this.movies = movies;
	}

	/**
	 * Construct a new Actor object, give it the specified name
	 * @param name
	 */
	public Actor(String name, ArrayList<Movie> movies) {
		this.name = name;
		this.movies = movies;
	}
	
	public Actor(){
        this.name = "";
        this.movies = new ArrayList<Movie>();
    }
}

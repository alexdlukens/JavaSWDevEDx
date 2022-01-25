package moviesDatabase;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
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
		System.out.println("Adding movie with name "+ name);
		//if movie with same name already in database, return and do nothing
		for(Movie movie : this.movieList) {
			if(movie.getName().equals(name)) return;
		}
		
		
		//define arraylist for movie actors
		ArrayList<Actor> newMovieActors = new ArrayList<>();
		
		
		//add new actors to actor list
		for(int i = 0; i<actors.length; i++) {
			Actor currentActor = null;
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
		
		//define movie object
		Movie tmp = new Movie(0.0, name, newMovieActors);
		//add reference to movie for each actor in movie
		for(Actor a : newMovieActors){
			ArrayList<Movie> actorMovies = a.getMovies();
			actorMovies.add(tmp);
			a.setMovies(actorMovies);
		}
		
		//add movie to movie list
		this.movieList.add(tmp);
	}
	
	public void addRating(String name, double rating) {
		System.out.println("Searching for " + name);
		for(Movie m : this.movieList){
			if(m.getName().equals(name)) {
				m.setRating(rating);
				System.out.println("Adding rating for " + m.getName());
			}
		}
		return;
	}
	
	public void updateRating(String name, double newRating) {
		for(Movie m : this.movieList){
			if(m.getName().equals(name)) m.setRating(newRating);
		}
		return;
	}
	
	
	private double calcActorAvgRating(Actor a){
		int movieCount = 0;
		double ratingSum = 0.0;

		for(Movie m : a.getMovies()){
			ratingSum += m.getRating();
			movieCount += 1;
		}
		return (ratingSum / movieCount);
	}

	public String getBestActor() {
		double bestAverageRating = 0.0;
		Actor bestActor = null;
		for(Actor a : this.actorList){
			double tmpRating = calcActorAvgRating(a);
			if(tmpRating > bestAverageRating){
				bestAverageRating = tmpRating;
				bestActor = a;
			}
		}
		if(bestActor == null) return "";
		return bestActor.getName();
	}
	
	public String getBestMovie() {
		double max = 0.0;
		Movie bestMovie = null;
		for(Movie m : this.movieList){
			if(m.getRating() > max) {
				max = m.getRating();
				bestMovie = m;
			}
		}
		if(bestMovie == null) return "";
		return bestMovie.getName();
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		MovieDatabase movieDB = new MovieDatabase();
		ArrayList<Actor> actors = new ArrayList<>();
		//scanner for movies.txt
		File moviesFile = new File("/home/alex/eclipse-workspace/JavaSWDevEDx/MovieDatabase/moviesDatabase/movies.txt");
		Scanner scan = null;
		try {
			scan = new Scanner(moviesFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//while there is an additional entry
		while(scan.hasNextLine()) {
			//get next line
			String line = scan.nextLine();
			
			//split line delimited by commas
			String[] splitLine = line.split(",");
			ArrayList<String> splitArray = new ArrayList<>();
			for(String s : splitLine) {
				splitArray.add(s);
			}
			Actor tmpActor = new Actor();
			tmpActor.setName(splitArray.get(0));
			//remove actors name from splitArray
			splitArray.remove(0);
			
			ArrayList<Movie> tmpMovies = new ArrayList<>();
			ArrayList<Movie> allMovies = movieDB.getMovieList();
			
			//for each movie the actor has featured in
			for(String s : splitArray) {
				boolean inList = false;
				for(Movie m : allMovies) {
					//if movie already in movies list
					if(m.getName().equals(s)) {
						//add actor name to movie
						ArrayList<Actor> tmpActorsList = m.getActors();
						tmpActorsList.add(tmpActor);
						tmpMovies.add(m);
						inList = true;
					}
				}
				//movie was not in list already
				if(!inList) {
					//make new actor list for movie
					ArrayList<Actor> tmpActorsList = new ArrayList<>();
					tmpActorsList.add(tmpActor);
					//make new movie object
					Movie newMovie = new Movie(0.0, s, tmpActorsList);
					allMovies.add(newMovie);
					tmpMovies.add(newMovie);
				}
				//give actor new movie list
				tmpActor.setMovies(tmpMovies);
				
			}
			actors.add(tmpActor);
			movieDB.setMovieList(allMovies);
		}
		scan.close();
		
		//actors and movies all added to movieDB
		File ratingsFile = new File("/home/alex/eclipse-workspace/JavaSWDevEDx/MovieDatabase/moviesDatabase/ratings.txt");
		try {
			scan = new Scanner(ratingsFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//throw out first line
		scan.nextLine();
		
		//while there is still another entry
		while(scan.hasNextLine()) {
			String ratingString = scan.nextLine();
			String[] splitString= ratingString.split("\\s");
			ArrayList<String> splitArrayList = new ArrayList<>();
			for(String s : splitString) {
				splitArrayList.add(s);
			}
			int lastIndex =splitArrayList.size()-1;
			double rating = Double.parseDouble(splitArrayList.get(lastIndex));
			String movieName = "";
			splitArrayList.remove(lastIndex);
			for(int i = 0; i< splitArrayList.size(); i++) {
				movieName += " ";
				movieName += splitArrayList.get(i);
			}
			System.out.println("Movie: " + movieName);
			movieDB.updateRating(movieName, rating);
			
		}
		//close scanner for ratings.txt
		scan.close();
		
		//keep track of longest name to pad output to file
		int longestName = 0;
		for(Movie m : movieDB.getMovieList()) {
			if(m.getName().length() > longestName) longestName = m.getName().length();
		}
		//output data to file
		File outputFile = new File("/home/alex/eclipse-workspace/JavaSWDevEDx/MovieDatabase/moviesDatabase/output.txt");
		PrintWriter writer = new PrintWriter(outputFile);
		
		for(Movie m : movieDB.getMovieList()) {
			char[] charArray = new char[longestName - m.getName().length() + 1];
			Arrays.fill(charArray, ' ');
			String padded = new String(charArray);
			String ratingString;
			if(m.getRating() != 0.0) {
				ratingString = Double.toString(m.getRating());
			}
			else {
				ratingString = "Unknown";
			}
			writer.println("Movie: " + m.getName() + padded + " Rating: " + ratingString);
		}
		
		writer.close();
	}

}

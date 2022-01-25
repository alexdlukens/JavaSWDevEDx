package moviesDatabase;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;

class MovieTest {
	private Movie movie1;
	@BeforeEach
	void setUp() throws Exception {
		ArrayList<Actor> actors = new ArrayList<>();
		ArrayList<Movie> movies = new ArrayList<>();
		Actor leo = new Actor("Leo Di", movies);
		actors.add(leo);
		movie1 = new Movie(8.8, "Inception", actors);
		assertNotNull(movie1);
	}

	@Test
	void testGetActors() {
		assertTrue(!movie1.getActors().isEmpty());
		
	}

	@Test
	void testSetActors() {
		ArrayList<Actor> actors = new ArrayList<>();
		ArrayList<Movie> movies = new ArrayList<>();
		Actor leo = new Actor("Leo Di2", movies);
		actors.add(leo);
		movie1.setActors(actors);
		
		String newName = movie1.getActors().get(0).getName();
		assertTrue(newName.equals("Leo Di2"));
	}

	@Test
	void testGetName() {
		assertTrue(movie1.getName().equals("Inception"));
	}

	@Test
	void testSetName() {
		movie1.setName("Matrix 2.0");
		assertTrue(movie1.getName().equals("Matrix 2.0"));
	}

	@Test
	void testGetRating() {
		assertTrue(movie1.getRating() == 8.8);
	}

	@Test
	void testSetRating() {
		movie1.setRating(10.0);
		assertTrue(movie1.getRating() == 10.0);
	}

}

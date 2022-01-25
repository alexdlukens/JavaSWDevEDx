package moviesDatabase;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;

class ActorTest {
	private Actor actor1;
	
	@BeforeEach
	void setUp() throws Exception {
		ArrayList<Movie> movies = new ArrayList<>();
		actor1 = new Actor("Leonardo DiCaprio", movies);
		assertNotNull(actor1);
	}

	@Test
	void testGetName() {
		assertTrue(actor1.getName().equals("Leonardo DiCaprio"));
	}

	@Test
	void testSetName() {
		actor1.setName("Leo DiCaprio");
		assertTrue(actor1.getName().equals("Leo DiCaprio"));
	}

	@Test
	void testGetMovies() {
		assertTrue(actor1.getMovies().isEmpty());
	}

	@Test
	void testSetMovies() {
		ArrayList<Movie> movies = new ArrayList<>();
		ArrayList<Actor> actors = new ArrayList<>();
		actors.add(actor1);
		Movie inception = new Movie(8.8, "Inception", actors);
		movies.add(inception);
		actor1.setMovies(movies);
		assertTrue(actor1.getMovies().contains(inception));
	}

}

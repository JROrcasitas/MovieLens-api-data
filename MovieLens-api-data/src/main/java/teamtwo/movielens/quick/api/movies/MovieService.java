package teamtwo.movielens.quick.api.movies;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//Business Service (Typically Singletons) indicated by @Service
/**
 * @author jo32
 *Business Service (Typically Singletons) indicated by @Service
 */
@Service
public class MovieService {
	
	@Autowired
	private MovieRepository mrepo;	//use JPA to connect to database
	
	public List<Movie> GetAllMovies(){
		List<Movie> topics = new ArrayList<>();
		mrepo.findAll().forEach(topics::add);
		return topics;
	}
	
	public Movie GetMovie(int id){
		return mrepo.findOne(id);
	}
	
	public void addMovie(Movie movie){
		mrepo.save(movie);
	}
	
	public void updateMovie(String id, Movie movie){
		mrepo.save(movie);
	}
	
	public void deleteMovie(int id){
		mrepo.delete(id);
	}
}

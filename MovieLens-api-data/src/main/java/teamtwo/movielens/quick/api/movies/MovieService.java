package teamtwo.movielens.quick.api.movies;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//Derby database is in the class path so not necessary to connect
//Business Service (Typically Singletons) indicated by @Service
@Service
public class MovieService {
	
	@Autowired
	private MovieRepository mrepo;
	//create mutable list
	//use JPA to connect to database
	
	public List<Movie> GetAllMovies(){
		//return topics;
		List<Movie> topics = new ArrayList<>();
		mrepo.findAll().forEach(topics::add);
		return topics;
	}
	
	public Movie GetMovie(String id){
		//return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
		return mrepo.findOne(id);
	}
	
	public void addMovie(Movie topic){
		//topics.add(topic);
		mrepo.save(topic);
	}
	
	public void updateMovie(String id, Movie topic){
		/*for(int i=0;i<topics.size(); i++){
			Topic t = topics.get(i);
			if(t.getId().equals(id)){
				topics.set(i, topic);
				return;
			}
		}*/
		mrepo.save(topic);
	}
	
	public void deleteMovie(String id){
		//topics.removeIf(t -> t.getId().equals(id));
		mrepo.delete(id);
	}
}

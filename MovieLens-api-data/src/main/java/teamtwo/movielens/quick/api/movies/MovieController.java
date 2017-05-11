package teamtwo.movielens.quick.api.movies;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author jo32
 * Movie Controller class 
 */
@RestController
public class MovieController {
	
	@Autowired
	private MovieService topicService;
	
	
	@RequestMapping("/movies")
	public List<Movie> GetAllMovies(){
		return topicService.GetAllMovies();
	}
	@RequestMapping("/movies/{id}")
	public Movie GetMovie(@PathVariable int id){
		return topicService.GetMovie(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/movies")
	public void addMovie(@RequestBody Movie topic){
		topicService.addMovie(topic);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/movies/{id}")
	public void updateMovie(@RequestBody Movie topic, @PathVariable String id){
		topicService.updateMovie(id,topic);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/movies/{id}")
	public void deleteMovie(@PathVariable int id){
		 topicService.deleteMovie(id);
	}

}

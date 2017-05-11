package teamtwo.movielens.quick.api.rating;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import teamtwo.movielens.quick.api.movies.Movie;


/**
 * @author jo32
 * Rating Controller class
 */
@RestController
public class RatingController {
	
	@Autowired
	private RatingService RatingService;
	
	
	@RequestMapping("/movies/{movieId}/ratings")
	public List<Rating> GetAllRatings(@PathVariable int movieId){
		return RatingService.GetAllRatings(movieId);
	}
	@RequestMapping("/movies/{movieId}/ratings/{id}")
	public Rating GetRating(@PathVariable int id){
		return RatingService.GetRating(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/movies/{movieId}/ratings")
	public void addRating(@RequestBody Rating rating, 
			@PathVariable int movieId)
	{
		RatingService.addRating(rating);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/movies/{movieId}/ratings")
	public void updateRating(@RequestBody Rating rating,
			@PathVariable int movieId, @PathVariable int id)
	{
		RatingService.updateRating(rating);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/movies/{movieId}/ratings")
	public void deleteRating(@PathVariable int id)
	{
		 RatingService.deleteRating(id);
	}

}

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


//controller class
@RestController
public class RatingController {
	
	@Autowired
	private RatingService RatingService;
	
	
	@RequestMapping("/movies/{id}/ratings")
	public List<Rating> GetAllRatings(@PathVariable String id){
		return RatingService.GetAllRatings(id);
	}
	//create variable portion {#}
	@RequestMapping("/movies/{movieId}/ratings/{id}")
	public Rating GetRating(@PathVariable String id){
		return RatingService.GetRating(id);
	}
	
	//map this method to any request that is a post to "ratings"
	@RequestMapping(method=RequestMethod.POST, value="/movies/{movieId}/ratings")
	public void addRating(@RequestBody Rating rating, @PathVariable String movieId){
		rating.setMovie(new Movie(movieId,"",""));
		RatingService.addRating(rating);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/movies/{movieId}/ratings/{id}")
	public void updateRating(@RequestBody Rating rating, @PathVariable String movieId, @PathVariable String id){
		rating.setMovie(new Movie(movieId,"",""));
		RatingService.updateRating(rating);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/movies/{movieId}/ratings/{id}")
	public void deleteRating(@PathVariable String id){
		 RatingService.deleteRating(id);
	}

}

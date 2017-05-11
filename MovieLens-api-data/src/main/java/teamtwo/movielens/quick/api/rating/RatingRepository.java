package teamtwo.movielens.quick.api.rating;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

//Make CRUD operations
public interface RatingRepository extends CrudRepository<Rating, Integer>{
	
	public List<Rating> findByMovieId(int movieId);

}
